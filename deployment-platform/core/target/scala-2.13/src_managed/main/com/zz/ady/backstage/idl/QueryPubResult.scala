// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.backstage.idl

/** 查询单个Pub返回
  *
  * @param id
  *   ID
  * @param status
  *   状态
  */
@SerialVersionUID(0L)
final case class QueryPubResult(
    id: _root_.scala.Int = 0,
    name: _root_.scala.Predef.String = "",
    accountType: com.zz.ady.backstage.idl.AccountType = com.zz.ady.backstage.idl.AccountType.UNKNOWN_ACCOUNT_TYPE,
    status: com.zz.ady.backstage.idl.Status = com.zz.ady.backstage.idl.Status.INACTIVE
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[QueryPubResult] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = id
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
        val __value = accountType.value
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeEnumSize(3, __value)
        }
      };
      
      {
        val __value = status.value
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeEnumSize(4, __value)
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
        val __v = id
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
        val __v = accountType.value
        if (__v != 0) {
          _output__.writeEnum(3, __v)
        }
      };
      {
        val __v = status.value
        if (__v != 0) {
          _output__.writeEnum(4, __v)
        }
      };
    }
    def withId(__v: _root_.scala.Int): QueryPubResult = copy(id = __v)
    def withName(__v: _root_.scala.Predef.String): QueryPubResult = copy(name = __v)
    def withAccountType(__v: com.zz.ady.backstage.idl.AccountType): QueryPubResult = copy(accountType = __v)
    def withStatus(__v: com.zz.ady.backstage.idl.Status): QueryPubResult = copy(status = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = id
          if (__t != 0) __t else null
        }
        case 2 => {
          val __t = name
          if (__t != "") __t else null
        }
        case 3 => {
          val __t = accountType.javaValueDescriptor
          if (__t.getNumber() != 0) __t else null
        }
        case 4 => {
          val __t = status.javaValueDescriptor
          if (__t.getNumber() != 0) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PInt(id)
        case 2 => _root_.scalapb.descriptors.PString(name)
        case 3 => _root_.scalapb.descriptors.PEnum(accountType.scalaValueDescriptor)
        case 4 => _root_.scalapb.descriptors.PEnum(status.scalaValueDescriptor)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.zz.ady.backstage.idl.QueryPubResult
}

object QueryPubResult extends scalapb.GeneratedMessageCompanion[com.zz.ady.backstage.idl.QueryPubResult] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.zz.ady.backstage.idl.QueryPubResult] = this
  def merge(`_message__`: com.zz.ady.backstage.idl.QueryPubResult, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.zz.ady.backstage.idl.QueryPubResult = {
    var __id = `_message__`.id
    var __name = `_message__`.name
    var __accountType = `_message__`.accountType
    var __status = `_message__`.status
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __id = _input__.readInt32()
        case 18 =>
          __name = _input__.readStringRequireUtf8()
        case 24 =>
          __accountType = com.zz.ady.backstage.idl.AccountType.fromValue(_input__.readEnum())
        case 32 =>
          __status = com.zz.ady.backstage.idl.Status.fromValue(_input__.readEnum())
        case tag => _input__.skipField(tag)
      }
    }
    com.zz.ady.backstage.idl.QueryPubResult(
        id = __id,
        name = __name,
        accountType = __accountType,
        status = __status
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.zz.ady.backstage.idl.QueryPubResult] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.zz.ady.backstage.idl.QueryPubResult(
        id = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        name = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        accountType = com.zz.ady.backstage.idl.AccountType.fromValue(__fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scalapb.descriptors.EnumValueDescriptor]).getOrElse(com.zz.ady.backstage.idl.AccountType.UNKNOWN_ACCOUNT_TYPE.scalaValueDescriptor).number),
        status = com.zz.ady.backstage.idl.Status.fromValue(__fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scalapb.descriptors.EnumValueDescriptor]).getOrElse(com.zz.ady.backstage.idl.Status.INACTIVE.scalaValueDescriptor).number)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = PubProto.javaDescriptor.getMessageTypes.get(3)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = PubProto.scalaDescriptor.messages(3)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = {
    (__fieldNumber: @_root_.scala.unchecked) match {
      case 3 => com.zz.ady.backstage.idl.AccountType
      case 4 => com.zz.ady.backstage.idl.Status
    }
  }
  lazy val defaultInstance = com.zz.ady.backstage.idl.QueryPubResult(
    id = 0,
    name = "",
    accountType = com.zz.ady.backstage.idl.AccountType.UNKNOWN_ACCOUNT_TYPE,
    status = com.zz.ady.backstage.idl.Status.INACTIVE
  )
  implicit class QueryPubResultLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.backstage.idl.QueryPubResult]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.zz.ady.backstage.idl.QueryPubResult](_l) {
    def id: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.id)((c_, f_) => c_.copy(id = f_))
    def name: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.name)((c_, f_) => c_.copy(name = f_))
    def accountType: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.backstage.idl.AccountType] = field(_.accountType)((c_, f_) => c_.copy(accountType = f_))
    def status: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.backstage.idl.Status] = field(_.status)((c_, f_) => c_.copy(status = f_))
  }
  final val ID_FIELD_NUMBER = 1
  final val NAME_FIELD_NUMBER = 2
  final val ACCOUNT_TYPE_FIELD_NUMBER = 3
  final val STATUS_FIELD_NUMBER = 4
  def of(
    id: _root_.scala.Int,
    name: _root_.scala.Predef.String,
    accountType: com.zz.ady.backstage.idl.AccountType,
    status: com.zz.ady.backstage.idl.Status
  ): _root_.com.zz.ady.backstage.idl.QueryPubResult = _root_.com.zz.ady.backstage.idl.QueryPubResult(
    id,
    name,
    accountType,
    status
  )
}