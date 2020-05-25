package com.zz.ady.backstage.api.inernal


import java.lang.management.ManagementFactory

import cats.effect.Effect
import com.zz.ady.backstage.api.SimpleJsonApi
import javax.management.{MBeanServer, ObjectName}
import io.circe.{Json, JsonObject}
import io.circe.parser.parse
import io.circe.syntax._
import org.http4s.HttpRoutes

object AkkaClusterApi {
  def apply[F[_]: Effect](): AkkaClusterApi[F] = new AkkaClusterApi[F]
}

class AkkaClusterApi[F[_]](implicit val F: Effect[F]) extends SimpleJsonApi[F] {

  def akkaMBeansStatsPresentation(): JsonObject = {
    val mserver: MBeanServer = ManagementFactory.getPlatformMBeanServer
    val cn                   = new ObjectName("akka:type=Cluster")
    JsonObject(
      "Available"     -> Json.fromString(mserver.getAttribute(cn, "Available").toString),
      "ClusterStatus" -> parse(mserver.getAttribute(cn, "ClusterStatus").toString).getOrElse(Json.Null),
      "Leader"        -> Json.fromString(mserver.getAttribute(cn, "Leader").toString),
      "MemberStatus"  -> Json.fromString(mserver.getAttribute(cn, "MemberStatus").toString),
      "Members"       -> Json.fromString(mserver.getAttribute(cn, "Members").toString),
      "Unreachable"   -> Json.fromString(mserver.getAttribute(cn, "Unreachable").toString)
    )
  }

  val clusterR: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root / "v0" / "cluster" =>
      Ok(akkaMBeansStatsPresentation().asJson)
  }

  override val publicR: HttpRoutes[F] = clusterR
}