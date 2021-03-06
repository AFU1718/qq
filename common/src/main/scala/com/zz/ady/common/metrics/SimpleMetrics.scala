package com.zz.ady.common.metrics

import akka.actor.typed._
import io.prometheus.client.hotspot._
import io.prometheus.client.{CollectorRegistry, Counter, Histogram}

object SimpleMetrics {

  def apply(system: ActorSystem[_]): SimpleMetrics = SimpleMetricsExtension(system)

  private object SimpleMetricsExtension extends ExtensionId[SimpleMetricsExtension] {
    override def createExtension(system: ActorSystem[_]): SimpleMetricsExtension = new SimpleMetricsExtension(system)

    def get(system: ActorSystem[_]): SimpleMetricsExtension = apply(system)
  }

  private class SimpleMetricsExtension(system: ActorSystem[_]) extends SimpleMetrics() with Extension

}

case class SimpleMetrics(registry: CollectorRegistry = new CollectorRegistry()) {

  registry.register(new StandardExports)
  registry.register(new MemoryPoolsExports)
  registry.register(new BufferPoolsExports)
  registry.register(new GarbageCollectorExports)
  registry.register(new ThreadExports)
  registry.register(new ClassLoadingExports)
  registry.register(new VersionInfoExports)
  registry.register(new MemoryAllocationExports)

  val requestDuration: Histogram = Histogram
    .build()
    .name("request_duration_seconds")
    .help("request_duration_seconds")
    .labelNames("api")
    .register(registry)

  val aerospikeDuration: Histogram = Histogram
    .build()
    .name("aerospike_duration_seconds")
    .help("aerospike_duration_seconds")
    .labelNames("action")
    .register(registry)

  val kafkaSentCounter: Counter = Counter
    .build()
    .name("sent_to_kafka_count")
    .help("sent_to_kafka_count")
    .labelNames("topic")
    .register(registry)

  val kafkaConsumedCounter: Counter = Counter
    .build()
    .name("kafka_topic_consumed_count")
    .help("kafka_topic_consumed_count")
    .labelNames("topic", "group_id")
    .register(registry)

  val pulsarSentCounter: Counter = Counter
    .build()
    .name("sent_to_pulsar_message_count")
    .help("sent_to_pulsar_message_count")
    .labelNames("topic")
    .register(registry)

  val pulsarConsumedCounter: Counter = Counter
    .build()
    .name("consumed_pulsar_message_count")
    .help("consumed_pulsar_message_count")
    .labelNames("topic")
    .register(registry)

  val scyllaDuration: Histogram = Histogram
    .build()
    .name("scylla_duration_seconds")
    .help("scylla_duration_seconds")
    .labelNames("table", "operation")
    .register(registry)

  val sellerBidRequestCounter: Counter = Counter
    .build()
    .name("seller_request_count")
    .help("seller_request_count")
    .labelNames("seller")
    .register(registry)

  val adxBidCounter: Counter = Counter
    .build()
    .name("adx_bid_count")
    .help("adx_bid_count")
    .labelNames("seller", "buyer")
    .register(registry)

  val toBuyerBidRequestCounter: Counter = Counter
    .build()
    .name("to_buyer_bid_request_count")
    .help("to_buyer_bid_request_count")
    .labelNames("buyer", "placement_type")
    .register(registry)

  val buyerTimeoutCounter: Counter = Counter
    .build()
    .name("buyer_timeout_count")
    .help("buyer_timeout_count")
    .labelNames("buyer", "placement_type")
    .register(registry)

  val circuitBreakerCloseHitCounter: Counter = Counter
    .build()
    .name("circuit_breaker_close_hit_count")
    .help("circuit_breaker_close_hit_count")
    .labelNames("dsp_code")
    .register(registry)

  val databaseDuration: Histogram = Histogram
    .build()
    .name("database_duration_seconds")
    .help("database_duration_seconds")
    .labelNames("tables", "operation")
    .register(registry)

  val bidPriceControl1Counter: Counter = Counter
    .build()
    .name("bid_price_control_1")
    .help("bid_price_control_1")
    .labelNames("buyer")
    .register(registry)

  val listRequestCounter: Counter = Counter
    .build()
    .name("list_request_aa")
    .help("list_request_aa")
    .labelNames("list_request_aa").register(registry)


  //  val requestDuration: Histogram = Histogram
  //    .build()
  //    .name("request_duration_seconds")
  //    .help("request_duration_seconds")
  //    .labelNames("api")
  //    .register(registry)
  //
  //  val aerospikeDuration: Histogram = Histogram
  //    .build()
  //    .name("aerospike_duration_seconds")
  //    .help("aerospike_duration_seconds")
  //    .labelNames("action")
  //    .register(registry)
  //
  //  val kafkaSentCounter: Counter = Counter
  //    .build()
  //    .name("sent_to_kafka_count")
  //    .help("sent_to_kafka_count")
  //    .labelNames("topic")
  //    .register(registry)
  //
  //  val pulsarSentCounter: Counter = Counter
  //    .build()
  //    .name("sent_to_pulsar_message_count")
  //    .help("sent_to_pulsar_message_count")
  //    .labelNames("topic")
  //    .register(registry)
  //
  //  val pulsarConsumedCounter: Counter = Counter
  //    .build()
  //    .name("consumed_pulsar_message_count")
  //    .help("consumed_pulsar_message_count")
  //    .labelNames("topic")
  //    .register(registry)
  //
  //  val scyllaDuration: Histogram = Histogram
  //    .build()
  //    .name("scylla_duration_seconds")
  //    .help("scylla_duration_seconds")
  //    .labelNames("table", "operation")
  //    .register(registry)
  //
  //  val sellerBidRequestCounter: Counter = Counter
  //    .build()
  //    .name("seller_request_count")
  //    .help("seller_request_count")
  //    .labelNames("seller")
  //    .register(registry)
  //
  //  val adxBidCounter: Counter = Counter
  //    .build()
  //    .name("adx_bid_count")
  //    .help("adx_bid_count")
  //    .labelNames("seller")
  //    .register(registry)
  //
  //  val toBuyerBidRequestCounter: Counter = Counter
  //    .build()
  //    .name("to_buyer_bid_request_count")
  //    .help("to_buyer_bid_request_count")
  //    .labelNames("buyer", "placement_type")
  //    .register(registry)
  //
  //  val buyerTimeoutCounter: Counter = Counter
  //    .build()
  //    .name("buyer_timeout_count")
  //    .help("buyer_timeout_count")
  //    .labelNames("buyer", "placement_type")
  //    .register(registry)
  //
  //  val circuitBreakerCloseHitCounter: Counter = Counter
  //    .build()
  //    .name("circuit_breaker_close_hit_count")
  //    .help("circuit_breaker_close_hit_count")
  //    .labelNames("dsp_code")
  //    .register(registry)
  //
  //  val databaseDuration: Histogram = Histogram
  //    .build()
  //    .name("database_duration_seconds")
  //    .help("database_duration_seconds")
  //    .labelNames("tables", "operation")
  //    .register(registry)

}
