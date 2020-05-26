package com.zz.ady.backstage.service

import cats.effect.{Effect, Sync}
import cats.implicits._
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.config.AppConfig
import com.zz.ady.dal.dao.UserInfoDAO
import com.zz.ady.idl.{PostUserInfo, ReturnUserInfo, UserInfo, UserInfoList}
//import com.zz.ady.dal.model.UserInfo
import doobie.util.transactor.Transactor

object UserInfoService {

  def apply[F[_] : Effect](xa: Transactor[F]): UserInfoService[F] =
    new UserInfoService[F](xa)

}

class UserInfoService[F[_] : Effect](xa: Transactor[F]) {

  private[this] val F: Sync[F] = implicitly[Sync[F]]
  private[this] val logger = Logger(getClass)
  val effectEv: Effect[F] = implicitly

  private[this] val userInfoDAO: UserInfoDAO[F] = UserInfoDAO[F](xa)


  def createUserInfo(postUserInfo: PostUserInfo): F[Int] = {
    for {
      a <- userInfoDAO.createUserInfo(postUserInfo.name, postUserInfo.password, postUserInfo.roleId)
    } yield a
  }

  def deleteUserInfo(id: Int): F[Int] = {
    for {
      a <- userInfoDAO.deleteUserInfo(id)
    } yield a
  }

  def updateUserInfo(userInfo: UserInfo): F[Int] = {
    for {
      a <- userInfoDAO.updateUserInfo(userInfo)
    } yield a
  }

  def queryUserInfo(id: Int, name: String, roleId: Int, roleName: String, isDeleted: Int, pageNo: Int, pageSize: Int): F[UserInfoList] = {
    for {
      returnUserInfoList <- userInfoDAO.queryUserInfo(id, name, roleId, roleName, isDeleted, pageNo, pageSize)
      count <- userInfoDAO.countUserInfo(id, name, roleId, roleName, isDeleted)
    } yield {
      UserInfoList(
        count = count,
        size = Math.ceil(count * 1.0 / pageSize).toInt,
        index = pageNo,
        pageSize = pageSize,
        returnUserInfoList = returnUserInfoList.toList
      )
    }
  }

  def findUserInfoById(id: Int): F[Option[ReturnUserInfo]] = {
    for {
      a <- userInfoDAO.findUserInfoById(id)
    } yield a
  }


}




