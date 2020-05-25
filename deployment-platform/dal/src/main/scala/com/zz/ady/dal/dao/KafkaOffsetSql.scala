package com.zz.ady.dal.dao

import doobie.implicits._
import doobie._
import cats.implicits._
import com.zz.ady.dal.model.KafkaOffsetStore._

trait KafkaOffsetSql extends Sql {

  val ss = "kafka_offsets_cursor"
  val tt = "kafka_offsets_latest"

  def storeCursorSql(xs: Seq[TopicPartitionGroupIdOffset]): doobie.Update0 = {
    def g(x: TopicPartitionGroupIdOffset) = fr"(${x.topic}, ${x.partition}, ${x.groupId}, ${x.offset}, ${x.clientHost}, ${x.updatedAt})"
    val q1 = Fragment.const(s"""insert into $ss """) ++
      fr"""("topic", "par", "group_id", "offsets", "client_host", "updated_at") values """ ++
      xs.toList.map(g).intercalate(fr", ") ++
      fr"""on conflict ("topic", "par", "group_id")
           do update
             set "offsets" = EXCLUDED."offsets", "updated_at" = now(), "client_host" = EXCLUDED."client_host"
        """
    q1.stripMargin.update
  }

  def queryOffsetsByTopicPartitionGroupIdSql(
    topicPartitionGroupIds: Seq[TopicPartitionGroupId]): doobie.Query0[TopicPartitionGroupIdOffset] = {
    val fw = Fragments.whereOr(
      topicPartitionGroupIds.map(t => fr"""topic = ${t.topic} and par = ${t.partition}"""): _*
    )

    val q = fr"""select topic, par, group_id, offsets, client_host, updated_at from """ ++ Fragment.const(ss) ++ fw
    q.query[TopicPartitionGroupIdOffset]
  }

  def loadCursorsSql(topic: String, groupId: String): doobie.Query0[TopicPartitionGroupIdOffset] = {
    val q = fr"""select topic, par, group_id, offsets, client_host, updated_at from """ ++ Fragment.const(ss) ++
      fr"""where topic = $topic and group_id = $groupId"""
    q.query[TopicPartitionGroupIdOffset]
  }

  def updateOffsetsLatestSql(xs: Seq[TopicPartitionOffset]): doobie.Update0 = {
    def f(row: TopicPartitionOffset) = fr"""(${row.topic}, ${row.partition}, ${row.offset}, ${row.updatedAt})"""
    val g: Fragment                  = xs.toList.map(f).intercalate(fr", ")
    val q = fr"""insert into""" ++ Fragment.const(tt) ++
      fr"""("topic", "par", "offsets", "updated_at") values""" ++ g ++
      fr"""on conflict ("topic", "par")
           do update
             set "offsets" =  EXCLUDED.offsets, "updated_at" = now()
        """
    q.stripMargin.update
  }

  def queryOffsetsLatestAllSql: doobie.Query0[TopicPartitionOffset] = {
    val q = sql"""select "topic", "par", "offsets", "updated_at" from """ ++ Fragment.const(tt)
    q.query[TopicPartitionOffset]
  }

}
