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

    // test begin
//    val a: IO[Int] =IO({
//      println("value")
//      10
//    })
//    val b= List(1,2)
//    val bbb: Seq[Int] = for {
//      bb <- b
//    }yield bb+1

//    import scala.concurrent.{Future, ExecutionContext}
//    import scala.util.{Success, Failure}
//
//    def convert[A](fa: => Future[A])(implicit ec: ExecutionContext): IO[A] =
//      IO.async { cb =>
//        // This triggers evaluation of the by-name param and of onComplete,
//        // so it's OK to have side effects in this callback
//        fa.onComplete {
//          case Success(a) => cb(Right(a))
//          case Failure(e) => cb(Left(e))
//        }
//      }


//    import cats.effect.IO
//
//    val ioa: SyncIO[Unit] = SyncIO(println("Hello world!"))
//    // ioa: SyncIO[Unit] = SyncIO$2053817019
//    val iob: IO[Unit] = ioa.to[IO]
//    // iob: IO[Unit] = Delay(<function0>)


//    trait Functor[F[_]] {
//      def map[A, B](fa: F[A])(f: A => B): F[B]
//    }

//    // Example implementation for Option
//    implicit val functorForOption: Functor[Option] = new Functor[Option] {
//      def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa match {
//        case None    => None
//        case Some(a) => Some(f(a))
//      }
//    }
//    implicit val functorForList = new Functor[List]{
//      def map[A,B](fa: List[A])(f: A => B): List[B] = fa map f
//    }
//    val listOption = List(Some(1), None, Some(2))
//    val res=Functor[List].compose[Option].map(listOption)(_ + 1)
//
//    println(res)
//
//
//    // test end

    DatabaseComponent[IO](config.database) use { implicit dc =>
      AkkaHttpService().serve()
      for {
        _ <- IO { startAkkaCluster() }
        r <- HttpService[IO].serve(config.http.main)
      } yield r
    }
  }

}
