package com.zz.ady.dal.model

import java.time.Instant

object KafkaOffsetStore {
  final case class TopicPartitionGroupId(
    topic: String,
    partition: Int,
    groupId: String
  )
  final case class TopicPartitionGroupIdOffset(
    topic: String,
    partition: Int,
    groupId: String,
    offset: Long,
    clientHost: String,
    updatedAt: Instant
  ) {
    def topicPartitionGroupId: TopicPartitionGroupId = TopicPartitionGroupId(topic, partition, groupId)
  }
  object TopicPartitionGroupIdOffset {
    def fromTopicPartitionGroupId(t: TopicPartitionGroupId, offset: Long, ts: Instant, host: String): TopicPartitionGroupIdOffset =
      TopicPartitionGroupIdOffset(
        topic = t.topic,
        partition = t.partition,
        groupId = t.groupId,
        offset = offset,
        clientHost = host,
        updatedAt = ts
      )
  }
  final case class TopicPartitionOffset(
    topic: String,
    partition: Int,
    offset: Long,
    updatedAt: Instant
  )
}
