package com.zz.ady.dal.dao

import cats.effect.Sync
import doobie.implicits._
import doobie._

class SimpleKvDAO[F[_]: Sync](xa: Transactor[F]) extends SimpleKvSql {

  def insertOrUpdate(v: SimpleKV): F[Int] = insertOrUpdateSql(v).run.transact(xa)

  def queryAll(): F[Vector[(String, String)]] = queryAllSql.to[Vector].transact(xa)

}
