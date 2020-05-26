package com.zz.ady.backstage.api

import akka.NotUsed
import akka.actor.typed.ActorSystem
import cats.effect.Effect
import cats.implicits._
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.service.ProjectGroupService
import com.zz.ady.idl.{PostProjectDeploymentRecord, PostProjectGroup, ProjectGroup, ProjectGroupList, ProjectGroupNameAndIdList, ReturnProjectGroup}
//import com.zz.ady.dal.model.ProjectGroup
import org.http4s.{HttpRoutes, Request, Response}
import doobie.util.transactor.Transactor
import io.circe.generic.auto._

object ProjectGroupApi {
  def apply[F[_] : Effect](xa: Transactor[F])(implicit system: ActorSystem[_]): ProjectGroupApi[F] = new ProjectGroupApi[F](xa)

}

class ProjectGroupApi[F[_]](xa: Transactor[F])(implicit val F: Effect[F], val system: ActorSystem[_]) extends SimpleJsonApi[F] {

  import ProjectGroupApi._

  private[this] val logger: Logger = Logger(getClass)

  private val service: ProjectGroupService[F] = ProjectGroupService[F](xa)

//  private[this] object IdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("id")

  private[this] object ProjectGroupNameQueryParamMatcher extends OptionalQueryParamDecoderMatcher[String]("projectGroupName")

//  private[this] object IsDeletedQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("isDeleted")

  private[this] object PageNoQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageNo")

  private[this] object PageSizeQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageSize")


  def findProjectGroupByIdR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "projectGroups" / IntVar(id) =>
        val result: F[Pretty[Option[ReturnProjectGroup]]] = for {
          r <- service.findProjectGroupById(id)
        } yield Pretty(r)
        result.flatMap(Ok(_))
    }
  }

  def createProjectGroupR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@POST -> Root / "v1" / "projectGroups" =>
        val r: F[Int] = req.as[PostProjectGroup].flatMap(service.createProjectGroup)
        r.flatMap {
          case 1 => Ok(Pretty(0,ApiStatus.Ok))
          case 0 => Ok(Pretty(0,ApiStatus.InternalServerError))
        }

    }
  }

  def deleteProjectGroupR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case DELETE -> Root / "v1" / "projectGroups" / IntVar(id) =>
        val r: F[Int] = service.deleteProjectGroup(id)
        r.flatMap {
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(ApiStatus.InternalServerError))
        }
    }
  }

  def updateProjectGroupR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@PUT -> Root / "v1" / "projectGroups" =>
        val r: F[Int] = req.as[ProjectGroup].flatMap(service.updateProjectGroup)
        r.flatMap {
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(ApiStatus.InternalServerError))
        }

    }
  }

  def queryProjectGroupR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "projectGroups" :? ProjectGroupNameQueryParamMatcher(projectGroupName)
        :? PageNoQueryParamMatcher(pageNo) :? PageSizeQueryParamMatcher(pageSize) =>
        val result: F[Pretty[ProjectGroupList]] = for {
          r <- service.queryProjectGroup(projectGroupName.getOrElse(""), pageNo.getOrElse(1), pageSize.getOrElse(10))
        } yield Pretty(r)
        result.flatMap(Ok(_))
    }
  }

  def findAllProjectGroupR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "projectGroups" / "nameAndId" =>
        val result: F[Pretty[ProjectGroupNameAndIdList]] = for {
          r <- service.findAllProjectGroup()
        } yield Pretty(r)
        result.flatMap(Ok(_))

    }
  }
  override val publicR: HttpRoutes[F] = findProjectGroupByIdR <+> createProjectGroupR <+> deleteProjectGroupR <+> updateProjectGroupR <+> queryProjectGroupR <+> findAllProjectGroupR


}

