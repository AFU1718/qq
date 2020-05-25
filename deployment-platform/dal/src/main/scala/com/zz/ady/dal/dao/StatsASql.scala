package com.zz.ady.dal.dao

import cats.implicits._
import com.typesafe.scalalogging.Logger
import doobie.implicits._
import doobie._

import com.zz.ady.idl._
import com.zz.ady.dal.monoid.Implicits._

object StatsASql extends StatsASql

trait StatsASql extends Sql {

  private[this] val logger = Logger(getClass)

  def insertByMinute(rows: Seq[StatsA]): ConnectionIO[Int] = insertGroupedByMinute(rows.aggregateByMinute.toList)

  def insertByHour(rows: Seq[StatsA]): ConnectionIO[Int] = insertGroupedByHour(rows.aggregateByHour.toList)

  def insertByDay(rows: Seq[StatsA]): ConnectionIO[Int] = insertGroupedByDay(rows.aggregateByDay.toList)

  private[this] def insertGroupedByMinute(rows: Seq[StatsA]) =
    insertGrouped("stats")(rows)
      .attemptSomeSqlState {
        case x => logger.error("{}", x)
      }
      .map(_ => 0)

  private[this] def insertGroupedByHour(rows: Seq[StatsA]) =
    insertGrouped("stats_by_hour")(rows)

  private[this] def insertGroupedByDay(rows: Seq[StatsA]) =
    insertGrouped("stats_by_day")(rows)

  private[this] def insertGrouped(tableName: String)(rows: Seq[StatsA]): doobie.ConnectionIO[Int] = {
    val q = insertSql(tableName)(rows)
    logger.debug(q.sql)
    q.run
  }

  private[this] def insertSql(tableName: String)(rows: Seq[StatsA]) = {
    val f1 = Fragment.const(
      s"""insert into "$tableName" as t (ts, placement_type, valid_type, seller_code, seller_trading_type,
                        buyer_trading_type, seller_deal_type, buyer_deal_type, os_type, drop_type,
                        interception_type, dsp_id, dsp_app_id, dsp_app_placement_id, pub_id, pub_app_id,
                        pub_app_placement_id, adx_cost_in_micro, adx_revenue_in_micro, events, seller_request,
                        adx_intercept, to_buyer_request, buyer_bid, buyer_no_bid, buyer_timeout, buyer_error,
                        adx_bid, adx_no_bid, adx_drop, win_notice, impression, click, download_started,
                        download_completed, install_started, install_completed, video_start, video_end,
                        video_click, video_close, video_skip) VALUES """)

    def f(x: StatsA) =
      fr"""(
      ${x.ts},
      ${x.placementType},
      ${x.validType},
      ${x.sellerCode},
      ${x.sellerTradingType},
      ${x.buyerTradingType},
      ${x.sellerDealType},
      ${x.buyerDealType},
      ${x.osType},
      ${x.dropType},
      ${x.interceptionType},
      ${x.dspId},
      ${x.dspAppId},
      ${x.dspAppPlacementId},
      ${x.pubId},
      ${x.pubAppId},
      ${x.pubAppPlacementId},
      ${x.adxCostInMicro},
      ${x.adxRevenueInMicro},
      ${x.events},
      ${x.sellerRequest},
      ${x.adxIntercept},
      ${x.toBuyerRequest},
      ${x.buyerBid},
      ${x.buyerNoBid},
      ${x.buyerTimeout},
      ${x.buyerError},
      ${x.adxBid},
      ${x.adxNoBid},
      ${x.adxDrop},
      ${x.winNotice},
      ${x.impression},
      ${x.click},
      ${x.downloadStarted},
      ${x.downloadCompleted},
      ${x.installStarted},
      ${x.installCompleted},
      ${x.videoStart},
      ${x.videoEnd},
      ${x.videoClick},
      ${x.videoClose},
      ${x.videoSkip}
       )""".stripMargin

    val f2 = rows.map(f).toVector.intercalate(fr", ")
    val f3 =
      fr"""on conflict (
           ts, placement_type, valid_type, seller_code, seller_trading_type, buyer_trading_type, seller_deal_type,
           buyer_deal_type, os_type, drop_type, interception_type, ext_sint_1, ext_sint_2, ext_sint_3,
           ext_sint_4, ext_sint_5, dsp_id, dsp_app_id, dsp_app_placement_id, pub_id, pub_app_id,
           pub_app_placement_id, ext_id_1, ext_id_2, ext_id_3, ext_id_4, ext_id_5
)
do
update
set adx_cost_in_micro    = t.adx_cost_in_micro + EXCLUDED.adx_cost_in_micro
  , adx_revenue_in_micro = t.adx_revenue_in_micro + EXCLUDED.adx_revenue_in_micro
  , events               = t.events + EXCLUDED.events
  , seller_request       = t.seller_request + EXCLUDED.seller_request
  , adx_intercept        = t.adx_intercept + EXCLUDED.adx_intercept
  , to_buyer_request     = t.to_buyer_request + EXCLUDED.to_buyer_request
  , buyer_bid            = t.buyer_bid + EXCLUDED.buyer_bid
  , buyer_no_bid         = t.buyer_no_bid + EXCLUDED.buyer_no_bid
  , buyer_timeout        = t.buyer_timeout + EXCLUDED.buyer_timeout
  , buyer_error          = t.buyer_error + EXCLUDED.buyer_error
  , adx_bid              = t.adx_bid + EXCLUDED.adx_bid
  , adx_no_bid           = t.adx_no_bid + EXCLUDED.adx_no_bid
  , adx_drop             = t.adx_drop + EXCLUDED.adx_drop
  , impression           = t.impression + EXCLUDED.impression
  , win_notice           = t.win_notice + EXCLUDED.win_notice
  , click                = t.click + EXCLUDED.click
  , download_started     = t.download_started + EXCLUDED.download_started
  , download_completed   = t.download_completed + EXCLUDED.download_completed
  , install_started      = t.install_started + EXCLUDED.install_started
  , install_completed    = t.install_completed + EXCLUDED.install_completed
  , video_start          = t.video_start + EXCLUDED.video_start
  , video_end            = t.video_end + EXCLUDED.video_end
  , video_click          = t.video_click + EXCLUDED.video_click
  , video_close          = t.video_close + EXCLUDED.video_close
  , video_skip           = t.video_skip + EXCLUDED.video_skip;""".stripMargin

    (f1 ++ f2 ++ f3).update
  }

}