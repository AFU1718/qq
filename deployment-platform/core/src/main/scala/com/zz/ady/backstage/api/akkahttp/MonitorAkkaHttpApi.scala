package com.zz.ady.backstage.api.akkahttp

import java.io.StringWriter
import java.lang.management.ManagementFactory

import javax.management.{MBeanServer, ObjectName}
import scala.util._
import scala.concurrent._

import akka.actor.typed.ActorSystem
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.http.scaladsl.marshalling.{Marshaller, ToEntityMarshaller}
import io.prometheus.client.CollectorRegistry
import io.prometheus.client.exporter.common.TextFormat
import io.prometheus.client.hotspot.DefaultExports
import io.circe.{Json, JsonObject}
import io.circe.syntax._
import io.circe.parser._
import com.zz.ady.common.metrics.SimpleMetrics

object MonitorAkkaHttpApi {

  def apply()(implicit system: ActorSystem[_]): MonitorAkkaHttpApi = new MonitorAkkaHttpApi()

}

class MonitorAkkaHttpApi()(implicit system: ActorSystem[_]) extends AkkaHttpApi {

  val routes: Route = rootR ~ metricsR ~ akkaStatsR

  DefaultExports.initialize()

  def rootR: Route = path("status") {
    get {
      onComplete {
        Future.successful("ok.")
      } {
        case Success(x) => encodeResponse(complete(x))
        case _ => complete(StatusCodes.InternalServerError)
      }
    }
  }

  def metricsR: Route = path("metrics") {
    implicit val marshaller: ToEntityMarshaller[String] = Marshaller.StringMarshaller
    get {
      val sw = new StringWriter(1024)
      TextFormat.write004(sw, SimpleMetrics(system).registry.metricFamilySamples())
      TextFormat.write004(sw, CollectorRegistry.defaultRegistry.metricFamilySamples())
      encodeResponse(complete(sw.toString))
    }
  }

  def akkaStatsR: Route = path("akka") {
    complete(akkaMBeansStatsPresentation.asJson.noSpaces)
  }

  def akkaMBeansStatsPresentation: JsonObject = {
    val mServer: MBeanServer = ManagementFactory.getPlatformMBeanServer
    val cn = new ObjectName("akka:type=Cluster")
    JsonObject(
      "Available" -> Json.fromString(mServer.getAttribute(cn, "Available").toString),
      "ClusterStatus" -> parse(mServer.getAttribute(cn, "ClusterStatus").toString).getOrElse(Json.Null),
      "Leader" -> Json.fromString(mServer.getAttribute(cn, "Leader").toString),
      "MemberStatus" -> Json.fromString(mServer.getAttribute(cn, "MemberStatus").toString),
      "Members" -> Json.fromString(mServer.getAttribute(cn, "Members").toString),
      "Unreachable" -> Json.fromString(mServer.getAttribute(cn, "Unreachable").toString)
    )
  }
}
