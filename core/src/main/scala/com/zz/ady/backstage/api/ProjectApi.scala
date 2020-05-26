package com.zz.ady.backstage.api

import akka.NotUsed
import akka.actor.typed.ActorSystem
import cats.effect.Effect
import cats.implicits._
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.service.ProjectService
import com.zz.ady.idl.{PostProject, Project, ProjectList, ProjectNameAndId, ProjectNameAndIdList, ReturnProject}
//import com.zz.ady.dal.model.Project
import org.http4s.{HttpRoutes, Request, Response}
import doobie.util.transactor.Transactor
import io.circe.generic.auto._

object ProjectApi {
  def apply[F[_] : Effect](xa: Transactor[F])(implicit system: ActorSystem[_]): ProjectApi[F] = new ProjectApi[F](xa)

}

class ProjectApi[F[_]](xa: Transactor[F])(implicit val F: Effect[F], val system: ActorSystem[_]) extends SimpleJsonApi[F] {

  import ProjectApi._

  private[this] val logger: Logger = Logger(getClass)

  private val service: ProjectService[F] = ProjectService[F](xa)

//  private[this] object IdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("id")

  private[this] object ProjectGroupIdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("projectGroupId")

  private[this] object ProjectGroupNameQueryParamMatcher extends OptionalQueryParamDecoderMatcher[String]("projectGroupName")

  private[this] object ProjectNameQueryParamMatcher extends OptionalQueryParamDecoderMatcher[String]("projectName")

  private[this] object ProjectTypeQueryParamMatcher extends OptionalQueryParamDecoderMatcher[String]("projectType")

//  private[this] object IsDeletedQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("isDeleted")

  private[this] object PageNoQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageNo")

  private[this] object PageSizeQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageSize")


  def findProjectByIdR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "projects" / IntVar(id) =>
        val result: F[Pretty[Option[ReturnProject]]] = for {
          r <- service.findProjectById(id)
        } yield Pretty(r)
        result.flatMap(Ok(_))

    }
  }

  def createProjectR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@POST -> Root / "v1" / "projects" =>
        val r: F[Int] = req.as[PostProject].flatMap(service.createProject)
        r.flatMap {
          case 1 => Ok(Pretty(0,ApiStatus.Ok))
          case 0 => Ok(Pretty(0,ApiStatus.InternalServerError))
        }

    }
  }

  def deleteProjectR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case DELETE -> Root / "v1" / "projects" / IntVar(id) =>
        val r: F[Int] = service.deleteProject(id)
        r.flatMap {
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(ApiStatus.InternalServerError))
        }
    }
  }

  def updateProjectR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@PUT -> Root / "v1" / "projects" =>
        val r: F[Int] = req.as[Project].flatMap(service.updateProject)
        r.flatMap {
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(ApiStatus.InternalServerError))
        }
    }
  }

  def queryProjectR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "projects"  :? ProjectGroupIdQueryParamMatcher(projectGroupId)
        :? ProjectGroupNameQueryParamMatcher(projectGroupName)
        :? ProjectNameQueryParamMatcher(projectName) :? ProjectTypeQueryParamMatcher(projectType)
        :? PageNoQueryParamMatcher(pageNo) :? PageSizeQueryParamMatcher(pageSize) =>
        val result: F[Pretty[ProjectList]] = for {
          r <- service.queryProject( projectGroupId.getOrElse(-1), projectGroupName.getOrElse(""), projectName.getOrElse(""), projectType.getOrElse(""), pageNo.getOrElse(1), pageSize.getOrElse(10))
        } yield Pretty(r)
        result.flatMap(Ok(_))

    }
  }
  def findAllProjectR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "projects" / "nameAndId" =>
        val result: F[Pretty[ProjectNameAndIdList]] = for {
          r <- service.findAllProject()
        } yield Pretty(r)
        result.flatMap(Ok(_))

    }
  }
  override val publicR: HttpRoutes[F] = findProjectByIdR <+> createProjectR <+> deleteProjectR <+> updateProjectR <+> queryProjectR <+> findAllProjectR

}


