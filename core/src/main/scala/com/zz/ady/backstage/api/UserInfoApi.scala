package com.zz.ady.backstage.api

import akka.NotUsed
import akka.actor.typed.ActorSystem
import cats.effect.Effect
import cats.implicits._
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.service.UserInfoService
import com.zz.ady.idl.{PostUserInfo, QueryUserInfo, ReturnUserInfo, UserInfo, UserInfoList, UserInfoNameAndIdList}
//import com.zz.ady.dal.model.UserInfo
import org.http4s.{HttpRoutes, Request, Response}
import doobie.util.transactor.Transactor
import io.circe.generic.auto._

object UserInfoApi {
  def apply[F[_] : Effect](xa: Transactor[F])(implicit system: ActorSystem[_]): UserInfoApi[F] = new UserInfoApi[F](xa)

}

class UserInfoApi[F[_]](xa: Transactor[F])(implicit val F: Effect[F], val system: ActorSystem[_]) extends SimpleJsonApi[F] {

  import UserInfoApi._

  private[this] val logger: Logger = Logger(getClass)

  private val service: UserInfoService[F] = UserInfoService[F](xa)

  //  private[this] object IdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("id")

  private[this] object nameQueryParamMatcher extends OptionalQueryParamDecoderMatcher[String]("name")

  private[this] object RoleIdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("roleId")

  private[this] object RoleNameQueryParamMatcher extends OptionalQueryParamDecoderMatcher[String]("roleName")

  //  private[this] object IsDeletedQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("isDeleted")

  private[this] object PageNoQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageNo")

  private[this] object PageSizeQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageSize")


  def findUserInfoByIdR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "userInfo" / IntVar(id) =>
        val result: F[Pretty[Option[ReturnUserInfo]]] = for {
          r <- service.findUserInfoById(id)
        } yield Pretty(r)
        result.flatMap(Ok(_))

    }
  }

  def createUserInfoR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@POST -> Root / "v1" / "userInfo" =>
        val r: F[Int] = req.as[PostUserInfo].flatMap(service.createUserInfo)
        r.flatMap {
          case 1 => Ok(Pretty(0, ApiStatus.Ok))
          case 0 => Ok(Pretty(0, ApiStatus.InternalServerError))
        }

    }
  }

  def deleteUserInfoR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case DELETE -> Root / "v1" / "userInfo" / IntVar(id) =>
        val r: F[Int] = service.deleteUserInfo(id)
        r.flatMap {
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(ApiStatus.InternalServerError))
        }

    }
  }

  def updateUserInfoR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@PUT -> Root / "v1" / "userInfo" =>
        val r: F[Int] = req.as[UserInfo].flatMap(service.updateUserInfo)
        r.flatMap {
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(ApiStatus.InternalServerError))
        }
    }
  }

  def queryUserInfoR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@POST -> Root / "v1" / "userInfo" / "query" =>
        val result: F[Pretty[UserInfoList]] = req.as[QueryUserInfo].flatMap(query => {
          service.queryUserInfo(query.name, query.roleId, query.roleName, query.pageNo, query.pageSize)
        }).map(Pretty(_))
        result.flatMap(Ok(_))
    }
  }

  def findAllUserInfoR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "userInfo" / "nameAndId" =>
        val result: F[Pretty[UserInfoNameAndIdList]] = for {
          r <- service.findAllUserInfo()
        } yield Pretty(r)
        result.flatMap(Ok(_))

    }
  }

  override val publicR: HttpRoutes[F] = findUserInfoByIdR <+> createUserInfoR <+> deleteUserInfoR <+> updateUserInfoR <+> queryUserInfoR <+> findAllUserInfoR


}


