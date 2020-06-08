package com.zz.ady.backstage.service

import cats.effect.{Effect, Sync}
import cats.implicits._
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.config.AppConfig
import com.zz.ady.dal.dao.RoleDAO
import com.zz.ady.idl.{PostRole, ReturnRole, Role, RoleList, RoleNameAndIdList}
//import com.zz.ady.dal.model.Role
import doobie.util.transactor.Transactor

object RoleService {

  def apply[F[_] : Effect](xa: Transactor[F]): RoleService[F] =
    new RoleService[F](xa)

}

class RoleService[F[_] : Effect](xa: Transactor[F]) {

//  private[this] val F: Sync[F] = implicitly[Sync[F]]
  private[this] val logger = Logger(getClass)
  val F: Effect[F] = implicitly

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

  def queryRole(optionRoleName: Option[String], optionPageNo: Option[Int], optionPageSize: Option[Int]): F[RoleList] = {
    for {
      returnRoleList <-  roleDAO.queryRole(optionRoleName, optionPageNo, optionPageSize)
      count <- roleDAO.countRole(optionRoleName)
    } yield {
      RoleList(
        count = count,
        size = Math.ceil(count * 1.0 / optionPageSize.getOrElse(10)).toInt,
        index = optionPageNo.getOrElse(1),
        pageSize = optionPageSize.getOrElse(10),
        items = returnRoleList.toList
      )
    }

  }

  def findAllRole(): F[RoleNameAndIdList] ={
    for {
      roleNameAndIdList <- roleDAO.findAllRole()
    } yield {
      RoleNameAndIdList(
        roleNameAndIdList = roleNameAndIdList.toList
      )
    }
  }

  def findRoleById(id: Int): F[Option[ReturnRole]] = {
    for {
      a <- roleDAO.findRoleById(id)
    } yield a
  }


}




