// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

sealed abstract class CsvLoadStatus(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = CsvLoadStatus
  def isNew: _root_.scala.Boolean = false
  def isLoading: _root_.scala.Boolean = false
  def isLoaded: _root_.scala.Boolean = false
  def isCleaning: _root_.scala.Boolean = false
  def isCleaned: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[CsvLoadStatus] = com.zz.ady.idl.CsvLoadStatus
  final def asRecognized: _root_.scala.Option[com.zz.ady.idl.CsvLoadStatus.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[com.zz.ady.idl.CsvLoadStatus.Recognized])
}

object CsvLoadStatus extends _root_.scalapb.GeneratedEnumCompanion[CsvLoadStatus] {
  sealed trait Recognized extends CsvLoadStatus
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[CsvLoadStatus] = this
  /** 新建的
    */
  @SerialVersionUID(0L)
  case object NEW extends CsvLoadStatus(0) with CsvLoadStatus.Recognized {
    val index = 0
    val name = "NEW"
    override def isNew: _root_.scala.Boolean = true
  }
  
  /** 加载中
    */
  @SerialVersionUID(0L)
  case object LOADING extends CsvLoadStatus(1) with CsvLoadStatus.Recognized {
    val index = 1
    val name = "LOADING"
    override def isLoading: _root_.scala.Boolean = true
  }
  
  /** 加载完成
    */
  @SerialVersionUID(0L)
  case object LOADED extends CsvLoadStatus(2) with CsvLoadStatus.Recognized {
    val index = 2
    val name = "LOADED"
    override def isLoaded: _root_.scala.Boolean = true
  }
  
  /** CSV正在清理中
    */
  @SerialVersionUID(0L)
  case object CLEANING extends CsvLoadStatus(3) with CsvLoadStatus.Recognized {
    val index = 3
    val name = "CLEANING"
    override def isCleaning: _root_.scala.Boolean = true
  }
  
  /** CSV文件被删除
    */
  @SerialVersionUID(0L)
  case object CLEANED extends CsvLoadStatus(4) with CsvLoadStatus.Recognized {
    val index = 4
    val name = "CLEANED"
    override def isCleaned: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends CsvLoadStatus(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.immutable.Seq(NEW, LOADING, LOADED, CLEANING, CLEANED)
  def fromValue(__value: _root_.scala.Int): CsvLoadStatus = __value match {
    case 0 => NEW
    case 1 => LOADING
    case 2 => LOADED
    case 3 => CLEANING
    case 4 => CLEANED
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = EnumsProto.javaDescriptor.getEnumTypes.get(33)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = EnumsProto.scalaDescriptor.enums(33)
}