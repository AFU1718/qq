package com.zz.ady.dal.dao


import cats.effect.Sync
import com.zz.ady.idl.{ProjectGroup, ProjectGroupNameAndId}
//import com.zz.ady.dal.model.ProjectGroup
import com.zz.ady.idl.ReturnProjectGroup
import doobie.implicits._
import doobie.util.transactor.Transactor

object ProjectGroupDAO {

  def apply[F[_] : Sync](xa: Transactor[F]): ProjectGroupDAO[F] = new ProjectGroupDAO[F](xa)

}

class ProjectGroupDAO[F[_] : Sync](xa: Transactor[F]) extends ProjectGroupSql {
  def createProjectGroup(projectGroupName: String, note: String, createdBy: Int, updatedBy: Int): F[Int] =
    createProjectGroupSql(projectGroupName, note, createdBy, updatedBy).run.transact(xa)

  def deleteProjectGroup(id: Int): F[Int] =
    deleteProjectGroupSql(id).run.transact(xa)

  def updateProjectGroup(projectGroup: ProjectGroup): F[Int] =
    updateProjectGroupSql(projectGroup).run.transact(xa)

  def queryProjectGroup(optionProjectGroupName: Option[String], optionPageNo: Option[Int], optionPageSize: Option[Int]): F[Vector[ReturnProjectGroup]] =
    queryProjectGroupSql(optionProjectGroupName, optionPageNo, optionPageSize).to[Vector].transact(xa)

  def countProjectGroup(optionProjectGroupName: Option[String]): F[Int] =
    countProjectGroupSql(optionProjectGroupName).unique.transact(xa)

  def findAllProjectGroup(): F[Vector[ProjectGroupNameAndId]] = {
    findAllProjectGroupSql().to[Vector].transact(xa)
  }
  def findProjectGroupById(id: Int): F[Option[ReturnProjectGroup]] =
    findProjectGroupByIdSql(id).option.transact(xa)

}


