package com.zz.ady.dal.dao

import com.typesafe.scalalogging.Logger
import com.zz.ady.idl.{ProjectGroup, ProjectGroupNameAndId}
//import com.zz.ady.dal.model.ProjectGroup
import com.zz.ady.idl.ReturnProjectGroup
import doobie.implicits._
import doobie.postgres.implicits._
import doobie.util.fragment.Fragment
import doobie.util.fragments.{orOpt, whereAndOpt}

object ProjectGroupSql extends ProjectGroupSql

trait ProjectGroupSql extends Sql {

  private[this] val logger = Logger(getClass)

  protected val tt: String = "project_group"

  val selectA: Fragment = Fragment.const(s"select * from $tt")

  def dropTableSql: doobie.Update0 = Fragment.const(s"drop table IF EXISTS $tt").update

  def createTableSql: doobie.Update0 = Fragment.const(
    s"""create table IF NOT EXIST $tt(
             id                      serial PRIMARY KEY,                        -- 主键id
             project_group_name      text default ''             NOT NULL,      -- 项目组名称
             note                    text default ''             NOT NULL,      -- 备注
             created_by              int4                        NOT NULL,      -- 创建人id
             updated_by              int4                        NOT NULL,      -- 最近更新人id
             created_at              timestamptz DEFAULT now()   NOT NULL,      -- 创建时间
             updated_at              timestamptz DEFAULT now()   NOT NULL,      -- 最近更新时间
             is_deleted              int2 DEFAULT 0              NOT NULL,      -- 删除标记
            );
       """).update

  def createProjectGroupSql(projectGroupName: String, note: String, createdBy: Int, updatedBy: Int): doobie.Update0 = {
    (sql"""insert into project_group
           (project_group_name, note, created_by, updated_by)
           values ($projectGroupName, $note, $createdBy, $updatedBy)
         """).update
  }

  def deleteProjectGroupSql(id: Int): doobie.Update0 = {
    val f1 = Option(id).map(i => fr"id = $i")

    (sql"""update project_group
          set
          is_deleted = 1,
          updated_at = now()
       """.stripMargin ++ whereAndOpt(f1)).update
  }

  def updateProjectGroupSql(projectGroup: ProjectGroup): doobie.Update0 = {
    val id = projectGroup.id
    val projectGroupName = projectGroup.projectGroupName
    val note = projectGroup.note
    val updatedBy = projectGroup.updatedBy

    val f1 = Option(id).map(v => fr"id = $v")

    val l1 = sql"project_group_name = ${projectGroupName},"
    val l2 = sql"note = ${note},"
    val l3 = sql"updated_by = ${updatedBy},"

    (sql"""update project_group
          set
        """ ++ l1 ++ l2 ++ l3 ++
      sql"""
          updated_at = now()
        """.stripMargin ++ whereAndOpt(f1)).update
  }

  def queryProjectGroupSql(projectGroupName: String, pageNo: Int, pageSize: Int
                                     ): doobie.Query0[ReturnProjectGroup] = {
    val offset = pageNo * pageSize - pageSize
//    val f1 = Option(id).map(v => {
//      if (v == -1) fr"1=1" else fr"pg.id = $v"
//    })
    val f2 = Option(projectGroupName).map(v => {
      if ("" equals v) fr"1=1" else fr"pg.project_group_name like ${"%" + v + "%"}"
    })
    val f3= Option(0).map(v => fr"pg.is_deleted = $v")

    val q =
      fr"""SELECT
              pg.id,
              pg.project_group_name,
              pg.note,
              u1.name as creator,
              u2.name as updater,
              pg.created_at,
              pg.updated_at,
              pg.is_deleted
              FROM project_group pg left join user_info u1 on pg.created_by = u1.id left join user_info u2 on pg.updated_by = u2.id
              """.stripMargin ++ whereAndOpt(f2, f3) ++
        Fragment.const(s" order by created_at desc offset $offset limit $pageSize")
    q.query[ReturnProjectGroup]
  }

  def countProjectGroupSql(projectGroupName: String): doobie.Query0[Int] = {
//    val f1 = Option(id).map(v => {
//      if (v == -1) fr"1=1" else fr"pg.id = $v"
//    })
    val f2 = Option(projectGroupName).map(v => {
      if ("" equals v) fr"1=1" else fr"pg.project_group_name like ${"%" + v + "%"}"
    })
    val f3= Option(0).map(v => fr"pg.is_deleted = $v")

    val q =
      fr"""SELECT
                    count(pg.id)
                 FROM project_group pg
              """.stripMargin ++ whereAndOpt(f2, f3)
    q.query[Int]
  }

  def findAllProjectGroupSql(): doobie.Query0[ProjectGroupNameAndId] = {
    val f1 = Option(0).map(i => fr"pg.is_deleted = $i")

    val q =
      fr"""SELECT
              pg.project_group_name,
              pg.id as project_group_id
           FROM project_group pg
           """.stripMargin ++ whereAndOpt(f1) ++
        Fragment.const(s" order by pg.created_at desc ")
    q.query[ProjectGroupNameAndId]
  }

  def findProjectGroupByIdSql(id: Int): doobie.Query0[ReturnProjectGroup] = {
    val f1 = Option(id).map(i => fr"pg.id = $i")
    val f2 = Option(0).map(i => fr"pg.is_deleted = $i")
    val q =
      fr"""SELECT
              pg.id,
              pg.project_group_name,
              pg.note,
              u1.name as creator,
              u2.name as updater,
              pg.created_at,
              pg.updated_at,
              pg.is_deleted
           FROM project_group pg left join user_info u1 on pg.created_by = u1.id left join user_info u2 on pg.updated_by = u2.id
           """.stripMargin ++ whereAndOpt(f1,f2) ++ fr""" limit 1;"""
    q.query[ReturnProjectGroup]
  }


}



