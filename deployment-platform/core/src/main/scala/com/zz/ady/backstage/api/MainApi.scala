package com.zz.ady.backstage.api

import cats.effect._
import com.zz.ady.backstage.database.DatabaseComponent
import io.circe.generic.auto._
import org.http4s.HttpRoutes

object MainApi {

  def apply[F[_]: Effect: DatabaseComponent]() = new MainApi[F]

}

class MainApi[F[_]](implicit val F: Effect[F], val dc: DatabaseComponent[F]) extends EffectApi[F] with Api[F] {

  import org.http4s.circe.CirceEntityEncoder._

  val routes: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root =>
      Ok(Pretty("http4s is serving."))
  }

  override val publicR: HttpRoutes[F] = routes

}
