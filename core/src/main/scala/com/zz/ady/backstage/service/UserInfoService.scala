package com.zz.ady.backstage.service

import cats.effect.{Effect, Sync}
import cats.implicits._
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.config.AppConfig
import com.zz.ady.dal.dao.UserInfoDAO
import com.zz.ady.idl.{PostUserInfo, ReturnUserInfo, UserInfo, UserInfoList, UserInfoNameAndIdList}
//import com.zz.ady.dal.model.UserInfo
import doobie.util.transactor.Transactor

object UserInfoService {

  def apply[F[_] : Effect](xa: Transactor[F]): UserInfoService[F] =
    new UserInfoService[F](xa)

}

class UserInfoService[F[_] : Effect](xa: Transactor[F]) {

//  private[this] val F: Sync[F] = implicitly[Sync[F]]
  private[this] val logger = Logger(getClass)
  val F: Effect[F] = implicitly

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

  def queryUserInfo(optionName: Option[String], optionRoleId: Option[Int], optionRoleName: Option[String], optionPageNo: Option[Int], optionPageSize: Option[Int]): F[UserInfoList] = {
    for {
      returnUserInfoList <- userInfoDAO.queryUserInfo(optionName, optionRoleId, optionRoleName, optionPageNo, optionPageSize)
      count <- userInfoDAO.countUserInfo(optionName, optionRoleId, optionRoleName)
    } yield {
      UserInfoList(
        count = count,
        size = Math.ceil(count * 1.0 / optionPageSize.getOrElse(10)).toInt,
        index = optionPageNo.getOrElse(1),
        pageSize = optionPageSize.getOrElse(10),
        returnUserInfoList = returnUserInfoList.toList
      )
    }
  }

  def findAllUserInfo(): F[UserInfoNameAndIdList] ={
    for {
      userInfoNameAndIdList <- userInfoDAO.findAllUserInfo()
    } yield {
      UserInfoNameAndIdList(
        userInfoNameAndIdList = userInfoNameAndIdList.toList
      )
    }
  }

  def findUserInfoById(id: Int): F[Option[ReturnUserInfo]] = {
    for {
      a <- userInfoDAO.findUserInfoById(id)
    } yield a
  }


}




