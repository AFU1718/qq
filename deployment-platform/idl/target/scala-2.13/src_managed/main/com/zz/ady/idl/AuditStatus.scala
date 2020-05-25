// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

/** 审核状态
  */
sealed abstract class AuditStatus(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = AuditStatus
  def isUnsubmitted: _root_.scala.Boolean = false
  def isDropped: _root_.scala.Boolean = false
  def isRefused: _root_.scala.Boolean = false
  def isPending: _root_.scala.Boolean = false
  def isPassed: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[AuditStatus] = com.zz.ady.idl.AuditStatus
  final def asRecognized: _root_.scala.Option[com.zz.ady.idl.AuditStatus.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[com.zz.ady.idl.AuditStatus.Recognized])
}

object AuditStatus extends _root_.scalapb.GeneratedEnumCompanion[AuditStatus] {
  sealed trait Recognized extends AuditStatus
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[AuditStatus] = this
  /** 未提交
    */
  @SerialVersionUID(0L)
  case object UNSUBMITTED extends AuditStatus(0) with AuditStatus.Recognized {
    val index = 0
    val name = "UNSUBMITTED"
    override def isUnsubmitted: _root_.scala.Boolean = true
  }
  
  /** 抛弃
    */
  @SerialVersionUID(0L)
  case object DROPPED extends AuditStatus(-2) with AuditStatus.Recognized {
    val index = 1
    val name = "DROPPED"
    override def isDropped: _root_.scala.Boolean = true
  }
  
  /** 拒绝
    */
  @SerialVersionUID(0L)
  case object REFUSED extends AuditStatus(-1) with AuditStatus.Recognized {
    val index = 2
    val name = "REFUSED"
    override def isRefused: _root_.scala.Boolean = true
  }
  
  /** 正在审核
    */
  @SerialVersionUID(0L)
  case object PENDING extends AuditStatus(1) with AuditStatus.Recognized {
    val index = 3
    val name = "PENDING"
    override def isPending: _root_.scala.Boolean = true
  }
  
  /** 审核通过
    */
  @SerialVersionUID(0L)
  case object PASSED extends AuditStatus(2) with AuditStatus.Recognized {
    val index = 4
    val name = "PASSED"
    override def isPassed: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends AuditStatus(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.immutable.Seq(UNSUBMITTED, DROPPED, REFUSED, PENDING, PASSED)
  def fromValue(__value: _root_.scala.Int): AuditStatus = __value match {
    case -2 => DROPPED
    case -1 => REFUSED
    case 0 => UNSUBMITTED
    case 1 => PENDING
    case 2 => PASSED
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = EnumsProto.javaDescriptor.getEnumTypes.get(12)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = EnumsProto.scalaDescriptor.enums(12)
}