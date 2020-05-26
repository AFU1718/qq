package com.zz.ady.backstage.api


import akka.NotUsed
import akka.actor.typed.ActorSystem
import cats.effect.Effect
import cats.implicits._
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.service.ProjectDeploymentRecordService
import com.zz.ady.idl.{PostProjectDeploymentRecord, ProjectDeploymentRecord, ProjectDeploymentRecordList, ReturnProjectDeploymentRecord}
//import com.zz.ady.dal.model.ProjectDeploymentRecord
import org.http4s.{HttpRoutes, Request, Response}
import doobie.util.transactor.Transactor
import io.circe.generic.auto._

object ProjectDeploymentRecordApi {
  def apply[F[_] : Effect](xa: Transactor[F])(implicit system: ActorSystem[_]): ProjectDeploymentRecordApi[F] = new ProjectDeploymentRecordApi[F](xa)

}

class ProjectDeploymentRecordApi[F[_]](xa: Transactor[F])(implicit val F: Effect[F], val system: ActorSystem[_]) extends SimpleJsonApi[F] {

  import ProjectDeploymentRecordApi._

  private[this] val logger: Logger = Logger(getClass)

  private val service: ProjectDeploymentRecordService[F] = ProjectDeploymentRecordService[F](xa)

//  private[this] object IdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("id")

  private[this] object ProjectIdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("projectId")

  private[this] object ProjectNameQueryParamMatcher extends OptionalQueryParamDecoderMatcher[String]("projectName")

  private[this] object StatusQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("status")

//  private[this] object IsDeletedQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("isDeleted")

  private[this] object PageNoQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageNo")

  private[this] object PageSizeQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageSize")


  def findProjectDeploymentRecordByIdR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "deployments" / IntVar(id) =>
        val result: F[Pretty[Option[ReturnProjectDeploymentRecord]]] = for {
          r <- service.findProjectDeploymentRecordById(id)
        } yield Pretty(r)
        result.flatMap(Ok(_))
    }
  }

  def createProjectDeploymentRecordR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@POST -> Root / "v1" / "deployments" =>
        val r: F[Int] = req.as[PostProjectDeploymentRecord].flatMap(service.createProjectDeploymentRecord)
        r.flatMap {
          case 1 => Ok(Pretty(0,ApiStatus.Ok))
          case 0 => Ok(Pretty(0,ApiStatus.InternalServerError))
        }
    }
  }

  def deleteProjectDeploymentRecordR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case DELETE -> Root / "v1" / "deployments" / IntVar(id) =>
        val r: F[Int] = service.deleteProjectDeploymentRecord(id)
        r.flatMap {
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(ApiStatus.InternalServerError))
        }
    }
  }

  def updateProjectDeploymentRecordR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@PUT -> Root / "v1" / "deployments" =>
        val r: F[Int] = req.as[ProjectDeploymentRecord].flatMap(service.updateProjectDeploymentRecord)
        r.flatMap {
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(ApiStatus.InternalServerError))
        }
    }
  }

  def queryProjectDeploymentRecordR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "deployments" :? ProjectIdQueryParamMatcher(projectId)
        :? ProjectNameQueryParamMatcher(projectName)
        :? StatusQueryParamMatcher(status)
        :? PageNoQueryParamMatcher(pageNo) :? PageSizeQueryParamMatcher(pageSize) =>

        val result: F[Pretty[ProjectDeploymentRecordList]] = for {
          r <- service.queryProjectDeploymentRecord(projectId.getOrElse(-1), projectName.getOrElse(""), status.getOrElse(-1), pageNo.getOrElse(1), pageSize.getOrElse(10))
        } yield Pretty(r)

        result.flatMap(Ok(_))
    }
  }

  override val publicR: HttpRoutes[F] = findProjectDeploymentRecordByIdR <+> createProjectDeploymentRecordR <+> deleteProjectDeploymentRecordR <+> updateProjectDeploymentRecordR <+> queryProjectDeploymentRecordR


}

