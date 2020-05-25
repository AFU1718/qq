// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

/** 创意审核状态
  */
sealed abstract class CreativeAuditStatus(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = CreativeAuditStatus
  def isCreativeAuditStatus: _root_.scala.Boolean = false
  def isCreativeAuditPassed: _root_.scala.Boolean = false
  def isCreativeAuditPending: _root_.scala.Boolean = false
  def isCreativeAuditRefused: _root_.scala.Boolean = false
  def isCreativeAuditFrequency: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[CreativeAuditStatus] = com.zz.ady.idl.CreativeAuditStatus
  final def asRecognized: _root_.scala.Option[com.zz.ady.idl.CreativeAuditStatus.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[com.zz.ady.idl.CreativeAuditStatus.Recognized])
}

object CreativeAuditStatus extends _root_.scalapb.GeneratedEnumCompanion[CreativeAuditStatus] {
  sealed trait Recognized extends CreativeAuditStatus
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[CreativeAuditStatus] = this
  /** 待送审
    */
  @SerialVersionUID(0L)
  case object CREATIVE_AUDIT_STATUS extends CreativeAuditStatus(0) with CreativeAuditStatus.Recognized {
    val index = 0
    val name = "CREATIVE_AUDIT_STATUS"
    override def isCreativeAuditStatus: _root_.scala.Boolean = true
  }
  
  /** 通过
    */
  @SerialVersionUID(0L)
  case object CREATIVE_AUDIT_PASSED extends CreativeAuditStatus(1) with CreativeAuditStatus.Recognized {
    val index = 1
    val name = "CREATIVE_AUDIT_PASSED"
    override def isCreativeAuditPassed: _root_.scala.Boolean = true
  }
  
  /** 正在审核
    */
  @SerialVersionUID(0L)
  case object CREATIVE_AUDIT_PENDING extends CreativeAuditStatus(2) with CreativeAuditStatus.Recognized {
    val index = 2
    val name = "CREATIVE_AUDIT_PENDING"
    override def isCreativeAuditPending: _root_.scala.Boolean = true
  }
  
  /** 审核不通过
    */
  @SerialVersionUID(0L)
  case object CREATIVE_AUDIT_REFUSED extends CreativeAuditStatus(3) with CreativeAuditStatus.Recognized {
    val index = 3
    val name = "CREATIVE_AUDIT_REFUSED"
    override def isCreativeAuditRefused: _root_.scala.Boolean = true
  }
  
  /** 查询频繁
    */
  @SerialVersionUID(0L)
  case object CREATIVE_AUDIT_FREQUENCY extends CreativeAuditStatus(-1) with CreativeAuditStatus.Recognized {
    val index = 4
    val name = "CREATIVE_AUDIT_FREQUENCY"
    override def isCreativeAuditFrequency: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends CreativeAuditStatus(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.immutable.Seq(CREATIVE_AUDIT_STATUS, CREATIVE_AUDIT_PASSED, CREATIVE_AUDIT_PENDING, CREATIVE_AUDIT_REFUSED, CREATIVE_AUDIT_FREQUENCY)
  def fromValue(__value: _root_.scala.Int): CreativeAuditStatus = __value match {
    case -1 => CREATIVE_AUDIT_FREQUENCY
    case 0 => CREATIVE_AUDIT_STATUS
    case 1 => CREATIVE_AUDIT_PASSED
    case 2 => CREATIVE_AUDIT_PENDING
    case 3 => CREATIVE_AUDIT_REFUSED
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = EnumsProto.javaDescriptor.getEnumTypes.get(13)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = EnumsProto.scalaDescriptor.enums(13)
}