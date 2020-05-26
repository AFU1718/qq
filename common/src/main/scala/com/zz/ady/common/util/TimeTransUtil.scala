package com.zz.ady.common.util

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.{Instant, ZoneId, ZonedDateTime}
import java.util.Date

object TimeTransUtil {

  val zoneId: ZoneId = ZoneId.of("Asia/Shanghai")

  /**
    * 时间戳转时间字符串
    * @param timestamp 时间戳
    * @return
    */
  def timestamp2String(timestamp: Long): String = {
    val simpleFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val date: Date = new Date(timestamp)
    simpleFormat.format(date)
  }

  /**
    * 时间戳转时间字符串
    * @param timestamp 时间戳
    * @return
    */
  def timestamp2String3(timestamp: Long): String = {
    val simpleFormat: SimpleDateFormat = new SimpleDateFormat("yyMMdd")
    val date: Date = new Date(timestamp)
    simpleFormat.format(date)
  }

  def timestamp2String2(timestamp: Long): String = {
    val simpleFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date: Date = new Date(timestamp)
    simpleFormat.format(date)
  }

  /**
    * 获取今天的时间
    * @return
    */
  def getToday(): Long = {
    val format: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val str: String = format.format(new Date())
    val dt = format.parse(str)
    dt.getTime
  }

  /**
    * 获取今天的时间
    * @param date date
    * @return
    */
  def getTodayString(date: Date): String = {
    val format: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    format.format(date)
  }

  /**
   * 获取今天的时间
   * @param date date
   * @return
   */
  def getDateTimeString(date: Date): String = {
    val format: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    format.format(date)
  }

  /**
    * 时间字符串转时间戳
    * @param s ss
    * @return
    */
  def stringToTimestamp(s: String): Long = {
    val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = simpleDateFormat.parse(s)
    date.getTime
  }

  /**
   * 日期字符串转时间戳
   * @param s ss
   * @return
   */
  def dateStringToTimestamp(s: String): Long = {
    val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val date = simpleDateFormat.parse(s)
    date.getTime
  }

  /**
    * 时间字符串转时间戳
    * @param s ss
    * @return
    */
  def stringToInstant(s: String): Instant = {
    val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date: Date = simpleDateFormat.parse(s)
    Instant.ofEpochMilli(date.getTime)
  }

  def stringDateToInstant(s: String): Instant = {
    val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val date: Date = simpleDateFormat.parse(s)
    Instant.ofEpochMilli(date.getTime)
  }

  def sharpByDay(ts: Long): Instant =
    Instant
      .ofEpochMilli(ts)
      .atZone(zoneId)
      .withHour(0)
      .withMinute(0)
      .withSecond(0)
      .withNano(0)
      .toInstant

  /**
    * 时间转字符串
    * @param date 时间
    * @return
    */
  def dataToString(date: Date): String = {
    val format: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val str: String = format.format(date)
    str
  }

  /**
    * 获取当天凌晨时间戳
    * @return
    */
  def getZeroTime: Long = {
    val t2: ZonedDateTime = ZonedDateTime.now(zoneId)
    val t1: ZonedDateTime = t2
      .withHour(0)
      .withMinute(0)
      .withSecond(0)
      .withNano(0)
    t1.toInstant.toEpochMilli
  }

  def nowDateToString: String = {
    val format: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val str: String = format.format(new Date())
    str
  }

  def getZeroInstant: Instant = {
    val t2: ZonedDateTime = ZonedDateTime.now(zoneId)
    val t1: ZonedDateTime = t2
      .withHour(0)
      .withMinute(0)
      .withSecond(0)
      .withNano(0)
    t1.toInstant
  }

  def getTimePlusDay(day: Int): Long = {
    val t2: ZonedDateTime = ZonedDateTime.now(zoneId)
    val t1: ZonedDateTime = t2
      .withHour(0)
      .withMinute(0)
      .withSecond(0)
      .withNano(0)
      .plusDays(day)
    t1.toInstant.toEpochMilli
  }

  def getInstantPlusDay(day: Int, t: Instant): Instant = {
    t
      .atZone(zoneId)
      .withHour(0)
      .withMinute(0)
      .withSecond(0)
      .withNano(0)
      .plusDays(day)
      .toInstant
  }

  def getInstantPlusDayToString(day: Int, t: Instant): String = {
    val simpleFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val date: Date = new Date(getInstantPlusDay(day, t).toEpochMilli)
    simpleFormat.format(date)
  }



  def getTimeMinusHour(hour: Int): Instant = {
    val t2: ZonedDateTime = ZonedDateTime.now(zoneId)
    val t1: ZonedDateTime = t2
      .minusHours(hour)
    t1.toInstant
  }

  def getTimeMinusMinute(minute: Int): Instant = {
    val t2: ZonedDateTime = ZonedDateTime.now(zoneId)
    val t1: ZonedDateTime = t2
      .minusMinutes(minute)
    t1.toInstant
  }

  /**
    * 获取当天晚上 23:59:59 时间戳
    * @return
    */
  def getLatestTime: Long = {
    val t2: ZonedDateTime = ZonedDateTime.now(zoneId)
    val t1: ZonedDateTime = t2
      .withHour(23)
      .withMinute(59)
      .withSecond(59)
    t1.toInstant.toEpochMilli
  }

  def getFiveMinuteFirstByMinute: (Long, Long) = {
    val t3: ZonedDateTime = ZonedDateTime.now(zoneId)
    val t1: ZonedDateTime = t3
      .plusMinutes(-5)
      .withSecond(0)
      .withNano(0)
    val t2: ZonedDateTime = t3
      .withSecond(0)
      .withNano(0)
    (t1.toInstant.toEpochMilli, t2.toInstant.toEpochMilli)
  }

  def getCurrentHour: Int = {
    val t = ZonedDateTime.now(zoneId)
    t.getHour
  }

  def getCurrentInstant: Instant = {
    val t = ZonedDateTime.now(zoneId)
    t.toInstant
  }

  def getTimestampHour(ts: Timestamp): Int = {
    val t = ZonedDateTime.ofInstant(ts.toInstant, zoneId)
    t.getHour
  }

  def long2Timestamp(ts: Long): Timestamp = {
    val t = ZonedDateTime.ofInstant(Instant.ofEpochMilli(ts), zoneId)
    Timestamp.from(t.toInstant)
  }

  def long2Instant(ts: Long): Instant = {
    val t = ZonedDateTime.ofInstant(Instant.ofEpochMilli(ts), zoneId)
    t.toInstant
  }
}
