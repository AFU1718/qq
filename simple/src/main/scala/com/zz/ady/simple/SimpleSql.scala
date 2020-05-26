package com.zz.ady.simple

import java.time.Instant

import com.typesafe.scalalogging.Logger
import doobie._
import cats.implicits._
import doobie.implicits._
import doobie.util.fragment.Fragment
import doobie.postgres._
import doobie.postgres.implicits._
import Fragments.{in, whereAndOpt}
import cats.effect.{IOApp, Sync}
import com.zz.ady.idl.Status
import io.circe.syntax._
import io.circe.generic.auto._

object SimpleSql {

  final case class Simple(id: Int, ts: Instant, status: Status)

}

//trait SimpleSql extends MappingExtras {
//
//  import SimpleSql._
//
//  def queryAllSql: doobie.Query0[Simple] = {
//    sql"""select * from t2""".query[Simple]
//  }
//
//  def writeSql(x: Simple) =
//    sql"""insert into t2 (id, ts, status)"""
//
//}
//
//class SimpleDAO[F[_]: Sync](xa: Transactor[F]) extends SimpleSql {
//
//  def queryAll: F[Vector[SimpleSql.Simple]] = queryAllSql.to[Vector].transact(xa)
//
//}
//
//
//
//import scalapb._
//
//object MappingExtras extends MappingExtras
//
//trait MappingExtras {
//
//  implicit def scalaPbEnumMapping[A <: GeneratedEnum : GeneratedEnumCompanion]: Meta[A] =
//    Meta[Short].imap(v => implicitly[GeneratedEnumCompanion[A]].fromValue(v.toInt))(_.value.toShort)
//
//}
