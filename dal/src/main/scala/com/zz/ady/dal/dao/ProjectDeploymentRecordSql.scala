package com.zz.ady.dal.dao

import java.time.Instant

import com.typesafe.scalalogging.Logger
import com.zz.ady.dal.model.UserInfo
import com.zz.ady.idl.{ProjectDeploymentRecord, ReturnProjectDeploymentRecord}
import doobie.util.Read
//import com.zz.ady.dal.model.ProjectDeploymentRecord
import doobie.implicits._
import doobie.postgres.implicits._
import doobie.util.fragment.Fragment
import doobie.util.fragments.{orOpt, whereAndOpt}

object ProjectDeploymentRecordSql extends ProjectDeploymentRecordSql

trait ProjectDeploymentRecordSql extends Sql {

  private[this] val logger = Logger(getClass)

  protected val tt: String = "project_deployment_record"

  val selectA: Fragment = Fragment.const(s"select * from $tt")

  def dropTableSql: doobie.Update0 = Fragment.const(s"drop table IF EXISTS $tt").update

  def createTableSql: doobie.Update0 = Fragment.const(
    s"""create table IF NOT EXIST $tt(
            id                      serial PRIMARY KEY,                        -- 主键id
            project_id              int4                        NOT NULL,      -- 项目id
            status                  int4                        NOT NULL,      -- 项目构建状态
            version                 text default ''             NOT NULL,      -- 版本信息
            change_log              text default ''             NOT NULL,      -- 版本更新信息
            developers              text default ''             NOT NULL,      -- 开发人员
            testers                 text default ''             NOT NULL,      -- 测试人员
            deployed_at             timestamptz                 NOT NULL,      -- 部署时间
            total_time              int4                        NOT NULL,      -- 本次迭代开发总时间（单位：天）
            note                    text                        NOT NULL,      -- 备注
            created_by              int4                        NOT NULL,      -- 创建人id
            updated_by              int4                        NOT NULL,      -- 最近更新人id
            created_at              timestamptz DEFAULT now()   NOT NULL,      -- 创建时间
            updated_at              timestamptz DEFAULT now()   NOT NULL,      -- 最近更新时间
            is_deleted              int2 DEFAULT 0              NOT NULL,      -- 删除标记
    );
  """).update


  def createProjectDeploymentRecordSql(projectId: Int, status: Int, version: String, changeLog: String, developers: String, testers: String, deployedAt: Instant, totalTime: Int, note: String, createdBy: Int, updatedBy: Int): doobie.Update0 = {
    (sql"""insert into project_deployment_record
           (project_id, status, version, change_log, developers, testers, deployed_at, total_time, note, created_by, updated_by)
           values ($projectId, $status, $version, $changeLog, $developers, $testers, $deployedAt, $totalTime, $note, $createdBy, $updatedBy)
         """).update
  }

  def deleteProjectDeploymentRecordSql(id: Int): doobie.Update0 = {
    val f1 = Option(id).map(i => fr"id = $i")

    (sql"""update project_deployment_record
          set
          is_deleted = 1,
          updated_at = now()
       """.stripMargin ++ whereAndOpt(f1)).update
  }

  def updateProjectDeploymentRecordSql(projectDeploymentRecord: ProjectDeploymentRecord): doobie.Update0 = {
    val id = projectDeploymentRecord.id
    val projectId = projectDeploymentRecord.projectId
    val status = projectDeploymentRecord.status
    val version = projectDeploymentRecord.version
    val changeLog = projectDeploymentRecord.changeLog
    val developers = projectDeploymentRecord.developers
    val testers = projectDeploymentRecord.testers
    val deployedAt = Instant.parse(projectDeploymentRecord.deployedAt)
    val totalTime = projectDeploymentRecord.totalTime
    val note = projectDeploymentRecord.note
    val updatedBy = projectDeploymentRecord.updatedBy

    val f1 = Option(id).map(v => fr"id = $v")

    val l1 = sql"project_id = ${projectId},"
    val l2 = sql"status = ${status},"
    val l3 = sql"version = ${version},"
    val l4 = sql"change_log = ${changeLog},"
    val l5 = sql"developers = ${developers},"
    val l6 = sql"testers = ${testers},"
    val l7 = sql"deployed_at = ${deployedAt},"
    val l8 = sql"total_time = ${totalTime},"
    val l9 = sql"note = ${note},"
    val l10 = sql"updated_by = ${updatedBy},"

    (sql"""update project_deployment_record
          set
        """ ++ l1 ++ l2 ++ l3 ++ l4 ++ l5 ++ l6 ++ l7 ++ l8 ++ l9 ++ l10 ++
      sql"""
          updated_at = now()
        """.stripMargin ++ whereAndOpt(f1)).update
  }

  def queryProjectDeploymentRecordSql(projectId: Int, projectName: String, status: Int, pageNo: Int, pageSize: Int
                                     ): doobie.Query0[ReturnProjectDeploymentRecord] = {
    val offset = pageNo * pageSize - pageSize
//    val f1 = Option(id).map(v => {
//      if (v == -1) fr"1=1" else fr"pdr.id = $v"
//    })
    val f2 = Option(projectId).map(v => {
      if (v == -1) fr"1=1" else fr"pdr.project_id = $v"
    })
    val f3 = Option(projectName).map(v => {
      if ("" equals v) fr"1=1" else fr"p.project_name like ${"%" + v + "%"}"
    })
    val f4 = Option(status).map(v => {
      if (v == -1) fr"1=1" else fr"pdr.status = $v"
    })
    val f5= Option(0).map(v => fr"pdr.is_deleted = $v")

    val q =
      fr"""SELECT
                  pdr.id,
                  pdr.project_id,
                  p.project_name,
                  pdr.status,
                  pdr.version,
                  pdr.change_log,
                  pdr.developers,
                  pdr.testers,
                  pdr.deployed_at,
                  pdr.total_time,
                  pdr.note,
                  u1.name as creator,
                  u2.name as updater,
                  pdr.created_at,
                  pdr.updated_at,
                  pdr.is_deleted
              FROM project_deployment_record pdr left join user_info u1 on pdr.created_by = u1.id
              left join user_info u2 on pdr.updated_by = u2.id left join project p on pdr.project_id = p.id
              """.stripMargin ++ whereAndOpt(f2, f3, f4, f5) ++
        Fragment.const(s" order by pdr.created_at desc offset $offset limit $pageSize")
    q.query[ReturnProjectDeploymentRecord]
  }

  def countProjectDeploymentRecordSql(projectId: Int, projectName: String, status: Int): doobie.Query0[Int] = {
//    val f1 = Option(id).map(v => {
//      if (v == -1) fr"1=1" else fr"pdr.id = $v"
//    })
    val f2 = Option(projectId).map(v => {
      if (v == -1) fr"1=1" else fr"pdr.project_id = $v"
    })
    val f3 = Option(projectName).map(v => {
      if ("" equals v) fr"1=1" else fr"p.project_name like ${"%" + v + "%"}"
    })
    val f4 = Option(status).map(v => {
      if (v == -1) fr"1=1" else fr"pdr.status = $v"
    })
    val f5= Option(0).map(v => fr"pdr.is_deleted = $v")

    val q =
      fr"""SELECT
                    count(pdr.id)
                 FROM project_deployment_record pdr left join project p on pdr.project_id = p.id
              """.stripMargin ++ whereAndOpt(f2, f3, f4, f5)
    q.query[Int]
  }

  def findProjectDeploymentRecordByIdSql(id: Int): doobie.Query0[ReturnProjectDeploymentRecord] = {
    val f1 = Option(id).map(i => fr"pdr.id = $i")
    val f2 = Option(0).map(i => fr"pdr.is_deleted = $i")
    val q =
      fr"""SELECT
                  pdr.id,
                  pdr.project_id,
                  p.project_name,
                  pdr.status,
                  pdr.version,
                  pdr.change_log,
                  pdr.developers,
                  pdr.testers,
                  pdr.deployed_at,
                  pdr.total_time,
                  pdr.note,
                  u1.name as creator,
                  u2.name as updater,
                  pdr.created_at,
                  pdr.updated_at,
                  pdr.is_deleted
              FROM project_deployment_record pdr left join user_info u1 on pdr.created_by = u1.id left join user_info u2 on pdr.updated_by = u2.id
              left join project p on pdr.project_id = p.id
              """.stripMargin ++ whereAndOpt(f1,f2) ++ fr""" limit 1;"""
    q.query[ReturnProjectDeploymentRecord]
  }

}


