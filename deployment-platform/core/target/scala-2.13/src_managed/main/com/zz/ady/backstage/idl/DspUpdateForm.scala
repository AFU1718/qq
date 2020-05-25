// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.backstage.idl

/** @param status
  *   状态
  */
@SerialVersionUID(0L)
final case class DspUpdateForm(
    name: _root_.scala.Predef.String = "",
    code: _root_.scala.Int = 0,
    status: com.zz.ady.backstage.idl.Status = com.zz.ady.backstage.idl.Status.INACTIVE
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[DspUpdateForm] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = name
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        }
      };
      
      {
        val __value = code
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(2, __value)
        }
      };
      
      {
        val __value = status.value
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeEnumSize(3, __value)
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
        val __v = name
        if (!__v.isEmpty) {
          _output__.writeString(1, __v)
        }
      };
      {
        val __v = code
        if (__v != 0) {
          _output__.writeInt32(2, __v)
        }
      };
      {
        val __v = status.value
        if (__v != 0) {
          _output__.writeEnum(3, __v)
        }
      };
    }
    def withName(__v: _root_.scala.Predef.String): DspUpdateForm = copy(name = __v)
    def withCode(__v: _root_.scala.Int): DspUpdateForm = copy(code = __v)
    def withStatus(__v: com.zz.ady.backstage.idl.Status): DspUpdateForm = copy(status = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = name
          if (__t != "") __t else null
        }
        case 2 => {
          val __t = code
          if (__t != 0) __t else null
        }
        case 3 => {
          val __t = status.javaValueDescriptor
          if (__t.getNumber() != 0) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(name)
        case 2 => _root_.scalapb.descriptors.PInt(code)
        case 3 => _root_.scalapb.descriptors.PEnum(status.scalaValueDescriptor)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.zz.ady.backstage.idl.DspUpdateForm
}

object DspUpdateForm extends scalapb.GeneratedMessageCompanion[com.zz.ady.backstage.idl.DspUpdateForm] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.zz.ady.backstage.idl.DspUpdateForm] = this
  def merge(`_message__`: com.zz.ady.backstage.idl.DspUpdateForm, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.zz.ady.backstage.idl.DspUpdateForm = {
    var __name = `_message__`.name
    var __code = `_message__`.code
    var __status = `_message__`.status
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __name = _input__.readStringRequireUtf8()
        case 16 =>
          __code = _input__.readInt32()
        case 24 =>
          __status = com.zz.ady.backstage.idl.Status.fromValue(_input__.readEnum())
        case tag => _input__.skipField(tag)
      }
    }
    com.zz.ady.backstage.idl.DspUpdateForm(
        name = __name,
        code = __code,
        status = __status
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.zz.ady.backstage.idl.DspUpdateForm] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.zz.ady.backstage.idl.DspUpdateForm(
        name = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        code = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        status = com.zz.ady.backstage.idl.Status.fromValue(__fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scalapb.descriptors.EnumValueDescriptor]).getOrElse(com.zz.ady.backstage.idl.Status.INACTIVE.scalaValueDescriptor).number)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = DspProto.javaDescriptor.getMessageTypes.get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = DspProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = {
    (__fieldNumber: @_root_.scala.unchecked) match {
      case 3 => com.zz.ady.backstage.idl.Status
    }
  }
  lazy val defaultInstance = com.zz.ady.backstage.idl.DspUpdateForm(
    name = "",
    code = 0,
    status = com.zz.ady.backstage.idl.Status.INACTIVE
  )
  implicit class DspUpdateFormLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.backstage.idl.DspUpdateForm]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.zz.ady.backstage.idl.DspUpdateForm](_l) {
    def name: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.name)((c_, f_) => c_.copy(name = f_))
    def code: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.code)((c_, f_) => c_.copy(code = f_))
    def status: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.backstage.idl.Status] = field(_.status)((c_, f_) => c_.copy(status = f_))
  }
  final val NAME_FIELD_NUMBER = 1
  final val CODE_FIELD_NUMBER = 2
  final val STATUS_FIELD_NUMBER = 3
  def of(
    name: _root_.scala.Predef.String,
    code: _root_.scala.Int,
    status: com.zz.ady.backstage.idl.Status
  ): _root_.com.zz.ady.backstage.idl.DspUpdateForm = _root_.com.zz.ady.backstage.idl.DspUpdateForm(
    name,
    code,
    status
  )
}
