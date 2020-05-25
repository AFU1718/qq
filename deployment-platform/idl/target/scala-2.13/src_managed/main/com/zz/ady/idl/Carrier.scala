// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

/** 客户端运营商
  */
sealed abstract class Carrier(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = Carrier
  def isUnknownCarrier: _root_.scala.Boolean = false
  def isChinaMobile: _root_.scala.Boolean = false
  def isChinaUnicom: _root_.scala.Boolean = false
  def isChinaTelecom: _root_.scala.Boolean = false
  def isNationalRadioAndTelevisionNetworkCompany: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[Carrier] = com.zz.ady.idl.Carrier
  final def asRecognized: _root_.scala.Option[com.zz.ady.idl.Carrier.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[com.zz.ady.idl.Carrier.Recognized])
}

object Carrier extends _root_.scalapb.GeneratedEnumCompanion[Carrier] {
  sealed trait Recognized extends Carrier
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[Carrier] = this
  /** 什么鬼
    */
  @SerialVersionUID(0L)
  case object UNKNOWN_CARRIER extends Carrier(0) with Carrier.Recognized {
    val index = 0
    val name = "UNKNOWN_CARRIER"
    override def isUnknownCarrier: _root_.scala.Boolean = true
  }
  
  /** 中国移动
    */
  @SerialVersionUID(0L)
  case object CHINA_MOBILE extends Carrier(1) with Carrier.Recognized {
    val index = 1
    val name = "CHINA_MOBILE"
    override def isChinaMobile: _root_.scala.Boolean = true
  }
  
  /** 中国联通
    */
  @SerialVersionUID(0L)
  case object CHINA_UNICOM extends Carrier(2) with Carrier.Recognized {
    val index = 2
    val name = "CHINA_UNICOM"
    override def isChinaUnicom: _root_.scala.Boolean = true
  }
  
  /** 中国电信
    */
  @SerialVersionUID(0L)
  case object CHINA_TELECOM extends Carrier(3) with Carrier.Recognized {
    val index = 3
    val name = "CHINA_TELECOM"
    override def isChinaTelecom: _root_.scala.Boolean = true
  }
  
  /** 中国广播电视网络有限公司
    */
  @SerialVersionUID(0L)
  case object NATIONAL_RADIO_AND_TELEVISION_NETWORK_COMPANY extends Carrier(4) with Carrier.Recognized {
    val index = 4
    val name = "NATIONAL_RADIO_AND_TELEVISION_NETWORK_COMPANY"
    override def isNationalRadioAndTelevisionNetworkCompany: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends Carrier(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.immutable.Seq(UNKNOWN_CARRIER, CHINA_MOBILE, CHINA_UNICOM, CHINA_TELECOM, NATIONAL_RADIO_AND_TELEVISION_NETWORK_COMPANY)
  def fromValue(__value: _root_.scala.Int): Carrier = __value match {
    case 0 => UNKNOWN_CARRIER
    case 1 => CHINA_MOBILE
    case 2 => CHINA_UNICOM
    case 3 => CHINA_TELECOM
    case 4 => NATIONAL_RADIO_AND_TELEVISION_NETWORK_COMPANY
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = EnumsProto.javaDescriptor.getEnumTypes.get(19)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = EnumsProto.scalaDescriptor.enums(19)
}