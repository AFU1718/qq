// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

/** 推广投放状态
  */
sealed abstract class PutStatus(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = PutStatus
  def isUnknownPutStatus: _root_.scala.Boolean = false
  def isPutNormal: _root_.scala.Boolean = false
  def isInsufficientBalance: _root_.scala.Boolean = false
  def isReachLimit: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[PutStatus] = com.zz.ady.idl.PutStatus
  final def asRecognized: _root_.scala.Option[com.zz.ady.idl.PutStatus.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[com.zz.ady.idl.PutStatus.Recognized])
}

object PutStatus extends _root_.scalapb.GeneratedEnumCompanion[PutStatus] {
  sealed trait Recognized extends PutStatus
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[PutStatus] = this
  /** 未知
    */
  @SerialVersionUID(0L)
  case object UNKNOWN_PUT_STATUS extends PutStatus(0) with PutStatus.Recognized {
    val index = 0
    val name = "UNKNOWN_PUT_STATUS"
    override def isUnknownPutStatus: _root_.scala.Boolean = true
  }
  
  /** 投放正常
    */
  @SerialVersionUID(0L)
  case object PUT_NORMAL extends PutStatus(1) with PutStatus.Recognized {
    val index = 1
    val name = "PUT_NORMAL"
    override def isPutNormal: _root_.scala.Boolean = true
  }
  
  /** 余额不足
    */
  @SerialVersionUID(0L)
  case object INSUFFICIENT_BALANCE extends PutStatus(2) with PutStatus.Recognized {
    val index = 2
    val name = "INSUFFICIENT_BALANCE"
    override def isInsufficientBalance: _root_.scala.Boolean = true
  }
  
  /** 达到限额
    */
  @SerialVersionUID(0L)
  case object REACH_LIMIT extends PutStatus(3) with PutStatus.Recognized {
    val index = 3
    val name = "REACH_LIMIT"
    override def isReachLimit: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends PutStatus(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.immutable.Seq(UNKNOWN_PUT_STATUS, PUT_NORMAL, INSUFFICIENT_BALANCE, REACH_LIMIT)
  def fromValue(__value: _root_.scala.Int): PutStatus = __value match {
    case 0 => UNKNOWN_PUT_STATUS
    case 1 => PUT_NORMAL
    case 2 => INSUFFICIENT_BALANCE
    case 3 => REACH_LIMIT
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = EnumsProto.javaDescriptor.getEnumTypes.get(9)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = EnumsProto.scalaDescriptor.enums(9)
}