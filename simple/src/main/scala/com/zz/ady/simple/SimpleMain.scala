package com.zz.ady.simple

import akka.actor.ActorSystem
import cats.effect.{ExitCode, IO, IOApp}
import cats.effect.implicits._
import pureconfig.ConfigSource
import cats.implicits._

object SimpleMain extends IOApp {

  val logger = com.typesafe.scalalogging.Logger(getClass)

  // implicit val system: ActorSystem = ActorSystem("dsp-backstage-core")

  val config = AppConfig.loadOrThrow()

//  {
//    import io.circe.syntax._
//    import io.circe.generic.auto._
//    import com.zz.ady.backstage.json.SimpleJsonSupport._
//    logger.info("app config:\n{}", ctx.config.asJson.spaces2)
//  }

  def run(args: List[String]): IO[ExitCode] = {
    DatabaseComponent[IO](config.database)
      .use { implicit dc =>
//        new SimpleDAO[IO](dc.ady).queryAll
//          .map(_.foreach(println))
//          .unsafeRunSync()

        IO.never *> IO(ExitCode.Success)
      }
  }

}
