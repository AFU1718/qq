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

  def queryProjectGroup(projectGroupName: String, pageNo: Int, pageSize: Int): F[Vector[ReturnProjectGroup]] =
    queryProjectGroupSql(projectGroupName, pageNo, pageSize).to[Vector].transact(xa)

  def countProjectGroup(projectGroupName: String): F[Int] =
    countProjectGroupSql(projectGroupName).unique.transact(xa)

  def findAllProjectGroup(): F[Vector[ProjectGroupNameAndId]] = {
    findAllProjectGroupSql().to[Vector].transact(xa)
  }
  def findProjectGroupById(id: Int): F[Option[ReturnProjectGroup]] =
    findProjectGroupByIdSql(id).option.transact(xa)

}


