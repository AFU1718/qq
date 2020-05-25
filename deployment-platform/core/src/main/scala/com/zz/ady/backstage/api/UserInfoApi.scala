package com.zz.ady.backstage.api

import akka.NotUsed
import akka.actor.typed.ActorSystem
import cats.effect.Effect
import cats.implicits._
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.service.UserInfoService
import com.zz.ady.idl.{PostUserInfo, ReturnUserInfo, UserInfo, UserInfoList}
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

  private[this] object IdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("id")

  private[this] object nameQueryParamMatcher extends OptionalQueryParamDecoderMatcher[String]("name")

  private[this] object RoleIdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("roleId")

  private[this] object RoleNameQueryParamMatcher extends OptionalQueryParamDecoderMatcher[String]("roleName")

  private[this] object IsDeletedQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("isDeleted")

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
      case GET -> Root / "v1" / "userInfo" :? IdQueryParamMatcher(id) :? nameQueryParamMatcher(name)
        :? RoleIdQueryParamMatcher(roleId) :? RoleNameQueryParamMatcher(roleName)
        :? IsDeletedQueryParamMatcher(isDeleted)
        :? PageNoQueryParamMatcher(pageNo) :? PageSizeQueryParamMatcher(pageSize) =>
        val result: F[Pretty[UserInfoList]] = for {
          r <- service.queryUserInfo(id.getOrElse(-1), name.getOrElse(""),roleId.getOrElse(-1), roleName.getOrElse(""), isDeleted.getOrElse(-1), pageNo.getOrElse(1), pageSize.getOrElse(10))
        } yield Pretty(r)
        result.flatMap(Ok(_))

    }
  }

  override val publicR: HttpRoutes[F] = findUserInfoByIdR <+> createUserInfoR <+> deleteUserInfoR <+> updateUserInfoR <+> queryUserInfoR


}


