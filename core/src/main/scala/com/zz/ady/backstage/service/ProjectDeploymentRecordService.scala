package com.zz.ady.backstage.service


import java.time.Instant

import cats.effect.{Effect, Sync}
import cats.implicits._
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import com.zz.ady.idl.{PostProjectDeploymentRecord, Project, ProjectDeploymentRecord, ProjectDeploymentRecordList, ReturnProject, ReturnProjectDeploymentRecord, UserInfo}
import com.zz.ady.backstage.config.AppConfig
import com.zz.ady.dal.dao.{ProjectDAO, ProjectDeploymentRecordDAO, UserInfoDAO}
//import com.zz.ady.dal.model.ProjectDeploymentRecord
import doobie.util.transactor.Transactor

object ProjectDeploymentRecordService {

  def apply[F[_] : Effect](xa: Transactor[F]): ProjectDeploymentRecordService[F] =
    new ProjectDeploymentRecordService[F](xa)

}

class ProjectDeploymentRecordService[F[_] : Effect](xa: Transactor[F]) {

  private[this] val F: Sync[F] = implicitly[Sync[F]]
  private[this] val logger = Logger(getClass)
  val effectEv: Effect[F] = implicitly

  private[this] val projectDeploymentRecordDAO: ProjectDeploymentRecordDAO[F] = ProjectDeploymentRecordDAO[F](xa)

  def createProjectDeploymentRecord(postProjectDeploymentRecord: PostProjectDeploymentRecord): F[Int] = {
    val project: F[Option[ReturnProject]] = ProjectDAO(xa).findProjectById(postProjectDeploymentRecord.projectId)
    val creatorInfo = UserInfoDAO(xa).findUserInfoById(postProjectDeploymentRecord.createdBy)
    val updaterInfo = UserInfoDAO(xa).findUserInfoById(postProjectDeploymentRecord.updatedBy)
    (project, creatorInfo, updaterInfo).tupled flatMap {
      case (Some(_), Some(_), Some(_)) =>
        projectDeploymentRecordDAO.createProjectDeploymentRecord(postProjectDeploymentRecord.projectId, postProjectDeploymentRecord.status,
          postProjectDeploymentRecord.version, postProjectDeploymentRecord.changeLog, postProjectDeploymentRecord.developers,
          postProjectDeploymentRecord.testers, Instant.parse(postProjectDeploymentRecord.deployedAt), postProjectDeploymentRecord.totalTime,
          postProjectDeploymentRecord.note, postProjectDeploymentRecord.createdBy, postProjectDeploymentRecord.updatedBy)

      case _ => F.pure(0)
    }
  }

  def deleteProjectDeploymentRecord(id: Int): F[Int] = {
    for {
      a <- projectDeploymentRecordDAO.deleteProjectDeploymentRecord(id)
    } yield a
  }

  def updateProjectDeploymentRecord(projectDeploymentRecord: ProjectDeploymentRecord): F[Int] = {
    for {
      a <- projectDeploymentRecordDAO.updateProjectDeploymentRecord(projectDeploymentRecord)
    } yield a
  }

  def queryProjectDeploymentRecord(projectId: Int, projectName: String, status: Int, pageNo: Int, pageSize: Int): F[ProjectDeploymentRecordList] = {
    for {
      returnProjectDeploymentRecordList <- projectDeploymentRecordDAO.queryProjectDeploymentRecord(projectId, projectName, status, pageNo, pageSize)
      count <- projectDeploymentRecordDAO.countProjectDeploymentRecord(projectId, projectName, status)
    } yield {
      ProjectDeploymentRecordList(
        count = count,
        size = Math.ceil(count * 1.0 / pageSize).toInt,
        index = pageNo,
        pageSize = pageSize,
        returnProjectDeploymentRecordList = returnProjectDeploymentRecordList.toList
      )
    }
  }

  def findProjectDeploymentRecordById(id: Int): F[Option[ReturnProjectDeploymentRecord]] = {
    for {
      a <- projectDeploymentRecordDAO.findProjectDeploymentRecordById(id)
    } yield a
  }


}


