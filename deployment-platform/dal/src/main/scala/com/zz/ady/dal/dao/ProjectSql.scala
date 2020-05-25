package com.zz.ady.dal.dao


import com.typesafe.scalalogging.Logger
import com.zz.ady.idl.{Project, ReturnProject}
//import com.zz.ady.dal.model.Project
import doobie.implicits._
import doobie.postgres.implicits._
import doobie.util.fragment.Fragment
import doobie.util.fragments.{orOpt, whereAndOpt}

object ProjectSql extends ProjectSql

trait ProjectSql extends Sql {

  private[this] val logger = Logger(getClass)

  protected val tt: String = "project"

  val selectA: Fragment = Fragment.const(s"select * from $tt")

  def dropTableSql: doobie.Update0 = Fragment.const(s"drop table IF EXISTS $tt").update

  def createTableSql: doobie.Update0 = Fragment.const(
    s"""create table IF NOT EXIST $tt(
             id                      serial PRIMARY KEY,                        -- 主键id
             project_group_id        int4                        NOT NULL,      -- 项目组id
             project_name            text default ''             NOT NULL,      -- 项目名称
             project_type            text default ''             NOT NULL,      -- 项目类型（比如scala项目，python项目等）
             note                    text default ''             NOT NULL,      -- 备注
             created_by              int4                        NOT NULL,      -- 创建人id
             updated_by              int4                        NOT NULL,      -- 最近更新人id
             created_at              timestamptz DEFAULT now()   NOT NULL,      -- 创建时间
             updated_at              timestamptz DEFAULT now()   NOT NULL,      -- 最近更新时间
             is_deleted              int2 DEFAULT 0              NOT NULL,      -- 删除标记
            );
       """).update

  def createProjectSql(projectGroupId: Int, projectName: String, projectType: String, note: String, createdBy: Int, updatedBy: Int): doobie.Update0 = {
    (sql"""insert into project
           (project_group_id, project_name, project_type, note, created_by, updated_by)
           values ($projectGroupId, $projectName, $projectType, $note, $createdBy, $updatedBy)
         """).update
  }

  def deleteProjectSql(id: Int): doobie.Update0 = {
    val f1 = Option(id).map(i => fr"id = $i")

    (sql"""update project
          set
          is_deleted = 1,
          updated_at = now()
       """.stripMargin ++ whereAndOpt(f1)).update
  }

  def updateProjectSql(project: Project): doobie.Update0 = {
    val id = project.id
    val projectGroupId = project.projectGroupId
    val projectName = project.projectName
    val projectType = project.projectType
    val note = project.note
    val updatedBy = project.updatedBy

    val f1 = Option(id).map(v => fr"id = $v")

    val l1 = sql"project_group_id = ${projectGroupId},"
    val l2 = sql"project_name = ${projectName},"
    val l3 = sql"project_type = ${projectType},"
    val l4 = sql"note = ${note},"
    val l5 = sql"updated_by = ${updatedBy},"

    (sql"""update project
          set
        """ ++ l1 ++ l2 ++ l3 ++ l4 ++ l5 ++
      sql"""
          updated_at = now()
        """.stripMargin ++ whereAndOpt(f1)).update
  }

  def queryProjectSql(id: Int, projectGroupId: Int, projectGroupName: String, projectName: String, projectType: String, isDeleted: Int, pageNo: Int, pageSize: Int
                          ): doobie.Query0[ReturnProject] = {
    val offset = pageNo * pageSize - pageSize
    val f1 = Option(id).map(v => {
      if (v == -1) fr"1=1" else fr"p.id = $v"
    })
    val f2 = Option(projectGroupId).map(v => {
      if (v == -1) fr"1=1" else fr"p.project_group_id = $v"
    })
    val f3 = Option(projectGroupName).map(v => {
      if ("" equals v) fr"1=1" else fr"p.project_group_name like ${"%" + v + "%"}"
    })
    val f4 = Option(projectName).map(v => {
      if ("" equals v) fr"1=1" else fr"p.project_name = $v"
    })
    val f5 = Option(projectType).map(v => {
      if ("" equals v) fr"1=1" else fr"p.project_type = $v"
    })
    val f6 = Option(isDeleted).map(v => {
      if (v == -1) fr"1=1" else fr"p.is_deleted = $v"
    })

    val q =
      fr"""SELECT
              p.id,
              p.project_group_id,
              pg.project_group_name,
              p.project_name,
              p.project_type,
              p.note,
              u1.name as creator,
              u2.name as updater,
              p.created_at,
              p.updated_at,
              p.is_deleted
           FROM project p left join user_info u1 on p.created_by = u1.id left join user_info u2 on p.updated_by = u2.id
           left join project_group pg on p.project_group_id = pg.id
           """.stripMargin ++ whereAndOpt(f1, f2, f3, f4, f5, f6) ++
        Fragment.const(s" order by created_at desc offset $offset limit $pageSize")
    q.query[ReturnProject]
  }

  def countProjectSql(id: Int, projectGroupId: Int, projectGroupName: String, projectName: String, projectType: String, isDeleted: Int): doobie.Query0[Int] = {
    val f1 = Option(id).map(v => {
      if (v == -1) fr"1=1" else fr"p.id = $v"
    })
    val f2 = Option(projectGroupId).map(v => {
      if (v == -1) fr"1=1" else fr"p.project_group_id = $v"
    })
    val f3 = Option(projectGroupName).map(v => {
      if ("" equals v) fr"1=1" else fr"p.project_group_name like ${"%" + v + "%"}"
    })
    val f4 = Option(projectName).map(v => {
      if ("" equals v) fr"1=1" else fr"p.project_name = $v"
    })
    val f5 = Option(projectType).map(v => {
      if ("" equals v) fr"1=1" else fr"p.project_type = $v"
    })
    val f6 = Option(isDeleted).map(v => {
      if (v == -1) fr"1=1" else fr"p.is_deleted = $v"
    })
    val q =
      fr"""SELECT
                    count(p.id)
                 FROM project p left join project_group pg on p.project_group_id = pg.id
              """.stripMargin ++ whereAndOpt(f1, f2, f3, f4, f5, f6)
    q.query[Int]
  }


  def findProjectByIdSql(id: Int): doobie.Query0[ReturnProject] = {
    val f1 = Option(id).map(i => fr"p.id = $i")
    val f2 = Option(0).map(i => fr"p.is_deleted = $i")
    val q =
      fr"""SELECT
              p.id,
              p.project_group_id,
              pg.project_group_name,
              p.project_name,
              p.project_type,
              p.note,
              u1.name as creator,
              u2.name as updater,
              p.created_at,
              p.updated_at,
              p.is_deleted
           FROM project p left join user_info u1 on p.created_by = u1.id left join user_info u2 on p.updated_by = u2.id
           left join project_group pg on p.project_group_id = pg.id
           """.stripMargin ++ whereAndOpt(f1,f2) ++ fr""" limit 1;"""
    q.query[ReturnProject]
  }

}


