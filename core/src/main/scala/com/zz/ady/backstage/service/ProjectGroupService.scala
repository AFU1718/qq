package com.zz.ady.backstage.service

import cats.effect.{Effect, Sync}
import cats.implicits._
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.config.AppConfig
import com.zz.ady.dal.dao.{ProjectGroupDAO, UserInfoDAO}
import com.zz.ady.idl.{PostProjectGroup, ProjectGroup, ProjectGroupList, ProjectGroupNameAndIdList, ReturnProjectGroup, UserInfo}
//import com.zz.ady.dal.model.ProjectGroup
import doobie.util.transactor.Transactor

object ProjectGroupService {

  def apply[F[_] : Effect](xa: Transactor[F]): ProjectGroupService[F] =
    new ProjectGroupService[F](xa)

}

class ProjectGroupService[F[_] : Effect](xa: Transactor[F]) {

//  private[this] val F: Sync[F] = implicitly[Sync[F]]
  private[this] val logger = Logger(getClass)
  val F: Effect[F] = implicitly

  private[this] val projectGroupDAO: ProjectGroupDAO[F] = ProjectGroupDAO[F](xa)


  def createProjectGroup(postProjectGroup: PostProjectGroup): F[Int] = {
    val creatorInfo = UserInfoDAO(xa).findUserInfoById(postProjectGroup.createdBy)
    val updaterInfo = UserInfoDAO(xa).findUserInfoById(postProjectGroup.updatedBy)
    (creatorInfo, updaterInfo).tupled flatMap {
      case (Some(_), Some(_)) =>
        projectGroupDAO.createProjectGroup(postProjectGroup.projectGroupName, postProjectGroup.note, postProjectGroup.createdBy, postProjectGroup.updatedBy)
      case _ => F.pure(0)
    }
  }

  def deleteProjectGroup(id: Int): F[Int] = {
    for {
      a <- projectGroupDAO.deleteProjectGroup(id)
    } yield a
  }

  def updateProjectGroup(projectGroup: ProjectGroup): F[Int] = {
    for {
      a <- projectGroupDAO.updateProjectGroup(projectGroup)
    } yield a
  }

  def queryProjectGroup(optionProjectGroupName: Option[String], optionPageNo: Option[Int], optionPageSize: Option[Int]): F[ProjectGroupList] = {
    for {
      returnProjectGroupList <- projectGroupDAO.queryProjectGroup(optionProjectGroupName, optionPageNo, optionPageSize)
      count <- projectGroupDAO.countProjectGroup(optionProjectGroupName)
    } yield {
      ProjectGroupList(
        count = count,
        size = Math.ceil(count * 1.0 / optionPageSize.getOrElse(10)).toInt,
        index = optionPageNo.getOrElse(1),
        pageSize = optionPageSize.getOrElse(10),
        returnProjectGroupList = returnProjectGroupList.toList
      )
    }
  }

  def findAllProjectGroup(): F[ProjectGroupNameAndIdList] ={
    for {
      projectGroupNameAndIdList <- projectGroupDAO.findAllProjectGroup()
    } yield {
      ProjectGroupNameAndIdList(
        projectGroupNameAndIdList = projectGroupNameAndIdList.toList
      )
    }
  }

  def findProjectGroupById(id: Int): F[Option[ReturnProjectGroup]] = {
    for {
      a <- projectGroupDAO.findProjectGroupById(id)
    } yield a
  }


}




