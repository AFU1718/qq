package com.zz.ady.backstage.service


import java.time.Instant

import cats.effect.{Effect, Sync}
import cats.implicits._
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import com.zz.ady.idl.{PostProjectDeploymentRecord, Project, ProjectDeploymentRecord, ProjectDeploymentRecordList, PutProjectDeploymentRecord, ReturnProject, ReturnProjectDeploymentRecord, UserInfo}
import com.zz.ady.backstage.config.AppConfig
import com.zz.ady.dal.dao.{ProjectDAO, ProjectDeploymentRecordDAO, UserInfoDAO}
//import com.zz.ady.dal.model.ProjectDeploymentRecord
import doobie.util.transactor.Transactor
import com.zz.ady.common.util.TimeTransUtil._

object ProjectDeploymentRecordService {

  def apply[F[_] : Effect](xa: Transactor[F]): ProjectDeploymentRecordService[F] =
    new ProjectDeploymentRecordService[F](xa)

}

class ProjectDeploymentRecordService[F[_] : Effect](xa: Transactor[F]) {

  //  private[this] val F: Sync[F] = implicitly[Sync[F]]
  private[this] val logger = Logger(getClass)
  val F: Effect[F] = implicitly

  private[this] val projectDeploymentRecordDAO: ProjectDeploymentRecordDAO[F] = ProjectDeploymentRecordDAO[F](xa)

  def createProjectDeploymentRecord(postRecord: PostProjectDeploymentRecord): F[Int] = {
    val project: F[Option[ReturnProject]] = ProjectDAO(xa).findProjectById(postRecord.projectId)
    val creatorInfo = UserInfoDAO(xa).findUserInfoById(postRecord.createdBy)
    val updaterInfo = UserInfoDAO(xa).findUserInfoById(postRecord.updatedBy)
    (project, creatorInfo, updaterInfo).tupled flatMap {
      case (Some(_), Some(_), Some(_)) =>
        projectDeploymentRecordDAO.createProjectDeploymentRecord(postRecord.projectId, postRecord.status,
          postRecord.version, postRecord.changeLog, postRecord.developers,
          postRecord.testers, stringToInstant(timestamp2String2(postRecord.deployedAt.toLong)), postRecord.totalTime,
          postRecord.note, postRecord.createdBy, postRecord.updatedBy)

      case _ => F.pure(0)
    }
  }

  def deleteProjectDeploymentRecord(id: Int): F[Int] = {
    for {
      a <- projectDeploymentRecordDAO.deleteProjectDeploymentRecord(id)
    } yield a
  }

  def updateProjectDeploymentRecord(putProjectDeploymentRecord: PutProjectDeploymentRecord): F[Int] = {
    for {
      a <- projectDeploymentRecordDAO.updateProjectDeploymentRecord(putProjectDeploymentRecord)
    } yield a
  }

  def queryProjectDeploymentRecord(optionProjectId: Option[Int], optionProjectName: Option[String], optionStatus: Option[Int], optionPageNo: Option[Int], optionPageSize: Option[Int]): F[ProjectDeploymentRecordList] = {
    for {
      returnProjectDeploymentRecordList <- projectDeploymentRecordDAO.queryProjectDeploymentRecord(optionProjectId, optionProjectName, optionStatus, optionPageNo, optionPageSize)
      count <- projectDeploymentRecordDAO.countProjectDeploymentRecord(optionProjectId, optionProjectName, optionStatus)
    } yield {
      ProjectDeploymentRecordList(
        total = count,
        pageNo = optionPageNo.getOrElse(1),
        pageSize = optionPageSize.getOrElse(10),
        size = Math.ceil(count * 1.0 / optionPageSize.getOrElse(10)).toInt,
        items = returnProjectDeploymentRecordList.toList
      )
    }
  }

  def findProjectDeploymentRecordById(id: Int): F[Option[ReturnProjectDeploymentRecord]] = {
    for {
      a <- projectDeploymentRecordDAO.findProjectDeploymentRecordById(id)
    } yield a
  }


}


