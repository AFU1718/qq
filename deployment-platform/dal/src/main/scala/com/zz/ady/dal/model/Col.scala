package com.zz.ady.dal.model

import io.circe.{Decoder, Encoder, Json}
import cats.implicits._
import doobie._
import io.circe.Decoder.Result
import doobie.implicits._
import io.circe.syntax._

final case class Col[A, B](name: String, cl: String, f: A => B)(implicit val decoder: Decoder[B], val encoder: Encoder[B], implicit val meta: Meta[B]) {
  def frTerm(alias: String = ""): Json => Fragment = _.as[B].map(x => fr"$x").getOrElse(fr"")
  def frIn(alias: String = ""): Vector[Json] => Fragment =
    _.map(_.as[B])
      .collect {
        case Right(x) => x
      }
      .toList
      .toNel
      .map(ys => Fragments.in(Fragment.const(alias + s""""${this.cl}""""), ys))
      .getOrElse(fr"")
  def decodeTerm(j: Json): Result[B] = j.as[B]

  def decodeIn(j: Seq[Json]): Seq[B] = j.map(_.as[B]).collect { case Right(x) => x }

  def defaultFr(v: A, alias: String): Fragment = fr"${f(v)}" ++ fr"as" ++ Fragment.const(s""""$name"""")

  def jsonOf(v: A): Json = f(v).asJson

  override def toString: String = s"""Col($name, $cl)"""
}

object Col {
  def apply[A, T: Decoder: Encoder: Meta](s: String, fr: A => T): Col[A, T]           = Col(s, s, fr)
  def tuple[A, T: Decoder: Encoder: Meta](s: String, fr: A => T): (String, Col[A, T]) = s -> Col(s, s, fr)
  def default[A]: Col[A, Int]                                                         = Col("", "", _ => 0)
}
