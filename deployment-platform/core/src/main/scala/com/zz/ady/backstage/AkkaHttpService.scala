package com.zz.ady.backstage

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.adapter._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.typesafe.config.{Config, ConfigFactory}
import scala.concurrent.Future

import akka.http.scaladsl.Http
import akka.stream.Materializer
import com.zz.ady.backstage.api.akkahttp._

object AkkaHttpService {

  def apply()(implicit system: ActorSystem[_]) = new AkkaHttpService()

}

class AkkaHttpService()(implicit system: ActorSystem[_], mat: Materializer) {

  import scala.concurrent.ExecutionContext.Implicits.global

  private[this] val config: Config = ConfigFactory.load()

  private[this] val logger = com.typesafe.scalalogging.Logger(getClass)

  def serve(): Future[Http.ServerBinding] = {
    val address = config.getString("http.akka.host")
    val port    = config.getInt("http.akka.port")
    val apis: List[AkkaHttpApi] = List(
      MainAkkaHttpApi()
      , MonitorAkkaHttpApi()
    )
    val routes: Route = apis.map(_.routes).reduceLeft(_ ~ _)
    implicit val _system = system.toClassic
    Http().bindAndHandle(routes, address, port)
  }

}
