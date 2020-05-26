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

  def queryUserInfo(name: String, roleId: Int, roleName: String, pageNo: Int, pageSize: Int): F[Vector[ReturnUserInfo]] =
    queryUserInfoSql(name, roleId, roleName, pageNo, pageSize).to[Vector].transact(xa)

  def countUserInfo(name: String, roleId: Int, roleName: String): F[Int] =
    countUserInfoSql(name, roleId, roleName).unique.transact(xa)

  def findAllUserInfo(): F[Vector[UserInfoNameAndId]] = {
    findAllUserInfoSql().to[Vector].transact(xa)
  }
  def findUserInfoById(id: Int): F[Option[ReturnUserInfo]] =
    findUserInfoByIdSql(id).option.transact(xa)

}


