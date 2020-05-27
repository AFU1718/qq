package com.zz.ady.dal.dao

import com.typesafe.scalalogging.Logger
import com.zz.ady.idl.{ReturnRole, Role, RoleNameAndId}
//import com.zz.ady.dal.model.Role
import doobie.implicits._
import doobie.postgres.implicits._
import doobie.util.fragment.Fragment
import doobie.util.fragments.{orOpt, whereAndOpt}

object RoleSql extends RoleSql

trait RoleSql extends Sql {

  private[this] val logger = Logger(getClass)

  protected val tt: String = "role"

  val selectA: Fragment = Fragment.const(s"select * from $tt")

  def dropTableSql: doobie.Update0 = Fragment.const(s"drop table IF EXISTS $tt").update

  def createTableSql: doobie.Update0 = Fragment.const(
    s"""create table IF NOT EXIST $tt(
             id                      serial PRIMARY KEY,                        -- 主键id
             role_name               text default ''             NOT NULL,      -- 角色名
             note                    text default ''             NOT NULL,      -- 备注
             created_by              int4                        NOT NULL,      -- 创建人id
             updated_by              int4                        NOT NULL,      -- 最近更新人id
             created_at              timestamptz DEFAULT now()   NOT NULL,      -- 创建时间
             updated_at              timestamptz DEFAULT now()   NOT NULL,      -- 最近更新时间
             is_deleted              int2 DEFAULT 0              NOT NULL,      -- 删除标记
            );
       """).update

  def createRoleSql(roleName: String, note: String): doobie.Update0 = {
    (sql"""insert into role
           (role_name, note)
           values ($roleName, $note)
         """).update
  }

  def deleteRoleSql(id: Int): doobie.Update0 = {
    val f1 = Option(id).map(i => fr"id = $i")

    (sql"""update role
          set
          is_deleted = 1,
          updated_at = now()
       """.stripMargin ++ whereAndOpt(f1)).update
  }

  def updateRoleSql(role: Role): doobie.Update0 = {
    val id = role.id
    val roleName = role.roleName
    val note = role.note

    val f1 = Option(id).map(v => fr"id = $v")

    val l1 = sql"role_name = ${roleName},"
    val l2 = sql"note = ${note},"

    (sql"""update role
          set
        """ ++ l1 ++ l2 ++
      sql"""
          updated_at = now()
        """.stripMargin ++ whereAndOpt(f1)).update
  }

  def queryRoleSql(optionRoleName: Option[String], optionPageNo: Option[Int], optionPageSize: Option[Int]
                  ): doobie.Query0[ReturnRole] = {
    val pageNo = optionPageNo.getOrElse(1)
    val pageSize = optionPageSize.getOrElse(10)
    val offset = pageNo * pageSize - pageSize
    //    val f1 = Option(id).map(v => {
    //      if (v == -1) fr"1=1" else fr"r.id = $v"
    //    })
    val f2 = optionRoleName.map(v => fr"r.role_name = $v")
    val f3 = Option(0).map(v => fr"r.is_deleted = $v")

    val q =
      fr"""SELECT
              r.id,
              r.role_name,
              r.note,
              r.created_at,
              r.updated_at
           FROM role r
           """.stripMargin ++ whereAndOpt(f2, f3) ++
        Fragment.const(s" order by created_at desc offset $offset limit $pageSize")
    q.query[ReturnRole]
  }

  def countRoleSql(optionRoleName: Option[String]): doobie.Query0[Int] = {
    //    val f1 = Option(id).map(v => {
    //      if (v == -1) fr"1=1" else fr"r.id = $v"
    //    })
    val f2 = optionRoleName.map(v => fr"r.role_name = $v")
    val f3 = Option(0).map(v => fr"r.is_deleted = $v")
    val q =
      fr"""SELECT
                    count(r.id)
                 FROM role r
              """.stripMargin ++ whereAndOpt(f2, f3)
    q.query[Int]
  }

  def findAllRoleSql(): doobie.Query0[RoleNameAndId] = {
    val f1 = Option(0).map(i => fr"r.is_deleted = $i")

    val q =
      fr"""SELECT
              r.role_name,
              r.id as role_id
           FROM role r
           """.stripMargin ++ whereAndOpt(f1) ++
        Fragment.const(s" order by r.created_at desc ")
    q.query[RoleNameAndId]
  }


  def findRoleByIdSql(id: Int): doobie.Query0[ReturnRole] = {
    val f1 = Option(id).map(i => fr"id = $i")
    val f2 = Option(0).map(i => fr"is_deleted = $i")
    val q =
      fr"""SELECT
              id,
              role_name,
              note,
              created_at,
              updated_at
           FROM role
           """.stripMargin ++ whereAndOpt(f1, f2) ++ fr""" limit 1;"""
    q.query[ReturnRole]
  }

}



