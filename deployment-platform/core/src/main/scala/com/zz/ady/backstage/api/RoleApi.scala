package com.zz.ady.backstage.api

import akka.NotUsed
import akka.actor.typed.ActorSystem
import cats.effect.Effect
import cats.implicits._
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.service.RoleService
import com.zz.ady.idl.{PostRole, Role, RoleList}
//import com.zz.ady.dal.model.Role
import org.http4s.{HttpRoutes, Request, Response}
import doobie.util.transactor.Transactor
import io.circe.generic.auto._

object RoleApi {
  def apply[F[_] : Effect](xa: Transactor[F])(implicit system: ActorSystem[_]): RoleApi[F] = new RoleApi[F](xa)

}

class RoleApi[F[_]](xa: Transactor[F])(implicit val F: Effect[F], val system: ActorSystem[_]) extends SimpleJsonApi[F] {

  import RoleApi._

  private[this] val logger: Logger = Logger(getClass)

  private val service: RoleService[F] = RoleService[F](xa)

  private[this] object IdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("id")

  private[this] object RoleNameQueryParamMatcher extends OptionalQueryParamDecoderMatcher[String]("roleName")

  private[this] object IsDeletedQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("isDeleted")

  private[this] object PageNoQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageNo")

  private[this] object PageSizeQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageSize")


  def findRoleByIdR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "roles" / IntVar(id) =>
        val result: F[Pretty[Option[Role]]] = for {
          r <- service.findRoleById(id)
        } yield Pretty(r)
        result.flatMap(Ok(_))

    }
  }

  def createRoleR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@POST -> Root / "v1" / "roles" =>
        val r: F[Int] = req.as[PostRole].flatMap(service.createRole)
        r.flatMap {
          case 1 => Ok(Pretty(0, ApiStatus.Ok))
          case 0 => Ok(Pretty(0, ApiStatus.InternalServerError))
        }

    }
  }

  def deleteRoleR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case DELETE -> Root / "v1" / "roles" / IntVar(id) =>
        val r: F[Int] = service.deleteRole(id)
        r.flatMap {
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(ApiStatus.InternalServerError))
        }
    }
  }

  def updateRoleR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@PUT -> Root / "v1" / "roles" =>
        val r: F[Int] = req.as[Role].flatMap(service.updateRole)
        r.flatMap {
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(ApiStatus.InternalServerError))
        }
    }
  }

  def queryRoleR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "roles" :? IdQueryParamMatcher(id) :? RoleNameQueryParamMatcher(roleName)
        :? IsDeletedQueryParamMatcher(isDeleted) :? PageNoQueryParamMatcher(pageNo) :? PageSizeQueryParamMatcher(pageSize) =>
        val result: F[Pretty[RoleList]] = for {
          r <- service.queryRole(id.getOrElse(-1), roleName.getOrElse(""), isDeleted.getOrElse(-1), pageNo.getOrElse(1), pageSize.getOrElse(10))
        } yield Pretty(r)
        result.flatMap(Ok(_))

    }
  }

  override val publicR: HttpRoutes[F] = findRoleByIdR <+> createRoleR <+> deleteRoleR <+> updateRoleR <+> queryRoleR


}


