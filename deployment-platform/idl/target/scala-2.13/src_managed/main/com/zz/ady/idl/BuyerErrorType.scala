// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

sealed abstract class BuyerErrorType(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = BuyerErrorType
  def isDefaultBuyerErrorType: _root_.scala.Boolean = false
  def isBuyerErrorParsingFailed: _root_.scala.Boolean = false
  def isBuyerErrorNot20XResponse: _root_.scala.Boolean = false
  def isUnknownBuyerError: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[BuyerErrorType] = com.zz.ady.idl.BuyerErrorType
  final def asRecognized: _root_.scala.Option[com.zz.ady.idl.BuyerErrorType.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[com.zz.ady.idl.BuyerErrorType.Recognized])
}

object BuyerErrorType extends _root_.scalapb.GeneratedEnumCompanion[BuyerErrorType] {
  sealed trait Recognized extends BuyerErrorType
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[BuyerErrorType] = this
  /** 未知错误
    */
  @SerialVersionUID(0L)
  case object DEFAULT_BUYER_ERROR_TYPE extends BuyerErrorType(0) with BuyerErrorType.Recognized {
    val index = 0
    val name = "DEFAULT_BUYER_ERROR_TYPE"
    override def isDefaultBuyerErrorType: _root_.scala.Boolean = true
  }
  
  /** 返回的结果不能被正确解析
    */
  @SerialVersionUID(0L)
  case object BUYER_ERROR_PARSING_FAILED extends BuyerErrorType(1) with BuyerErrorType.Recognized {
    val index = 1
    val name = "BUYER_ERROR_PARSING_FAILED"
    override def isBuyerErrorParsingFailed: _root_.scala.Boolean = true
  }
  
  /** 非 20x 的 HTTP 响应
    */
  @SerialVersionUID(0L)
  case object BUYER_ERROR_NOT_20X_RESPONSE extends BuyerErrorType(2) with BuyerErrorType.Recognized {
    val index = 2
    val name = "BUYER_ERROR_NOT_20X_RESPONSE"
    override def isBuyerErrorNot20XResponse: _root_.scala.Boolean = true
  }
  
  /** 其他错误
    */
  @SerialVersionUID(0L)
  case object UNKNOWN_BUYER_ERROR extends BuyerErrorType(3) with BuyerErrorType.Recognized {
    val index = 3
    val name = "UNKNOWN_BUYER_ERROR"
    override def isUnknownBuyerError: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends BuyerErrorType(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.immutable.Seq(DEFAULT_BUYER_ERROR_TYPE, BUYER_ERROR_PARSING_FAILED, BUYER_ERROR_NOT_20X_RESPONSE, UNKNOWN_BUYER_ERROR)
  def fromValue(__value: _root_.scala.Int): BuyerErrorType = __value match {
    case 0 => DEFAULT_BUYER_ERROR_TYPE
    case 1 => BUYER_ERROR_PARSING_FAILED
    case 2 => BUYER_ERROR_NOT_20X_RESPONSE
    case 3 => UNKNOWN_BUYER_ERROR
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = EnumsProto.javaDescriptor.getEnumTypes.get(31)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = EnumsProto.scalaDescriptor.enums(31)
}