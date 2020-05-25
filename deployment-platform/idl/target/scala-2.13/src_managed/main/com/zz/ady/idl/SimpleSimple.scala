// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

sealed abstract class SimpleSimple(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = SimpleSimple
  def isUnknownUnknown: _root_.scala.Boolean = false
  def isSimple: _root_.scala.Boolean = false
  def isCompleted: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[SimpleSimple] = com.zz.ady.idl.SimpleSimple
  final def asRecognized: _root_.scala.Option[com.zz.ady.idl.SimpleSimple.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[com.zz.ady.idl.SimpleSimple.Recognized])
}

object SimpleSimple extends _root_.scalapb.GeneratedEnumCompanion[SimpleSimple] {
  sealed trait Recognized extends SimpleSimple
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[SimpleSimple] = this
  @SerialVersionUID(0L)
  case object UNKNOWN_UNKNOWN extends SimpleSimple(0) with SimpleSimple.Recognized {
    val index = 0
    val name = "UNKNOWN_UNKNOWN"
    override def isUnknownUnknown: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  case object SIMPLE extends SimpleSimple(-1) with SimpleSimple.Recognized {
    val index = 1
    val name = "SIMPLE"
    override def isSimple: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  case object COMPLETED extends SimpleSimple(-2) with SimpleSimple.Recognized {
    val index = 2
    val name = "COMPLETED"
    override def isCompleted: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends SimpleSimple(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.immutable.Seq(UNKNOWN_UNKNOWN, SIMPLE, COMPLETED)
  def fromValue(__value: _root_.scala.Int): SimpleSimple = __value match {
    case -2 => COMPLETED
    case -1 => SIMPLE
    case 0 => UNKNOWN_UNKNOWN
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = EnumsProto.javaDescriptor.getEnumTypes.get(28)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = EnumsProto.scalaDescriptor.enums(28)
}