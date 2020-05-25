// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

/** 交易方式
  */
sealed abstract class TradingType(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = TradingType
  def isUnknownTradingType: _root_.scala.Boolean = false
  def isRtb: _root_.scala.Boolean = false
  def isPdb: _root_.scala.Boolean = false
  def isPmp: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[TradingType] = com.zz.ady.idl.TradingType
  final def asRecognized: _root_.scala.Option[com.zz.ady.idl.TradingType.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[com.zz.ady.idl.TradingType.Recognized])
}

object TradingType extends _root_.scalapb.GeneratedEnumCompanion[TradingType] {
  sealed trait Recognized extends TradingType
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[TradingType] = this
  /** 什么鬼
    */
  @SerialVersionUID(0L)
  case object UNKNOWN_TRADING_TYPE extends TradingType(0) with TradingType.Recognized {
    val index = 0
    val name = "UNKNOWN_TRADING_TYPE"
    override def isUnknownTradingType: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  case object RTB extends TradingType(1) with TradingType.Recognized {
    val index = 1
    val name = "RTB"
    override def isRtb: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  case object PDB extends TradingType(2) with TradingType.Recognized {
    val index = 2
    val name = "PDB"
    override def isPdb: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  case object PMP extends TradingType(3) with TradingType.Recognized {
    val index = 3
    val name = "PMP"
    override def isPmp: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends TradingType(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.immutable.Seq(UNKNOWN_TRADING_TYPE, RTB, PDB, PMP)
  def fromValue(__value: _root_.scala.Int): TradingType = __value match {
    case 0 => UNKNOWN_TRADING_TYPE
    case 1 => RTB
    case 2 => PDB
    case 3 => PMP
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = EnumsProto.javaDescriptor.getEnumTypes.get(23)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = EnumsProto.scalaDescriptor.enums(23)
}