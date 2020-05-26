package com.zz.ady.dal.database

import java.time.Instant

import cats.implicits._
import cats.effect.{Effect, IO}
//import com.zz.ady.dal.dao._
//import doobie.implicits._
//import com.zz.ady.dal.model._
//import com.zz.ady.dal.service.AuthUserService
//import com.zz.ady.dal.dao.{AuthGroupSql, AuthPermissionSql, AuthUserGroupsSql, AuthUserSql}
//import com.zz.ady.dal.model.AuthUser
//import com.zz.ady.dal.model.UserStatus.Active

object DatabaseMigration {

  def apply[F[_]: Effect: DatabaseComponent](): DatabaseMigration[F] = new DatabaseMigration[F]

}

class DatabaseMigration[F[_]: Effect](implicit dc: DatabaseComponent[F]) {

//  val authUserService: AuthUserService[F] = AuthUserService[F]()
//
//  def dropAllTables: F[List[Int]] =
//    List(
//        AuthUserSql.dropTable
//      , AuthGroupSql.dropTable
//      , AuthUserGroupsSql.dropTable
//      , AuthPermissionSql.dropTable
//    ).map(_.run.transact(dc.xa)).sequence
//
//  def createAllTables: F[List[Int]] =
//    List(
//        AuthUserSql.createTable
//      , AuthGroupSql.createTable
//      , AuthUserGroupsSql.createTable
//      , AuthPermissionSql.createTable
//    ).map(_.run.transact(dc.xa)).sequence
//
//  def fillDev: F[List[Either[String, AuthUser]]] = {
//    (1 to 10).toList
//      .map { i =>
//        AuthUser(
//            id = 0L
//          , createdAt = Instant.now
//          , updatedAt = Instant.now
//          , status = Active
//          , username = s"user-$i"
//          , email = s"email-$i@simple.com"
//          , password = "******"
//          , firstName = "fr"
//          , lastName = "la"
//          , isStaff = true
//          , isSuperuser = true
//          , lastLoginAt = Instant.now
//        )
//      }
//      .map(authUserService.register)
//      .sequence
//  }
//
//  def initDB: F[Unit] = {
//    for {
//      _ <- this.dropAllTables
//      _ <- this.createAllTables
//    } yield ()
//  }

}

object DatabaseMigrationIO {
  def apply()(implicit dc: DatabaseComponent[IO]): DatabaseMigration[IO] = DatabaseMigration[IO]()
}
