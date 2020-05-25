package com.zz.ady.dal.monoid

import java.time.{Instant, ZoneId}

import cats.implicits._

import com.zz.ady.dal.util.DatetimeTruncating._


import com.zz.ady.idl.StatsA

object DefaultStatsAMonoid extends StatsAMonoid

trait StatsAMonoid extends StatsMonoid[StatsA] with StatsADimensional {

  override def zero(x: StatsA): StatsA = dimension(x)

  override def aggregateBy(xs: Seq[StatsA])(f: StatsA => StatsA): Vector[StatsA] =
    xs.groupBy(f)
      .flatMap {
        case (y, ys) => ys.reduceLeftOption(this.combine).map(_.withTs(y.ts))//ys.reduceLeftOption((x, z) => this.combine(x, z).withTs(y.ts)).toList
      }
      .toVector

  override def aggregateByMinute(x: Seq[StatsA]): Vector[StatsA] = aggregateBy(x)(dimensionsByMinute)
  override def aggregateByHour(x: Seq[StatsA]): Vector[StatsA]   = aggregateBy(x)(dimensionsByHour)
  override def aggregateByDay(x: Seq[StatsA]): Vector[StatsA]    = aggregateBy(x)(dimensionsByDay)

  override def empty: StatsA = StatsA.defaultInstance

  override def combine(x: StatsA, y: StatsA): StatsA = combineWith(x.ts)(x, y)

  private[this] def combineWith(t: Instant)(x: StatsA, y: StatsA): StatsA =
    zero(x)
      .copy(
        events = x.events + y.events,
        adxCostInMicro = x.adxCostInMicro + y.adxCostInMicro,
        adxRevenueInMicro = x.adxRevenueInMicro + y.adxRevenueInMicro,
        sellerRequest = x.sellerRequest + y.sellerRequest,
        adxIntercept = x.adxIntercept + y.adxIntercept,
        toBuyerRequest = x.toBuyerRequest + y.toBuyerRequest,
        buyerBid = x.buyerBid + y.buyerBid,
        buyerNoBid = x.buyerNoBid + y.buyerNoBid,
        buyerTimeout = x.buyerTimeout + y.buyerTimeout,
        buyerError = x.buyerError + y.buyerError,
        adxBid = x.adxBid + y.adxBid,
        adxNoBid = x.adxNoBid + y.adxNoBid,
        adxDrop = x.adxDrop + y.adxDrop,
        winNotice = x.winNotice + y.winNotice,
        impression = x.impression + y.impression,
        click = x.click + y.click,
        downloadStarted = x.downloadStarted + y.downloadStarted,
        downloadCompleted = x.downloadCompleted + y.downloadCompleted,
        installStarted = x.installStarted + y.installStarted,
        installCompleted = x.installCompleted + y.installCompleted,
        videoStart = x.videoStart + y.videoStart,
        videoEnd = x.videoEnd + y.videoEnd,
        videoClick = x.videoClick + y.videoClick,
        videoClose = x.videoClose + y.videoClose,
        videoSkip = x.videoSkip + y.videoSkip
      )

  private[this] def dimensionsByMinute(x: StatsA): StatsA = zero(x).withTs(x.ts.truncatedToMinute)
  private[this] def dimensionsByHour(x: StatsA): StatsA   = zero(x).withTs(x.ts.truncatedToHour())
  private[this] def dimensionsByDay(x: StatsA): StatsA    = zero(x).withTs(x.ts.truncatedToDay())

}
