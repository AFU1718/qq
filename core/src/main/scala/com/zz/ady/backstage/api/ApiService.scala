package com.zz.ady.backstage.api

import cats.data.Kleisli
import cats.effect.{ConcurrentEffect, Effect, IO, Timer}
import org.http4s.HttpRoutes
import cats.implicits._
import com.zz.ady.backstage.database.DatabaseComponent
import org.http4s.server.AuthMiddleware
import org.http4s.server.middleware.{CORS, CORSConfig, Metrics, Timeout}
import io.circe.generic.auto._

import scala.concurrent.duration._
import akka.actor.typed.ActorSystem
import com.zz.ady.backstage.api.inernal.AkkaClusterApi
import com.zz.ady.common.metrics.SimpleMetrics
import doobie.util.transactor.Transactor
import io.prometheus.client.CollectorRegistry
import org.http4s.metrics.prometheus.Prometheus

object ApiService {
  def apply[F[_]: ConcurrentEffect: Timer](xa: Transactor[F])(implicit system: ActorSystem[_],dc: DatabaseComponent[F]): ApiService[F] = new ApiService[F](xa)
}

class ApiService[F[_]: ConcurrentEffect: Timer](xa: Transactor[F],val cors: Boolean = false)(implicit system: ActorSystem[_], dc: DatabaseComponent[F]) {

  val registry: CollectorRegistry = SimpleMetrics(system).registry

  import ApiServiceMiddleware._

  def routes: F[HttpRoutes[F]] = apis.routes.corsed(cors).prometheusMeasured(registry)

  val apis: List[Api[F]] = List(
    MainApi[F](),
    SimpleApi[F](),
    MetricsApi[F](),
    AkkaClusterApi[F](),
    ProjectDeploymentRecordApi[F](xa),
    ProjectGroupApi[F](xa),
    ProjectApi[F](xa),
    RoleApi[F](xa),
    UserInfoApi[F](xa)

  )

}

object ApiServiceMiddleware {

  implicit class PublicRoutes[F[_]: ConcurrentEffect](apis: List[Api[F]]) {
    def routes: HttpRoutes[F] = apis.map(_.publicR).foldLeft(HttpRoutes.empty[F])(_ <+> _)
  }

  implicit class CorsRoutes[F[_]: ConcurrentEffect](routes: HttpRoutes[F]) {
    def corsed(cors: Boolean): HttpRoutes[F] =
      if (cors) {
        val methodConfig = CORSConfig(
          anyOrigin = true,
          anyMethod = false,
          allowedMethods = Some(Set("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD")),
          allowCredentials = true,
          maxAge = 1.day.toSeconds
        )
        CORS(routes, methodConfig)
      } else routes
  }

  implicit class PrometheusRoutes[F[_]: ConcurrentEffect: Timer](routes: HttpRoutes[F]) {
    def prometheusMeasured(registry: CollectorRegistry): F[HttpRoutes[F]] =
      // Prometheus.metricsOps[F](registry, "server").map(Metrics[F](_)(routes)).allocated.map(_._1)
      Prometheus
        .metricsOps[F](registry, "server")
        .map(Metrics[F](_)(routes))
        .use(
          implicitly[ConcurrentEffect[F]].pure
        )
  }

  implicit class TimeoutRoutes[F[_]: ConcurrentEffect: Timer](routes: HttpRoutes[F]) {
    def timeoutTo(timeout: FiniteDuration): HttpRoutes[F] = Timeout(timeout)(routes)
  }

}
