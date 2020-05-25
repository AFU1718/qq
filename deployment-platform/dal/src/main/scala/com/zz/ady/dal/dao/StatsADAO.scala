package com.zz.ady.dal.dao

import cats.effect.Async
import doobie.implicits._
import com.zz.ady.idl.StatsA
import com.zz.ady.dal.monoid.Implicits._
import cats.implicits._
import doobie.util.transactor.Transactor

object StatsADAO {

  def apply[F[_]: Async](xa: Transactor[F]): StatsADAO[F] = new StatsADAO[F](xa)

}

class StatsADAO[F[_]: Async](xa: Transactor[F]) {

  def insertByMinute(rows: Seq[StatsA]): F[Int] = StatsASql.insertByMinute(rows).transact(xa)

  def insertByHour(rows: Seq[StatsA]): F[Int] = StatsASql.insertByHour(rows).transact(xa)

  def insertByDay(rows: Seq[StatsA]): F[Int] = StatsASql.insertByDay(rows).transact(xa)

  def insert3(rows: Seq[StatsA]): F[Int] = {
    val (ms, hs, ds) = rows.aggregated3
    List(insertByMinute(ms), insertByHour(hs.toList), insertByDay(ds.toList)).sequence
      .map(_.sum)
  }

}
