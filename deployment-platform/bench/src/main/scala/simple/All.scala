package simple

import java.util.concurrent.Executors

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

import cats.implicits._
import cats.effect.{ConcurrentEffect, ExitCode, IO, IOApp, Timer}
import monix.eval
import monix.eval.TaskApp
import org.http4s.dsl.Http4sDsl
import org.http4s.HttpRoutes
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.implicits._
import org.http4s.server.Router
import pureconfig.ConfigSource
import zio.internal.{Executor, Platform}
import zio.{Task, ZIO}
import zio.interop.catz._
import zio.interop.catz.implicits._

trait SimpleConfig {

  def port: Int = ConfigSource.default.at("http.port").load[Int].getOrElse(10000)

}

class Http1[F[_]: ConcurrentEffect: Timer] extends Http4sDsl[F] {

  val rootR: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root =>
      Ok("http4s service works.")
  }

  implicit val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(8))

  def serve(port: Int): F[ExitCode] =
    BlazeServerBuilder[F]
      .bindHttp(port, "0.0.0.0")
      .withHttpApp(Router("/" -> rootR).orNotFound)
      // .withExecutionContext(ec)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
}

object CatsIOApp extends IOApp with SimpleConfig {

  /**
    * wrk --latency -t 2048 -c 2048 -d 10 http://127.0.0.1:10000
    * QPS: 20w
    * wrk --latency -t 256 -c 256 -d 10 http://127.0.0.1:10000
    * QPS: 18w
    */
  override def run(args: List[String]): IO[ExitCode] = new Http1[cats.effect.IO].serve(port)
}

object MonixApp extends TaskApp with SimpleConfig {

  /**
    * wrk --latency -t 2048 -c 2048 -d 10 http://127.0.0.1:10001
    * QPS: 20w
    * wrk --latency -t 256 -c 256 -d 10 http://127.0.0.1:10001
    * QPS: 17w
    */
  override def run(args: List[String]): eval.Task[ExitCode] = new Http1[monix.eval.Task].serve(port)
}

object ZIOApp extends CatsApp with Http4sDsl[Task] with SimpleConfig {

  //override val platform: Platform = PlatformLive.Benchmark

  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] =
    new Http1[Task].serve(port).fold(_ => 1, _ => 0)

}

//object ZIOApp extends CatsApp with Http4sDsl[Task] {
//
//  val rootR: HttpRoutes[Task] = HttpRoutes.of[Task] {
//    case GET -> Root =>
//      Ok("http4s service works.")
//  }
//
//
//  val httpRoutes = Router[Task](
//    "/" -> rootR
//  ).orNotFound
//
//  def serve(port: Int): Task[ExitCode] =
//    BlazeServerBuilder[Task]
//      .bindHttp(port, "0.0.0.0")
//      .withHttpApp(Router("/" -> rootR).orNotFound)
//      .withNio2(true)
//      .serve
//      .compile
//      .drain
//      .as(ExitCode.Success)
//
//  /**
//    * wrk --latency -t 2048 -c 2048 -d 10 http://127.0.0.1:10002
//    * QPS: 3.8w
//    * wrk --latency -t 256 -c 256 -d 10 http://127.0.0.1:10002
//    * QPS: 3.9w
//    */
//  override def run(args: List[String]): ZIO[zio.ZEnv, Nothing, Int] =
//    // new Http1[Task].serve(10002).fold(_ => 1, _ => 0)
//  serve(10002).fold(_ => 1, _ => 0)
//}
