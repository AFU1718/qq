// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

/** 文件格式
  */
sealed abstract class FileFormatEnum(val value: _root_.scala.Int) extends _root_.scalapb.GeneratedEnum {
  type EnumType = FileFormatEnum
  def isUnknownFormat: _root_.scala.Boolean = false
  def isJpeg: _root_.scala.Boolean = false
  def isPng: _root_.scala.Boolean = false
  def isGif: _root_.scala.Boolean = false
  def isFlash: _root_.scala.Boolean = false
  def isMp4: _root_.scala.Boolean = false
  def isFlv: _root_.scala.Boolean = false
  def isMp3: _root_.scala.Boolean = false
  def companion: _root_.scalapb.GeneratedEnumCompanion[FileFormatEnum] = com.zz.ady.idl.FileFormatEnum
  final def asRecognized: _root_.scala.Option[com.zz.ady.idl.FileFormatEnum.Recognized] = if (isUnrecognized) _root_.scala.None else _root_.scala.Some(this.asInstanceOf[com.zz.ady.idl.FileFormatEnum.Recognized])
}

object FileFormatEnum extends _root_.scalapb.GeneratedEnumCompanion[FileFormatEnum] {
  sealed trait Recognized extends FileFormatEnum
  implicit def enumCompanion: _root_.scalapb.GeneratedEnumCompanion[FileFormatEnum] = this
  /** 未知格式
    */
  @SerialVersionUID(0L)
  case object UNKNOWN_FORMAT extends FileFormatEnum(0) with FileFormatEnum.Recognized {
    val index = 0
    val name = "UNKNOWN_FORMAT"
    override def isUnknownFormat: _root_.scala.Boolean = true
  }
  
  /** .jpg/.jpeg
    */
  @SerialVersionUID(0L)
  case object JPEG extends FileFormatEnum(1) with FileFormatEnum.Recognized {
    val index = 1
    val name = "JPEG"
    override def isJpeg: _root_.scala.Boolean = true
  }
  
  /** .png
    */
  @SerialVersionUID(0L)
  case object PNG extends FileFormatEnum(2) with FileFormatEnum.Recognized {
    val index = 2
    val name = "PNG"
    override def isPng: _root_.scala.Boolean = true
  }
  
  /** .gif
    */
  @SerialVersionUID(0L)
  case object GIF extends FileFormatEnum(3) with FileFormatEnum.Recognized {
    val index = 3
    val name = "GIF"
    override def isGif: _root_.scala.Boolean = true
  }
  
  /** .flash
    */
  @SerialVersionUID(0L)
  case object FLASH extends FileFormatEnum(4) with FileFormatEnum.Recognized {
    val index = 4
    val name = "FLASH"
    override def isFlash: _root_.scala.Boolean = true
  }
  
  /** .mp4
    */
  @SerialVersionUID(0L)
  case object MP4 extends FileFormatEnum(5) with FileFormatEnum.Recognized {
    val index = 5
    val name = "MP4"
    override def isMp4: _root_.scala.Boolean = true
  }
  
  /** .flv
    */
  @SerialVersionUID(0L)
  case object FLV extends FileFormatEnum(6) with FileFormatEnum.Recognized {
    val index = 6
    val name = "FLV"
    override def isFlv: _root_.scala.Boolean = true
  }
  
  /** .mp3
    */
  @SerialVersionUID(0L)
  case object MP3 extends FileFormatEnum(7) with FileFormatEnum.Recognized {
    val index = 7
    val name = "MP3"
    override def isMp3: _root_.scala.Boolean = true
  }
  
  @SerialVersionUID(0L)
  final case class Unrecognized(unrecognizedValue: _root_.scala.Int) extends FileFormatEnum(unrecognizedValue) with _root_.scalapb.UnrecognizedEnum
  
  lazy val values = scala.collection.immutable.Seq(UNKNOWN_FORMAT, JPEG, PNG, GIF, FLASH, MP4, FLV, MP3)
  def fromValue(__value: _root_.scala.Int): FileFormatEnum = __value match {
    case 0 => UNKNOWN_FORMAT
    case 1 => JPEG
    case 2 => PNG
    case 3 => GIF
    case 4 => FLASH
    case 5 => MP4
    case 6 => FLV
    case 7 => MP3
    case __other => Unrecognized(__other)
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.EnumDescriptor = EnumsProto.javaDescriptor.getEnumTypes.get(11)
  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor = EnumsProto.scalaDescriptor.enums(11)
}