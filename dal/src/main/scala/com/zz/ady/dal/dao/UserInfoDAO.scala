package com.zz.ady.dal.dao

import cats.effect.Sync
import com.zz.ady.idl.{ReturnUserInfo, UserInfo, UserInfoNameAndId}
//import com.zz.ady.dal.model.UserInfo
import doobie.implicits._
import doobie.util.transactor.Transactor

object UserInfoDAO {

  def apply[F[_] : Sync](xa: Transactor[F]): UserInfoDAO[F] = new UserInfoDAO[F](xa)

}

class UserInfoDAO[F[_] : Sync](xa: Transactor[F]) extends UserInfoSql {
  def createUserInfo(name: String, password: String, roleId: Int): F[Int] =
    createUserInfoSql(name, password, roleId).run.transact(xa)

  def deleteUserInfo(id: Int): F[Int] =
    deleteUserInfoSql(id).run.transact(xa)

  def updateUserInfo(userInfo: UserInfo): F[Int] =
    updateUserInfoSql(userInfo).run.transact(xa)

  def queryUserInfo(optionName: Option[String], optionRoleId: Option[Int], optionRoleName: Option[String], optionPageNo: Option[Int], optionPageSize: Option[Int]): F[Vector[ReturnUserInfo]] =
    queryUserInfoSql(optionName, optionRoleId, optionRoleName, optionPageNo, optionPageSize).to[Vector].transact(xa)

  def countUserInfo(optionName: Option[String], optionRoleId: Option[Int], optionRoleName: Option[String]): F[Int] =
    countUserInfoSql(optionName, optionRoleId, optionRoleName).unique.transact(xa)

  def findAllUserInfo(): F[Vector[UserInfoNameAndId]] = {
    findAllUserInfoSql().to[Vector].transact(xa)
  }
  def findUserInfoById(id: Int): F[Option[ReturnUserInfo]] =
    findUserInfoByIdSql(id).option.transact(xa)

}



