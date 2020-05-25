// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

/** 新建用户
  *
  * @param name
  *   用户名
  * @param password
  *   用户密码
  * @param roleId
  *   角色id
  */
@SerialVersionUID(0L)
final case class PostUserInfo(
    name: _root_.scala.Predef.String = "",
    password: _root_.scala.Predef.String = "",
    roleId: _root_.scala.Int = 0
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[PostUserInfo] {
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
        val __value = password
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
        }
      };
      
      {
        val __value = roleId
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(3, __value)
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
        val __v = password
        if (!__v.isEmpty) {
          _output__.writeString(2, __v)
        }
      };
      {
        val __v = roleId
        if (__v != 0) {
          _output__.writeInt32(3, __v)
        }
      };
    }
    def withName(__v: _root_.scala.Predef.String): PostUserInfo = copy(name = __v)
    def withPassword(__v: _root_.scala.Predef.String): PostUserInfo = copy(password = __v)
    def withRoleId(__v: _root_.scala.Int): PostUserInfo = copy(roleId = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = name
          if (__t != "") __t else null
        }
        case 2 => {
          val __t = password
          if (__t != "") __t else null
        }
        case 3 => {
          val __t = roleId
          if (__t != 0) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(name)
        case 2 => _root_.scalapb.descriptors.PString(password)
        case 3 => _root_.scalapb.descriptors.PInt(roleId)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.zz.ady.idl.PostUserInfo
}

object PostUserInfo extends scalapb.GeneratedMessageCompanion[com.zz.ady.idl.PostUserInfo] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.zz.ady.idl.PostUserInfo] = this
  def merge(`_message__`: com.zz.ady.idl.PostUserInfo, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.zz.ady.idl.PostUserInfo = {
    var __name = `_message__`.name
    var __password = `_message__`.password
    var __roleId = `_message__`.roleId
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __name = _input__.readStringRequireUtf8()
        case 18 =>
          __password = _input__.readStringRequireUtf8()
        case 24 =>
          __roleId = _input__.readInt32()
        case tag => _input__.skipField(tag)
      }
    }
    com.zz.ady.idl.PostUserInfo(
        name = __name,
        password = __password,
        roleId = __roleId
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.zz.ady.idl.PostUserInfo] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.zz.ady.idl.PostUserInfo(
        name = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        password = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        roleId = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Int]).getOrElse(0)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = UserInfoApiProto.javaDescriptor.getMessageTypes.get(2)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = UserInfoApiProto.scalaDescriptor.messages(2)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.zz.ady.idl.PostUserInfo(
    name = "",
    password = "",
    roleId = 0
  )
  implicit class PostUserInfoLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.idl.PostUserInfo]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.zz.ady.idl.PostUserInfo](_l) {
    def name: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.name)((c_, f_) => c_.copy(name = f_))
    def password: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.password)((c_, f_) => c_.copy(password = f_))
    def roleId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.roleId)((c_, f_) => c_.copy(roleId = f_))
  }
  final val NAME_FIELD_NUMBER = 1
  final val PASSWORD_FIELD_NUMBER = 2
  final val ROLE_ID_FIELD_NUMBER = 3
  def of(
    name: _root_.scala.Predef.String,
    password: _root_.scala.Predef.String,
    roleId: _root_.scala.Int
  ): _root_.com.zz.ady.idl.PostUserInfo = _root_.com.zz.ady.idl.PostUserInfo(
    name,
    password,
    roleId
  )
}