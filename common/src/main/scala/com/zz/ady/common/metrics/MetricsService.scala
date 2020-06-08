package com.zz.ady.common.metrics

import java.io.StringWriter
import java.util
import java.util.{HashSet, LinkedHashSet}

import cats.implicits._
import cats.effect._
import io.prometheus.client.{CollectorRegistry, CounterMetricFamily}
import io.prometheus.client.exporter.common.TextFormat
import org.http4s._
import org.http4s.dsl.Http4sDsl

object MetricsService {

  def of[F[_]: Sync](collectorRegistry: CollectorRegistry): HttpRoutes[F] = {
    object dsl extends Http4sDsl[F]
    import dsl._
    HttpRoutes.of[F] {
      case GET -> Root / "metrics" =>
        Sync[F]
          .delay {
            val writer = new StringWriter
            val a=new HashSet[java.lang.String]()
            a.add("list_request_aa")

            TextFormat.write004(writer, collectorRegistry.metricFamilySamples)
            writer.toString
          }
          .map(Response[F](Status.Ok).withEntity(_))
    }
  }

}