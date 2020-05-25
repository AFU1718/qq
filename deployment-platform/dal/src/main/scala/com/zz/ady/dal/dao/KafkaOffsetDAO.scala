package com.zz.ady.dal.dao

import cats.effect.Sync
import cats.implicits._
import doobie.implicits._
import doobie.util.transactor.Transactor

import com.zz.ady.dal.model.KafkaOffsetStore._

object KafkaOffsetDAO {
  def apply[F[_]: Sync](xa: Transactor[F]): KafkaOffsetDAO[F] = new KafkaOffsetDAO(xa)
}

class KafkaOffsetDAO[F[_]: Sync](xa: Transactor[F]) extends KafkaOffsetSql {

  def storeCursor(xs: Seq[TopicPartitionGroupIdOffset]): F[Int] = {
    storeCursorSql(xs).run.transact(xa)
  }

  def queryOffsetsOnAssign(topicPartitionGroupIds: Seq[TopicPartitionGroupId]): F[Map[TopicPartitionGroupId, Long]] =
    queryOffsetsByTopicPartitionGroupId(topicPartitionGroupIds)
      .map { xs =>
        xs.map(x => TopicPartitionGroupId(x.topic, x.partition, x.groupId) -> x.offset).toMap
      }

  def queryOffsetsByTopicPartitionGroupId(topicPartitionGroupIds: Seq[TopicPartitionGroupId]): F[Vector[TopicPartitionGroupIdOffset]] =
    queryOffsetsByTopicPartitionGroupIdSql(topicPartitionGroupIds).to[Vector].transact(xa)

  def loadCursors(topic: String, groupId: String): F[Vector[TopicPartitionGroupIdOffset]] =
    loadCursorsSql(topic, groupId).to[Vector].transact(xa)

  def updateOffsetsLatest(xs: Seq[TopicPartitionOffset]): F[Int] = updateOffsetsLatestSql(xs).run.transact(xa)

  def queryOffsetsLatestAll: F[Vector[TopicPartitionOffset]] = queryOffsetsLatestAllSql.to[Vector].transact(xa)

//  def getOffsetsOnAssign(groupId: String)(ps: Seq[TopicPartition]) = {
//    val qs = ps.map(p => TopicPartitionGroupId(topic = p.topic(), partition = p.partition(), groupId = groupId))
//    queryOffsetsOnAssign(qs)
//      .map {
//        _.map {
//          case (k, v) =>
//            new TopicPartition(k.topic, k.partition) -> v
//        }
//      }
//  }
//
//  def commit(groupId: String)(ps: Set[TopicPartitionGroupIdOffset])(implicit ec: ExecutionContext): Future[Unit] = {
//    dao.store(ps).map(_ => ())
//  }
//
//  def load(topic: String, groupId: String, partitions: Vector[Int])(implicit ec: ExecutionContext): Future[Seq[(TopicPartition, Long)]] = {
//    dao.load(topic, groupId)
//      .map {
//        _.collect { case x if partitions.contains(x.partition) =>
//          new TopicPartition(topic, x.partition) -> x.offset
//        }
//      }
//  }
  
}
