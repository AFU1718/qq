package com.zz.ady.dal.model

import scala.concurrent.duration.{FiniteDuration, DurationInt}

sealed abstract class QueryGranularity(val value: Int, val name: String, val duration: Option[FiniteDuration]) extends SimpleEnum {
  type EnumType = QueryGranularity
  def companion: SimpleEnumCompanion[QueryGranularity] = QueryGranularity
}

object QueryGranularity extends SimpleEnumCompanion[QueryGranularity] {
  final case object ALL            extends QueryGranularity(0, "all", None)
  final case object SECOND         extends QueryGranularity(value = 0, name = "second", duration = Option(1.seconds))
  final case object MINUTE         extends QueryGranularity(value = 2, name = "minute", duration = Option(1.minutes))
  final case object FIVE_MINUTE    extends QueryGranularity(value = 3, name = "five_minute", duration = Option(5.minutes))
  final case object TEN_MINUTE     extends QueryGranularity(value = 4, name = "ten_minute", duration = Option(10.minutes))
  final case object FIFTEEN_MINUTE extends QueryGranularity(value = 5, name = "fifteen_minute", duration = Option(15.minutes))
  final case object THIRTY_MINUTE  extends QueryGranularity(value = 6, name = "thirty_minute", duration = Option(30.minutes))
  final case object HOUR           extends QueryGranularity(value = 7, name = "hour", duration = Option(1.hours))
  final case object DAY            extends QueryGranularity(value = 8, name = "day", duration = Option(1.days))
  final case object MONTH          extends QueryGranularity(value = 9, name = "month", duration = Option(30.days))
  final case object YEAR           extends QueryGranularity(value = 10, name = "year", duration = Option(365.days))
  val default: QueryGranularity        = ALL
  val values: Vector[QueryGranularity] = Vector(ALL, SECOND, MINUTE, FIVE_MINUTE, TEN_MINUTE, FIFTEEN_MINUTE, THIRTY_MINUTE, HOUR, DAY, MONTH, YEAR)
}
