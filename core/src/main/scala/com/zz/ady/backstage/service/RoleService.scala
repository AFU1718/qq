package com.zz.ady.backstage.service

import cats.effect.{Effect, Sync}
import cats.implicits._
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.config.AppConfig
import com.zz.ady.dal.dao.RoleDAO
import com.zz.ady.idl.{PostRole, Role, RoleList}
//import com.zz.ady.dal.model.Role
import doobie.util.transactor.Transactor

object RoleService {

  def apply[F[_] : Effect](xa: Transactor[F]): RoleService[F] =
    new RoleService[F](xa)

}

class RoleService[F[_] : Effect](xa: Transactor[F]) {

  private[this] val F: Sync[F] = implicitly[Sync[F]]
  private[this] val logger = Logger(getClass)
  val effectEv: Effect[F] = implicitly

  private[this] val roleDAO: RoleDAO[F] = RoleDAO[F](xa)


  def createRole(postRole: PostRole): F[Int] = {
    for {
      a <- roleDAO.createRole(postRole.roleName, postRole.note)
    } yield a
  }

  def deleteRole(id: Int): F[Int] = {
    for {
      a <- roleDAO.deleteRole(id)
    } yield a
  }

  def updateRole(role: Role): F[Int] = {
    for {
      a <- roleDAO.updateRole(role)
    } yield a
  }

  def queryRole(id: Int, roleName: String, isDeleted: Int, pageNo: Int, pageSize: Int): F[RoleList] = {
    for {
      roleList <-  roleDAO.queryRole(id, roleName, isDeleted, pageNo, pageSize)
      count <- roleDAO.countRole(id, roleName, isDeleted)
    } yield {
      RoleList(
        count = count,
        size = Math.ceil(count * 1.0 / pageSize).toInt,
        index = pageNo,
        pageSize = pageSize,
        roleList = roleList.toList
      )
    }

  }

  def findRoleById(id: Int): F[Option[Role]] = {
    for {
      a <- roleDAO.findRoleById(id)
    } yield a
  }


}




