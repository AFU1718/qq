package com.zz.ady.dal.dao

import cats.effect.Sync
import com.zz.ady.idl.{ReturnRole, Role, RoleNameAndId}
//import com.zz.ady.dal.model.Role
import doobie.implicits._
import doobie.util.transactor.Transactor

object RoleDAO {

  def apply[F[_] : Sync](xa: Transactor[F]): RoleDAO[F] = new RoleDAO[F](xa)

}

class RoleDAO[F[_] : Sync](xa: Transactor[F]) extends RoleSql {
  def createRole(roleName: String, note: String): F[Int] =
    createRoleSql(roleName, note).run.transact(xa)

  def deleteRole(id: Int): F[Int] =
    deleteRoleSql(id).run.transact(xa)

  def updateRole(role: Role): F[Int] =
    updateRoleSql(role).run.transact(xa)

  def queryRole(optionRoleName: Option[String], optionPageNo: Option[Int], optionPageSize: Option[Int]): F[Vector[ReturnRole]] =
    queryRoleSql(optionRoleName, optionPageNo, optionPageSize).to[Vector].transact(xa)

  def countRole(optionRoleName: Option[String]): F[Int] =
    countRoleSql(optionRoleName).unique.transact(xa)

  def findAllRole(): F[Vector[RoleNameAndId]] = {
    findAllRoleSql().to[Vector].transact(xa)
  }
  def findRoleById(id: Int): F[Option[ReturnRole]] =
    findRoleByIdSql(id).option.transact(xa)

}



