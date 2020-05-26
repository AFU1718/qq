package simple

import cats.effect.{ConcurrentEffect, ExitCode, Timer}
import cats.implicits._
import org.http4s.HttpRoutes
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.implicits._
import scala.concurrent.ExecutionContext

import org.http4s.server.Router

object HttpService {

  def serve[F[_]: ConcurrentEffect: Timer](port: Int): F[ExitCode] =
    for {
      _ <- BlazeServerBuilder[F]
            .bindHttp(port, "0.0.0.0")
            .withHttpApp(Router("/" -> Api.of[F]).orNotFound)
            .serve
            .compile
            .drain
    } yield ExitCode.Success
}


