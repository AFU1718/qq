package com.zz.ady.backstage.api


import java.time.Instant

import akka.NotUsed
import akka.actor.typed.ActorSystem
import cats.effect.Effect
import cats.implicits._
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.service.ProjectDeploymentRecordService
import com.zz.ady.common.metrics.SimpleMetrics
import com.zz.ady.idl._
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
  private[this] val metrics = SimpleMetrics(system)

  //  private[this] object IdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("id")
  //
  //  private[this] object ProjectIdQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("projectId")
  //
  //  private[this] object ProjectNameQueryParamMatcher extends OptionalQueryParamDecoderMatcher[String]("projectName")
  //
  //  private[this] object StatusQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("status")
  //
  //  private[this] object IsDeletedQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("isDeleted")
  //
  //  private[this] object PageNoQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageNo")
  //
  //  private[this] object PageSizeQueryParamMatcher extends OptionalQueryParamDecoderMatcher[Int]("pageSize")


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
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(0, ApiStatus.InternalServerError))
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
        val r: F[Int] = req.as[PutProjectDeploymentRecord].flatMap(service.updateProjectDeploymentRecord)
        r.flatMap {
          case 1 => Ok(Pretty(ApiStatus.Ok))
          case 0 => Ok(Pretty(ApiStatus.InternalServerError))
        }
    }
  }

  def queryProjectDeploymentRecordR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req@POST -> Root / "v1" / "deployments" / "query" =>
        for {
          _ <- F.delay(metrics.listRequestCounter.labels("list_request_aa").inc())
        } yield ()
        val result: F[Pretty[ProjectDeploymentRecordList]] = req.as[QueryProjectDeploymentRecord].flatMap(query => {
          service.queryProjectDeploymentRecord(query.projectId, query.projectName, query.status, query.pageNo, query.pageSize)
        }).map(Pretty(_))
        result.flatMap(Ok(_))
    }
  }

  def testR: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case GET -> Root / "v1" / "test" =>
        val a = Test(Instant.now())
        val a: Option[T] =Test1().t
        QueryProjectDeploymentRecord
        Ok {
          a
        }
    }
  }

  override val publicR: HttpRoutes[F] = findProjectDeploymentRecordByIdR <+> createProjectDeploymentRecordR <+> deleteProjectDeploymentRecordR <+> updateProjectDeploymentRecordR <+> queryProjectDeploymentRecordR


}

