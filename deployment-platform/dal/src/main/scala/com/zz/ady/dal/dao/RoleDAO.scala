package com.zz.ady.dal.dao

import cats.effect.Sync
import com.zz.ady.idl.Role
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

  def queryRole(id: Int, roleName: String, isDeleted: Int, pageNo: Int, pageSize: Int): F[Vector[Role]] =
    queryRoleSql(id, roleName, isDeleted, pageNo, pageSize).to[Vector].transact(xa)

  def countRole(id: Int, roleName: String, isDeleted: Int): F[Int] =
    countRoleSql(id, roleName, isDeleted).unique.transact(xa)

  def findRoleById(id: Int): F[Option[Role]] =
    findRoleByIdSql(id).option.transact(xa)

}



