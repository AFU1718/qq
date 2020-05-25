// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

sealed abstract class MobilePriceType(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = MobilePriceType
  def isUnknownMobilePrice: _root_.scala.Boolean = false
  def isPriceLevelOne: _root_.scala.Boolean = false
  def isPriceLevelTwo: _root_.scala.Boolean = false
  def isPriceLevelThree: _root_.scala.Boolean = false
  def isPriceLevelFour: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[MobilePriceType] = com.zz.ady.idl.MobilePriceType
  final def asRecognized: _root_.scala.Option[com.zz.ady.idl.MobilePriceType.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[com.zz.ady.idl.MobilePriceType.Recognized])
}

object MobilePriceType extends _root_.scalapb.GeneratedEnumCompanion[MobilePriceType] {
  sealed trait Recognized extends MobilePriceType
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[MobilePriceType] = this
  /** 未知
    */
  @SerialVersionUID(0L)
  case object UNKNOWN_MOBILE_PRICE extends MobilePriceType(0) with MobilePriceType.Recognized {
    val index = 0
    val name = "UNKNOWN_MOBILE_PRICE"
    override def isUnknownMobilePrice: _root_.scala.Boolean = true
  }
  
  /** 1000元以下
    */
  @SerialVersionUID(0L)
  case object PRICE_LEVEL_ONE extends MobilePriceType(1) with MobilePriceType.Recognized {
    val index = 1
    val name = "PRICE_LEVEL_ONE"
    override def isPriceLevelOne: _root_.scala.Boolean = true
  }
  
  /** 1000-2000
    */
  @SerialVersionUID(0L)
  case object PRICE_LEVEL_TWO extends MobilePriceType(2) with MobilePriceType.Recognized {
    val index = 2
    val name = "PRICE_LEVEL_TWO"
    override def isPriceLevelTwo: _root_.scala.Boolean = true
  }
  
  /** 2000-3000
    */
  @SerialVersionUID(0L)
  case object PRICE_LEVEL_THREE extends MobilePriceType(3) with MobilePriceType.Recognized {
    val index = 3
    val name = "PRICE_LEVEL_THREE"
    override def isPriceLevelThree: _root_.scala.Boolean = true
  }
  
  /** 3000元以上
    */
  @SerialVersionUID(0L)
  case object PRICE_LEVEL_FOUR extends MobilePriceType(4) with MobilePriceType.Recognized {
    val index = 4
    val name = "PRICE_LEVEL_FOUR"
    override def isPriceLevelFour: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends MobilePriceType(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.immutable.Seq(UNKNOWN_MOBILE_PRICE, PRICE_LEVEL_ONE, PRICE_LEVEL_TWO, PRICE_LEVEL_THREE, PRICE_LEVEL_FOUR)
  def fromValue(__value: _root_.scala.Int): MobilePriceType = __value match {
    case 0 => UNKNOWN_MOBILE_PRICE
    case 1 => PRICE_LEVEL_ONE
    case 2 => PRICE_LEVEL_TWO
    case 3 => PRICE_LEVEL_THREE
    case 4 => PRICE_LEVEL_FOUR
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = EnumsProto.javaDescriptor.getEnumTypes.get(7)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = EnumsProto.scalaDescriptor.enums(7)
}