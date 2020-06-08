package com.zz.ady.backstage

import akka.actor.typed.ActorSystem
import cats.effect._
import cats.implicits._
import com.typesafe.scalalogging.Logger
import org.http4s.HttpRoutes
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.server.Router
import org.http4s.implicits._
import com.zz.ady.backstage.api.ApiService
import com.zz.ady.backstage.config.AppConfig
import com.zz.ady.backstage.database.DatabaseComponent

//trait HttpServer[F[_]] {
//
//  protected val logger: Logger = Logger(getClass)
//
//  def routes()(implicit dc: DatabaseComponent[F]): HttpRoutes[F]
//
//  def serve(config: AppConfig.HttpConfig)(implicit ef: ConcurrentEffect[F], timer: Timer[F], dc: DatabaseComponent[F]): F[ExitCode] = {
//    val server: F[Unit] = BlazeServerBuilder[F]
//      .bindHttp(config.port, config.host)
//      .withHttpApp(Router("/" -> routes).orNotFound)
//      .serve
//      .compile
//      .drain
//    for {
//      _ <- printAsciiBanner
//      _ <- server
//    } yield ExitCode.Success
//  }
//
//  def printAsciiBanner(implicit ef: ConcurrentEffect[F]): F[Unit] =
//    Resource
//      .fromAutoCloseable(ef.delay(scala.io.Source.fromResource("issue.txt")))
//      .use { x =>
//        ef.delay(Logger("com.ag.adx.backstage.Main.Logo").info(x.mkString))
//      }
//
//}
//
//object HttpServerIO extends HttpServer[IO] {
//
//  def routes()(implicit dc: DatabaseComponent[IO]): HttpRoutes[IO] = (new ApiServiceIO).routes
//
//}




abstract class HttpService[F[_]: ConcurrentEffect: Timer: DatabaseComponent]()(implicit system: ActorSystem[_]) {

  val F: ConcurrentEffect[F] = implicitly[ConcurrentEffect[F]]

  val routes: F[HttpRoutes[F]]

  def serve(config: AppConfig.HttpConfig): F[ExitCode] =
    for {
      r <- routes
      b <- F.delay(scala.io.Source.fromResource("issue.txt"))
      _ <- BlazeServerBuilder[F]
            .withBanner(b.mkString :: Nil)
//            .withConnectorPoolSize(size = 512)
//            .withSocketKeepAlive(true)
//            .withTcpNoDelay(true)
//            .withNio2(true)
            .bindHttp(config.port, config.host)
            .withHttpApp(Router("/" -> r).orNotFound)
            .serve
            .compile
            .drain
    } yield ExitCode.Success

}

object HttpService {

  def apply[F[R]: ConcurrentEffect: Timer]()(implicit system: ActorSystem[_], dc: DatabaseComponent[F]): HttpService[F] =
    new HttpService[F] {
      val routes: F[HttpRoutes[F]] = ApiService[F](dc.main).routes
    }

}