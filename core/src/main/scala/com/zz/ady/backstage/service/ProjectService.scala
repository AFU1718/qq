package com.zz.ady.backstage.service

import cats.effect.{Effect, Sync}
import cats.implicits._
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.config.AppConfig
import com.zz.ady.dal.dao.{ProjectDAO, ProjectGroupDAO, UserInfoDAO}
import com.zz.ady.idl.{PostProject, Project, ProjectList, ProjectNameAndId, ReturnProject, ProjectNameAndIdList}
//import com.zz.ady.dal.model.Project
import doobie.util.transactor.Transactor

object ProjectService {

  def apply[F[_] : Effect](xa: Transactor[F]): ProjectService[F] =
    new ProjectService[F](xa)

}

class ProjectService[F[_] : Effect](xa: Transactor[F]) {

//  private[this] val F: Sync[F] = implicitly[Sync[F]]
  private[this] val logger = Logger(getClass)
  val F: Effect[F] = implicitly

  private[this] val projectDAO: ProjectDAO[F] = ProjectDAO[F](xa)


  def createProject(postProject: PostProject): F[Int] = {
    val projectGroup=ProjectGroupDAO(xa).findProjectGroupById(postProject.projectGroupId)
    val creatorInfo= UserInfoDAO(xa).findUserInfoById(postProject.createdBy)
    val updaterInfo= UserInfoDAO(xa).findUserInfoById(postProject.updatedBy)
    (projectGroup, creatorInfo, updaterInfo).tupled flatMap {
      case (Some(_), Some(_), Some(_)) =>
        projectDAO.createProject(postProject.projectGroupId, postProject.projectName, postProject.projectType, postProject.note, postProject.createdBy, postProject.updatedBy)
      case _ => F.pure(0)
    }
  }

  def deleteProject(id: Int): F[Int] = {
    for {
      a <- projectDAO.deleteProject(id)
    } yield a
  }

  def updateProject(project: Project): F[Int] = {
    for {
      a <- projectDAO.updateProject(project)
    } yield a
  }

  def queryProject(optionProjectGroupId: Option[Int], optionProjectGroupName: Option[String], optionProjectName: Option[String], optionProjectType: Option[String], optionPageNo: Option[Int], optionPageSize: Option[Int]): F[ProjectList] = {
    for {
      returnProjectList <- projectDAO.queryProject(optionProjectGroupId, optionProjectGroupName, optionProjectName, optionProjectType, optionPageNo, optionPageSize)
      count <- projectDAO.countProject(optionProjectGroupId, optionProjectGroupName, optionProjectName, optionProjectType)
    } yield {
      ProjectList(
        count = count,
        size = Math.ceil(count * 1.0 / optionPageSize.getOrElse(10)).toInt,
        index = optionPageNo.getOrElse(1),
        pageSize = optionPageSize.getOrElse(10),
        returnProjectList = returnProjectList.toList
      )
    }

  }
  def findAllProject(): F[ProjectNameAndIdList] ={
    for {
      projectNameAndIdList <- projectDAO.findAllProject()
    } yield {
      ProjectNameAndIdList(
        projectNameAndIdList = projectNameAndIdList.toList
      )
    }
  }

  def findProjectById(id: Int): F[Option[ReturnProject]] = {
    for {
      a <- projectDAO.findProjectById(id)
    } yield a
  }


}



