package com.zz.ady.backstage.api

import cats.data.OptionT
import cats.effect._
import cats.implicits._
import doobie.util.transactor.Transactor
import io.circe.JsonObject
import io.circe.generic.auto._
import org.http4s.{HttpRoutes, Response}
import org.http4s.multipart.{Multipart, Part}

object SimpleApi {

  final case class SimpleUser(id: Int, name: String)

  final case class SimpleData(token: String)

  def apply[F[_]: Effect](): SimpleApi[F] = new SimpleApi[F]

}

class SimpleApi[F[_]](implicit val F: Effect[F])
    extends SimpleJsonApi[F]
    with SimpleGetParametersApi[F]
    with SimplePostJsonApi[F]
    with SimplePostJsonWithParametersApi[F]
    with SimpleMultiPartApi[F] {
  override val publicR: HttpRoutes[F] = r1 <+> r2 <+> r3 <+> r5
}

trait SimpleGetParametersApi[F[_]] { this: SimpleJsonApi[F] =>

  import SimpleApi._

  private[this] object NameQueryParamMatcher extends QueryParamDecoderMatcher[String]("name")

  // GET '/q1?name=simple'
  protected def r1: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root / "q1" :? NameQueryParamMatcher(name) =>
      val simple = SimpleUser(1, name)
      Ok(Pretty(simple))
  }

}

trait SimplePostJsonApi[F[_]] { this: SimpleJsonApi[F] =>

  import SimpleApi._

  // POST '/q2 @1.json
  protected def r2: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req @ POST -> Root / "q2" =>
        val u: F[Pretty[SimpleUser]] = req.as[SimpleUser].map(Pretty.apply[SimpleUser])
        Ok(u)
    }
  }

}

trait SimplePostJsonWithParametersApi[F[_]] { this: SimpleJsonApi[F] =>

  import SimpleApi._

  private[this] object IdQueryParamMatcher extends QueryParamDecoderMatcher[Int]("id")

  // POST '/q3?id=1234' @1.json
  protected def r3: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req @ POST -> Root / "q3" :? IdQueryParamMatcher(id) =>
        val u: F[Pretty[SimpleUser]] = req.as[SimpleUser].map(x => Pretty(x.copy(id = id)))
        Ok(u)
    }
  }

}

trait SimpleMultiPartApi[F[_]] { this: SimpleJsonApi[F] =>
  import io.circe.syntax._
  import fs2._
  protected def r5: HttpRoutes[F] = {
    HttpRoutes.of[F] {
      case req @ POST -> Root / "multipart" =>
        req.decode[Multipart[F]] { m =>
          def f(name: String): Option[F[String]] =
            m.parts.find(_.name.contains(name)).map(_.body.through(text.utf8Decode).compile.toList.map(_.reduce(_ + _)))
          val r1 = for {
            x <- f("name")
            y <- f("fileData")
          } yield {
            for {
              u <- x
              v <- y
            } yield
              JsonObject(
                  "parts"        -> m.parts.length.asJson
                , "fields"       -> m.parts.flatMap(_.name).asJson
                , "name"         -> u.asJson
                , "file_content" -> v.asJson
              )
          }
          Ok(r1.getOrElse(F.pure(JsonObject.empty)))
        }
    }
  }

}
