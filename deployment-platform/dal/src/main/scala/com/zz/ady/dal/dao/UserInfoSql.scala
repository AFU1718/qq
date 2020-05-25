package com.zz.ady.dal.dao

import com.typesafe.scalalogging.Logger
import com.zz.ady.idl.{ReturnUserInfo, UserInfo}
//import com.zz.ady.dal.model.UserInfo
import doobie.implicits._
import doobie.postgres.implicits._
import doobie.util.fragment.Fragment
import doobie.util.fragments.{orOpt, whereAndOpt}

object UserInfoSql extends UserInfoSql

trait UserInfoSql extends Sql {

  private[this] val logger = Logger(getClass)

  protected val tt: String = "user_info"

  val selectA: Fragment = Fragment.const(s"select * from $tt")

  def dropTableSql: doobie.Update0 = Fragment.const(s"drop table IF EXISTS $tt").update

  def createTableSql: doobie.Update0 = Fragment.const(
    s"""create table IF NOT EXIST $tt(
             id                      serial PRIMARY KEY,                        -- 主键id
             name                    text default ''             NOT NULL,      -- 用户名
             password                text default ''             NOT NULL,      -- 用户密码
             role_id                 int4                        NOT NULL,      -- 角色id
             created_by              int4                        NOT NULL,      -- 创建人id
             updated_by              int4                        NOT NULL,      -- 最近更新人id
             created_at              timestamptz DEFAULT now()   NOT NULL,      -- 创建时间
             updated_at              timestamptz DEFAULT now()   NOT NULL,      -- 最近更新时间
             is_deleted              int2 DEFAULT 0              NOT NULL,      -- 删除标记
            );
       """).update

  def createUserInfoSql(name: String, password: String, roleId: Int): doobie.Update0 = {
    (sql"""insert into user_info
           (name, password, role_id)
           values ($name, $password, $roleId)
         """).update
  }

  def deleteUserInfoSql(id: Int): doobie.Update0 = {
    val f1 = Option(id).map(i => fr"id = $i")

    (sql"""update user_info
          set
          is_deleted = 1,
          updated_at = now()
       """.stripMargin ++ whereAndOpt(f1)).update
  }

  def updateUserInfoSql(userInfo: UserInfo): doobie.Update0 = {
    val id = userInfo.id
    val name = userInfo.name
    val password = userInfo.password
    val roleId = userInfo.roleId

    val f1 = Option(id).map(v => fr"id = $v")

    val l1 = sql"name = ${name},"
    val l2 = sql"password = ${password},"
    val l3 = sql"role_id = ${roleId},"

    (sql"""update user_info
          set
        """ ++ l1 ++ l2 ++ l3 ++
      sql"""
          updated_at = now()
        """.stripMargin ++ whereAndOpt(f1)).update
  }

  def queryUserInfoSql(id: Int, name: String, roleId: Int, roleName: String, isDeleted: Int, pageNo: Int, pageSize: Int
                  ): doobie.Query0[ReturnUserInfo] = {
    val offset = pageNo * pageSize - pageSize
    val f1 = Option(id).map(v => {
      if (v == -1) fr"1=1" else fr"id = $v"
    })
    val f2 = Option(name).map(v => {
      if ("" equals v) fr"1=1" else fr"name = $v"
    })
    val f3 = Option(roleId).map(v => {
      if (v == -1) fr"1=1" else fr"role_id = $v"
    })
    val f4 = Option(roleName).map(v => {
      if ("" equals v) fr"1=1" else fr"role_name like ${"%" + v + "%"}"
    })
    val f5 = Option(isDeleted).map(v => {
      if (v == -1) fr"1=1" else fr"is_deleted = $v"
    })

    val q =
      fr"""SELECT
              u.id,
              u.name,
              u.role_id,
              r.role_name,
              u.created_at,
              u.updated_at,
              u.is_deleted
           FROM user_info u left join role r on u.role_id = r.id
           """.stripMargin ++ whereAndOpt(f1, f2, f3, f4, f5) ++
        Fragment.const(s" order by created_at desc offset $offset limit $pageSize")
    q.query[ReturnUserInfo]
  }

  def countUserInfoSql(id: Int, name: String, roleId: Int, roleName: String, isDeleted: Int): doobie.Query0[Int] = {
    val f1 = Option(id).map(v => {
      if (v == -1) fr"1=1" else fr"id = $v"
    })
    val f2 = Option(name).map(v => {
      if ("" equals v) fr"1=1" else fr"name = $v"
    })
    val f3 = Option(roleId).map(v => {
      if (v == -1) fr"1=1" else fr"role_id = $v"
    })
    val f4 = Option(roleName).map(v => {
      if ("" equals v) fr"1=1" else fr"role_name like ${"%" + v + "%"}"
    })
    val f5 = Option(isDeleted).map(v => {
      if (v == -1) fr"1=1" else fr"is_deleted = $v"
    })
    val q =
      fr"""SELECT
                    count(u.id)
                 FROM user_info u left join role r on u.role_id = r.id
              """.stripMargin ++ whereAndOpt(f1, f2, f3, f4, f5)
    q.query[Int]
  }

  def findUserInfoByIdSql(id: Int): doobie.Query0[ReturnUserInfo] = {
    val f1 = Option(id).map(i => fr"u.id = $i")
    val f2 = Option(0).map(i => fr"u.is_deleted = $i")
    val q =
      fr"""SELECT
               u.id,
               u.name,
               u.role_id,
               r.role_name,
               u.created_at,
               u.updated_at,
               u.is_deleted
           FROM user_info u left join role r on u.role_id = r.id
           """.stripMargin ++ whereAndOpt(f1) ++ fr""" limit 1;"""
    q.query[ReturnUserInfo]
  }

}



