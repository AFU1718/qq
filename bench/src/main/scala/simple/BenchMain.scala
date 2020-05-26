package simple

import cats.Applicative
import cats.effect.{ExitCode, Fiber, IO, IOApp}
import zio.{Task, ZIO}
import zio.interop.catz._
import zio.interop.catz.implicits._

object BenchMain extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    val ioa: IO[Int] = IO.delay { Thread.sleep(5000); 123 }
    val iob: IO[Int] = IO.delay { Thread.sleep(5000); 456 }
    for {
      t <- IO { System.currentTimeMillis() }
      x <- ioa.start
      y <- iob.start
      a <- x.join
      b <- y.join
      _ <- IO { println(s"result : ${a + b}") }
      _ <- IO { println(System.currentTimeMillis() - t) }
    } yield ExitCode.Success
  }
}
