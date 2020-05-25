// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.backstage.idl

/** 广告位类型
  */
sealed abstract class PlacementType(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = PlacementType
  def isUnknownPlacementType: _root_.scala.Boolean = false
  def isBannerPlacement: _root_.scala.Boolean = false
  def isInterstitialPlacement: _root_.scala.Boolean = false
  def isSplashPlacement: _root_.scala.Boolean = false
  def isNativePlacement: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[PlacementType] = com.zz.ady.backstage.idl.PlacementType
  final def asRecognized: _root_.scala.Option[com.zz.ady.backstage.idl.PlacementType.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[com.zz.ady.backstage.idl.PlacementType.Recognized])
}

object PlacementType extends _root_.scalapb.GeneratedEnumCompanion[PlacementType] {
  sealed trait Recognized extends PlacementType
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[PlacementType] = this
  /** 未知类型
    */
  @SerialVersionUID(0L)
  case object UNKNOWN_PLACEMENT_TYPE extends PlacementType(0) with PlacementType.Recognized {
    val index = 0
    val name = "UNKNOWN_PLACEMENT_TYPE"
    override def isUnknownPlacementType: _root_.scala.Boolean = true
  }
  
  /** 横幅
    */
  @SerialVersionUID(0L)
  case object BANNER_PLACEMENT extends PlacementType(1) with PlacementType.Recognized {
    val index = 1
    val name = "BANNER_PLACEMENT"
    override def isBannerPlacement: _root_.scala.Boolean = true
  }
  
  /** 插页
    */
  @SerialVersionUID(0L)
  case object INTERSTITIAL_PLACEMENT extends PlacementType(2) with PlacementType.Recognized {
    val index = 2
    val name = "INTERSTITIAL_PLACEMENT"
    override def isInterstitialPlacement: _root_.scala.Boolean = true
  }
  
  /** 开屏
    */
  @SerialVersionUID(0L)
  case object SPLASH_PLACEMENT extends PlacementType(3) with PlacementType.Recognized {
    val index = 3
    val name = "SPLASH_PLACEMENT"
    override def isSplashPlacement: _root_.scala.Boolean = true
  }
  
  /** 信息流, 原生广告
    */
  @SerialVersionUID(0L)
  case object NATIVE_PLACEMENT extends PlacementType(4) with PlacementType.Recognized {
    val index = 4
    val name = "NATIVE_PLACEMENT"
    override def isNativePlacement: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends PlacementType(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.immutable.Seq(UNKNOWN_PLACEMENT_TYPE, BANNER_PLACEMENT, INTERSTITIAL_PLACEMENT, SPLASH_PLACEMENT, NATIVE_PLACEMENT)
  def fromValue(__value: _root_.scala.Int): PlacementType = __value match {
    case 0 => UNKNOWN_PLACEMENT_TYPE
    case 1 => BANNER_PLACEMENT
    case 2 => INTERSTITIAL_PLACEMENT
    case 3 => SPLASH_PLACEMENT
    case 4 => NATIVE_PLACEMENT
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = EnumsProto.javaDescriptor.getEnumTypes.get(2)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = EnumsProto.scalaDescriptor.enums(2)
}