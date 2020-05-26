package com.zz.ady.backstage

import java.util.UUID

import akka.actor.typed._
import akka.actor.typed.SpawnProtocol.Command
import cats.Functor
import cats.effect.{ExitCode, IO, IOApp, Sync, SyncIO}
import pureconfig.ConfigSource
import com.ag.akka.discovery.consul.ConsulAkkaNodeDiscoverer
import com.typesafe.scalalogging.Logger
import com.zz.ady.backstage.config.{AppConfig, AppConfigExtension}
import com.zz.ady.backstage.database.{DatabaseComponent, DatabaseMigrationIO}

object Main extends IOApp {

  import scala.concurrent.ExecutionContext.Implicits.global

  val logger: Logger = com.typesafe.scalalogging.Logger(getClass)

  val systemId: String = ConfigSource.default.at("akka.system.name").loadOrThrow[String]
  val selfUuid: String = UUID.randomUUID().toString

  implicit val system: ActorSystem[Command] = ActorSystem(SpawnProtocol(), systemId)

  val config: AppConfig = AppConfig.loadOrThrow()

  def startAkkaCluster(): Option[ActorRef[_]] =
    ConfigSource.default
      .at("akka.cluster.seed-nodes")
      .load[Vector[String]] match {
      case Right(xs) if xs.nonEmpty => None
      case _                        => Option(ConsulAkkaNodeDiscoverer(selfUuid))
    }

  def run(args: List[String]): IO[ExitCode] = {
    DatabaseComponent[IO](config.database) use { implicit dc =>
      AkkaHttpService().serve()
      for {
        _ <- IO { startAkkaCluster() }
        r <- HttpService[IO].serve(config.http.main)
      } yield r
    }
  }

}
