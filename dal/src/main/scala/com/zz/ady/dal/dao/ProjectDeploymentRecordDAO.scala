package com.zz.ady.dal.dao


import java.time.Instant

import cats.effect.Sync
import com.zz.ady.dal.model.{Project, UserInfo}
import com.zz.ady.idl.{ProjectDeploymentRecord, ReturnProjectDeploymentRecord}
//import com.zz.ady.dal.model.ProjectDeploymentRecord
import doobie.implicits._
import doobie.util.transactor.Transactor


object ProjectDeploymentRecordDAO {

  def apply[F[_] : Sync](xa: Transactor[F]): ProjectDeploymentRecordDAO[F] = new ProjectDeploymentRecordDAO[F](xa)

}

class ProjectDeploymentRecordDAO[F[_] : Sync](xa: Transactor[F]) extends ProjectDeploymentRecordSql {
  def createProjectDeploymentRecord(projectId: Int, status: Int, version: String, changeLog: String, developers: String, testers: String, deployedAt: Instant, totalTime: Int, note: String, createdBy: Int, updatedBy: Int): F[Int] = {
    //    val project: F[Option[Project]] =ProjectDAO(xa).findProjectById(projectId)
    //
    //    val creatorInfo: F[Option[UserInfo]] =UserInfoDAO(xa).findUserInfoById(updatedBy)
    //    val updaterInfo: F[Option[UserInfo]] =UserInfoDAO(xa).findUserInfoById(createdBy)
    //    for {
    //      a <- project
    //      a<- List(1,2,3)
    //    }yield()
    //    (project,creatorInfo,updaterInfo) match {
    //      case (x,y,z) if x.map=>
    //      case _
    //    }

    createProjectDeploymentRecordSql(projectId, status, version, changeLog, developers, testers, deployedAt, totalTime, note, createdBy, updatedBy).run.transact(xa)


  }


  def deleteProjectDeploymentRecord(id: Int): F[Int] =
    deleteProjectDeploymentRecordSql(id).run.transact(xa)

  def updateProjectDeploymentRecord(projectDeploymentRecord: ProjectDeploymentRecord): F[Int] =
    updateProjectDeploymentRecordSql(projectDeploymentRecord).run.transact(xa)

  def queryProjectDeploymentRecord(id: Int, projectId: Int, projectName: String, status: Int, isDeleted: Int, pageNo: Int, pageSize: Int): F[Vector[ReturnProjectDeploymentRecord]] =
    queryProjectDeploymentRecordSql(id, projectId, projectName, status, isDeleted, pageNo, pageSize).to[Vector].transact(xa)

  def countProjectDeploymentRecord(id: Int, projectId: Int, projectName: String, status: Int, isDeleted: Int): F[Int] =
    countProjectDeploymentRecordSql(id, projectId, projectName, status, isDeleted).unique.transact(xa)

  def findProjectDeploymentRecordById(id: Int): F[Option[ReturnProjectDeploymentRecord]] =
    findProjectDeploymentRecordByIdSql(id).option.transact(xa)


}


