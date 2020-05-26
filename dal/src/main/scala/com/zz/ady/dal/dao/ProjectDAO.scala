package com.zz.ady.dal.dao

import cats.effect.Sync
import com.zz.ady.idl.{Project, ReturnProject}
//import com.zz.ady.dal.model.Project
import doobie.implicits._
import doobie.util.transactor.Transactor

object ProjectDAO {

  def apply[F[_] : Sync](xa: Transactor[F]): ProjectDAO[F] = new ProjectDAO[F](xa)

}

class ProjectDAO[F[_] : Sync](xa: Transactor[F]) extends ProjectSql {
  def createProject(projectGroupId: Int, projectName: String, projectType: String, note: String, createdBy: Int, updatedBy: Int): F[Int] =
    createProjectSql(projectGroupId, projectName, projectType, note, createdBy, updatedBy).run.transact(xa)

  def deleteProject(id: Int): F[Int] =
    deleteProjectSql(id).run.transact(xa)

  def updateProject(project: Project): F[Int] =
    updateProjectSql(project).run.transact(xa)

  def queryProject(id: Int, projectGroupId: Int, projectGroupName: String, projectName: String, projectType: String, isDeleted: Int, pageNo: Int, pageSize: Int): F[Vector[ReturnProject]] =
    queryProjectSql(id, projectGroupId, projectGroupName, projectName, projectType, isDeleted, pageNo, pageSize).to[Vector].transact(xa)

  def countProject(id: Int, projectGroupId: Int, projectGroupName: String, projectName: String, projectType: String, isDeleted: Int): F[Int] =
    countProjectSql(id, projectGroupId, projectGroupName, projectName, projectType, isDeleted).unique.transact(xa)

  def findProjectById(id: Int): F[Option[ReturnProject]] =
    findProjectByIdSql(id).option.transact(xa)

}


