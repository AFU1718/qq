package com.zz.ady.dal.dao

import cats.effect.Sync
import com.zz.ady.idl.{Project, ProjectNameAndId, ReturnProject}
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

  def queryProject(optionProjectGroupId: Option[Int], optionProjectGroupName: Option[String], optionProjectName: Option[String], optionProjectType: Option[String], optionPageNo: Option[Int], optionPageSize: Option[Int]): F[Vector[ReturnProject]] =
    queryProjectSql(optionProjectGroupId, optionProjectGroupName, optionProjectName, optionProjectType, optionPageNo, optionPageSize).to[Vector].transact(xa)

  def countProject(optionProjectGroupId: Option[Int], optionProjectGroupName: Option[String], optionProjectName: Option[String], optionProjectType: Option[String]): F[Int] =
    countProjectSql(optionProjectGroupId, optionProjectGroupName, optionProjectName, optionProjectType).unique.transact(xa)

  def findAllProject(): F[Vector[ProjectNameAndId]] = {
    findAllProjectSql().to[Vector].transact(xa)
  }
  def findProjectById(id: Int): F[Option[ReturnProject]] =
    findProjectByIdSql(id).option.transact(xa)

}


