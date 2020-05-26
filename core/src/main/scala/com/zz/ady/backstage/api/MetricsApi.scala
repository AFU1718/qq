package com.zz.ady.backstage.api

import akka.actor.typed.ActorSystem
import cats.effect._
import org.http4s._
import com.zz.ady.common.metrics.{MetricsService, SimpleMetrics}

object MetricsApi {

  def apply[F[_]: ConcurrentEffect]()(implicit system: ActorSystem[_]): MetricsApi[F] = new MetricsApi

}

class MetricsApi[F[_]](implicit val F: ConcurrentEffect[F], system: ActorSystem[_]) extends EffectApi[F] with Api[F] {

  val metricsR: HttpRoutes[F] = MetricsService.of[F](SimpleMetrics(system).registry)

  override val publicR: HttpRoutes[F] = metricsR

}
