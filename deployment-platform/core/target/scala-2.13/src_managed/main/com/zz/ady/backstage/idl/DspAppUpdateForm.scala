// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.backstage.idl

@SerialVersionUID(0L)
final case class DspAppUpdateForm(
    dspId: _root_.scala.Int = 0,
    name: _root_.scala.Predef.String = "",
    isZzApi: com.zz.ady.backstage.idl.Bool = com.zz.ady.backstage.idl.Bool.False,
    url: _root_.scala.Predef.String = "",
    lowest: _root_.scala.Int = 0,
    pkg: _root_.scala.Predef.String = "",
    pkgVersion: _root_.scala.Predef.String = "",
    pkgVersionName: _root_.scala.Predef.String = "",
    dspAppKey: _root_.scala.Predef.String = ""
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[DspAppUpdateForm] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = dspId
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(1, __value)
        }
      };
      
      {
        val __value = name
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
        }
      };
      
      {
        val __value = isZzApi.value
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeEnumSize(3, __value)
        }
      };
      
      {
        val __value = url
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(4, __value)
        }
      };
      
      {
        val __value = lowest
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(5, __value)
        }
      };
      
      {
        val __value = pkg
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(6, __value)
        }
      };
      
      {
        val __value = pkgVersion
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(7, __value)
        }
      };
      
      {
        val __value = pkgVersionName
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(8, __value)
        }
      };
      
      {
        val __value = dspAppKey
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(9, __value)
        }
      };
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = dspId
        if (__v != 0) {
          _output__.writeInt32(1, __v)
        }
      };
      {
        val __v = name
        if (!__v.isEmpty) {
          _output__.writeString(2, __v)
        }
      };
      {
        val __v = isZzApi.value
        if (__v != 0) {
          _output__.writeEnum(3, __v)
        }
      };
      {
        val __v = url
        if (!__v.isEmpty) {
          _output__.writeString(4, __v)
        }
      };
      {
        val __v = lowest
        if (__v != 0) {
          _output__.writeInt32(5, __v)
        }
      };
      {
        val __v = pkg
        if (!__v.isEmpty) {
          _output__.writeString(6, __v)
        }
      };
      {
        val __v = pkgVersion
        if (!__v.isEmpty) {
          _output__.writeString(7, __v)
        }
      };
      {
        val __v = pkgVersionName
        if (!__v.isEmpty) {
          _output__.writeString(8, __v)
        }
      };
      {
        val __v = dspAppKey
        if (!__v.isEmpty) {
          _output__.writeString(9, __v)
        }
      };
    }
    def withDspId(__v: _root_.scala.Int): DspAppUpdateForm = copy(dspId = __v)
    def withName(__v: _root_.scala.Predef.String): DspAppUpdateForm = copy(name = __v)
    def withIsZzApi(__v: com.zz.ady.backstage.idl.Bool): DspAppUpdateForm = copy(isZzApi = __v)
    def withUrl(__v: _root_.scala.Predef.String): DspAppUpdateForm = copy(url = __v)
    def withLowest(__v: _root_.scala.Int): DspAppUpdateForm = copy(lowest = __v)
    def withPkg(__v: _root_.scala.Predef.String): DspAppUpdateForm = copy(pkg = __v)
    def withPkgVersion(__v: _root_.scala.Predef.String): DspAppUpdateForm = copy(pkgVersion = __v)
    def withPkgVersionName(__v: _root_.scala.Predef.String): DspAppUpdateForm = copy(pkgVersionName = __v)
    def withDspAppKey(__v: _root_.scala.Predef.String): DspAppUpdateForm = copy(dspAppKey = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = dspId
          if (__t != 0) __t else null
        }
        case 2 => {
          val __t = name
          if (__t != "") __t else null
        }
        case 3 => {
          val __t = isZzApi.javaValueDescriptor
          if (__t.getNumber() != 0) __t else null
        }
        case 4 => {
          val __t = url
          if (__t != "") __t else null
        }
        case 5 => {
          val __t = lowest
          if (__t != 0) __t else null
        }
        case 6 => {
          val __t = pkg
          if (__t != "") __t else null
        }
        case 7 => {
          val __t = pkgVersion
          if (__t != "") __t else null
        }
        case 8 => {
          val __t = pkgVersionName
          if (__t != "") __t else null
        }
        case 9 => {
          val __t = dspAppKey
          if (__t != "") __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PInt(dspId)
        case 2 => _root_.scalapb.descriptors.PString(name)
        case 3 => _root_.scalapb.descriptors.PEnum(isZzApi.scalaValueDescriptor)
        case 4 => _root_.scalapb.descriptors.PString(url)
        case 5 => _root_.scalapb.descriptors.PInt(lowest)
        case 6 => _root_.scalapb.descriptors.PString(pkg)
        case 7 => _root_.scalapb.descriptors.PString(pkgVersion)
        case 8 => _root_.scalapb.descriptors.PString(pkgVersionName)
        case 9 => _root_.scalapb.descriptors.PString(dspAppKey)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.zz.ady.backstage.idl.DspAppUpdateForm
}

object DspAppUpdateForm extends scalapb.GeneratedMessageCompanion[com.zz.ady.backstage.idl.DspAppUpdateForm] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.zz.ady.backstage.idl.DspAppUpdateForm] = this
  def merge(`_message__`: com.zz.ady.backstage.idl.DspAppUpdateForm, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.zz.ady.backstage.idl.DspAppUpdateForm = {
    var __dspId = `_message__`.dspId
    var __name = `_message__`.name
    var __isZzApi = `_message__`.isZzApi
    var __url = `_message__`.url
    var __lowest = `_message__`.lowest
    var __pkg = `_message__`.pkg
    var __pkgVersion = `_message__`.pkgVersion
    var __pkgVersionName = `_message__`.pkgVersionName
    var __dspAppKey = `_message__`.dspAppKey
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __dspId = _input__.readInt32()
        case 18 =>
          __name = _input__.readStringRequireUtf8()
        case 24 =>
          __isZzApi = com.zz.ady.backstage.idl.Bool.fromValue(_input__.readEnum())
        case 34 =>
          __url = _input__.readStringRequireUtf8()
        case 40 =>
          __lowest = _input__.readInt32()
        case 50 =>
          __pkg = _input__.readStringRequireUtf8()
        case 58 =>
          __pkgVersion = _input__.readStringRequireUtf8()
        case 66 =>
          __pkgVersionName = _input__.readStringRequireUtf8()
        case 74 =>
          __dspAppKey = _input__.readStringRequireUtf8()
        case tag => _input__.skipField(tag)
      }
    }
    com.zz.ady.backstage.idl.DspAppUpdateForm(
        dspId = __dspId,
        name = __name,
        isZzApi = __isZzApi,
        url = __url,
        lowest = __lowest,
        pkg = __pkg,
        pkgVersion = __pkgVersion,
        pkgVersionName = __pkgVersionName,
        dspAppKey = __dspAppKey
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.zz.ady.backstage.idl.DspAppUpdateForm] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.zz.ady.backstage.idl.DspAppUpdateForm(
        dspId = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        name = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        isZzApi = com.zz.ady.backstage.idl.Bool.fromValue(__fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scalapb.descriptors.EnumValueDescriptor]).getOrElse(com.zz.ady.backstage.idl.Bool.False.scalaValueDescriptor).number),
        url = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        lowest = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        pkg = __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        pkgVersion = __fieldsMap.get(scalaDescriptor.findFieldByNumber(7).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        pkgVersionName = __fieldsMap.get(scalaDescriptor.findFieldByNumber(8).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        dspAppKey = __fieldsMap.get(scalaDescriptor.findFieldByNumber(9).get).map(_.as[_root_.scala.Predef.String]).getOrElse("")
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = DspProto.javaDescriptor.getMessageTypes.get(1)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = DspProto.scalaDescriptor.messages(1)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = {
    (__fieldNumber: @_root_.scala.unchecked) match {
      case 3 => com.zz.ady.backstage.idl.Bool
    }
  }
  lazy val defaultInstance = com.zz.ady.backstage.idl.DspAppUpdateForm(
    dspId = 0,
    name = "",
    isZzApi = com.zz.ady.backstage.idl.Bool.False,
    url = "",
    lowest = 0,
    pkg = "",
    pkgVersion = "",
    pkgVersionName = "",
    dspAppKey = ""
  )
  implicit class DspAppUpdateFormLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.backstage.idl.DspAppUpdateForm]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.zz.ady.backstage.idl.DspAppUpdateForm](_l) {
    def dspId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.dspId)((c_, f_) => c_.copy(dspId = f_))
    def name: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.name)((c_, f_) => c_.copy(name = f_))
    def isZzApi: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.backstage.idl.Bool] = field(_.isZzApi)((c_, f_) => c_.copy(isZzApi = f_))
    def url: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.url)((c_, f_) => c_.copy(url = f_))
    def lowest: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.lowest)((c_, f_) => c_.copy(lowest = f_))
    def pkg: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.pkg)((c_, f_) => c_.copy(pkg = f_))
    def pkgVersion: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.pkgVersion)((c_, f_) => c_.copy(pkgVersion = f_))
    def pkgVersionName: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.pkgVersionName)((c_, f_) => c_.copy(pkgVersionName = f_))
    def dspAppKey: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.dspAppKey)((c_, f_) => c_.copy(dspAppKey = f_))
  }
  final val DSP_ID_FIELD_NUMBER = 1
  final val NAME_FIELD_NUMBER = 2
  final val IS_ZZ_API_FIELD_NUMBER = 3
  final val URL_FIELD_NUMBER = 4
  final val LOWEST_FIELD_NUMBER = 5
  final val PKG_FIELD_NUMBER = 6
  final val PKG_VERSION_FIELD_NUMBER = 7
  final val PKG_VERSION_NAME_FIELD_NUMBER = 8
  final val DSP_APP_KEY_FIELD_NUMBER = 9
  def of(
    dspId: _root_.scala.Int,
    name: _root_.scala.Predef.String,
    isZzApi: com.zz.ady.backstage.idl.Bool,
    url: _root_.scala.Predef.String,
    lowest: _root_.scala.Int,
    pkg: _root_.scala.Predef.String,
    pkgVersion: _root_.scala.Predef.String,
    pkgVersionName: _root_.scala.Predef.String,
    dspAppKey: _root_.scala.Predef.String
  ): _root_.com.zz.ady.backstage.idl.DspAppUpdateForm = _root_.com.zz.ady.backstage.idl.DspAppUpdateForm(
    dspId,
    name,
    isZzApi,
    url,
    lowest,
    pkg,
    pkgVersion,
    pkgVersionName,
    dspAppKey
  )
}