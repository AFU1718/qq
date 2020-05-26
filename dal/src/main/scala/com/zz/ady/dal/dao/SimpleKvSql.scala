package com.zz.ady.dal.dao

import java.time.Instant

import com.typesafe.scalalogging.Logger
import doobie.implicits._

object SimpleKvSql extends SimpleKvSql

trait SimpleKvSql extends Sql {

  type SimpleKV = (String, String, Instant)

  protected val logger: Logger = Logger(getClass)

  val tt = "kv"

  // def insertSql(v: SimpleKV): doobie.Update0 = sql"""insert into kv (k, v, updated_at) values (${v._1}, ${v._2}, ${v._3})""".update

  def insertOrUpdateSql(v: SimpleKV): doobie.Update0 =
    sql"""insert into kv (k, v, updated_at) values (${v._1}, ${v._2}, ${v._3})
         |on conflict (k) do update set v = EXCLUDED.v, updated_at = EXCLUDED.updated_at""".stripMargin.update

  def queryAllSql: doobie.Query0[(String, String)] = sql"""select k, v from kv""".query[(String, String)]

}
