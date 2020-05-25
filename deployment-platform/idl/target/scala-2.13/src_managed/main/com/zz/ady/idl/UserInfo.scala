// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

/** 用户信息
  *
  * @param id
  *   用户信息id
  * @param name
  *   用户名
  * @param password
  *   用户密码
  * @param roleId
  *   角色id
  * @param createdAt
  *   创建时间
  * @param updatedAt
  *   最近更新时间
  * @param isDeleted
  *   删除标记
  */
@SerialVersionUID(0L)
final case class UserInfo(
    id: _root_.scala.Int = 0,
    name: _root_.scala.Predef.String = "",
    password: _root_.scala.Predef.String = "",
    roleId: _root_.scala.Int = 0,
    createdAt: _root_.scala.Predef.String = "",
    updatedAt: _root_.scala.Predef.String = "",
    isDeleted: _root_.scala.Int = 0
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[UserInfo] {
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
        val __value = password
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(3, __value)
        }
      };
      
      {
        val __value = roleId
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(4, __value)
        }
      };
      
      {
        val __value = createdAt
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(5, __value)
        }
      };
      
      {
        val __value = updatedAt
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(6, __value)
        }
      };
      
      {
        val __value = isDeleted
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(7, __value)
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
        val __v = password
        if (!__v.isEmpty) {
          _output__.writeString(3, __v)
        }
      };
      {
        val __v = roleId
        if (__v != 0) {
          _output__.writeInt32(4, __v)
        }
      };
      {
        val __v = createdAt
        if (!__v.isEmpty) {
          _output__.writeString(5, __v)
        }
      };
      {
        val __v = updatedAt
        if (!__v.isEmpty) {
          _output__.writeString(6, __v)
        }
      };
      {
        val __v = isDeleted
        if (__v != 0) {
          _output__.writeInt32(7, __v)
        }
      };
    }
    def withId(__v: _root_.scala.Int): UserInfo = copy(id = __v)
    def withName(__v: _root_.scala.Predef.String): UserInfo = copy(name = __v)
    def withPassword(__v: _root_.scala.Predef.String): UserInfo = copy(password = __v)
    def withRoleId(__v: _root_.scala.Int): UserInfo = copy(roleId = __v)
    def withCreatedAt(__v: _root_.scala.Predef.String): UserInfo = copy(createdAt = __v)
    def withUpdatedAt(__v: _root_.scala.Predef.String): UserInfo = copy(updatedAt = __v)
    def withIsDeleted(__v: _root_.scala.Int): UserInfo = copy(isDeleted = __v)
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
          val __t = password
          if (__t != "") __t else null
        }
        case 4 => {
          val __t = roleId
          if (__t != 0) __t else null
        }
        case 5 => {
          val __t = createdAt
          if (__t != "") __t else null
        }
        case 6 => {
          val __t = updatedAt
          if (__t != "") __t else null
        }
        case 7 => {
          val __t = isDeleted
          if (__t != 0) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PInt(id)
        case 2 => _root_.scalapb.descriptors.PString(name)
        case 3 => _root_.scalapb.descriptors.PString(password)
        case 4 => _root_.scalapb.descriptors.PInt(roleId)
        case 5 => _root_.scalapb.descriptors.PString(createdAt)
        case 6 => _root_.scalapb.descriptors.PString(updatedAt)
        case 7 => _root_.scalapb.descriptors.PInt(isDeleted)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.zz.ady.idl.UserInfo
}

object UserInfo extends scalapb.GeneratedMessageCompanion[com.zz.ady.idl.UserInfo] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.zz.ady.idl.UserInfo] = this
  def merge(`_message__`: com.zz.ady.idl.UserInfo, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.zz.ady.idl.UserInfo = {
    var __id = `_message__`.id
    var __name = `_message__`.name
    var __password = `_message__`.password
    var __roleId = `_message__`.roleId
    var __createdAt = `_message__`.createdAt
    var __updatedAt = `_message__`.updatedAt
    var __isDeleted = `_message__`.isDeleted
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __id = _input__.readInt32()
        case 18 =>
          __name = _input__.readStringRequireUtf8()
        case 26 =>
          __password = _input__.readStringRequireUtf8()
        case 32 =>
          __roleId = _input__.readInt32()
        case 42 =>
          __createdAt = _input__.readStringRequireUtf8()
        case 50 =>
          __updatedAt = _input__.readStringRequireUtf8()
        case 56 =>
          __isDeleted = _input__.readInt32()
        case tag => _input__.skipField(tag)
      }
    }
    com.zz.ady.idl.UserInfo(
        id = __id,
        name = __name,
        password = __password,
        roleId = __roleId,
        createdAt = __createdAt,
        updatedAt = __updatedAt,
        isDeleted = __isDeleted
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.zz.ady.idl.UserInfo] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.zz.ady.idl.UserInfo(
        id = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        name = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        password = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        roleId = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        createdAt = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        updatedAt = __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        isDeleted = __fieldsMap.get(scalaDescriptor.findFieldByNumber(7).get).map(_.as[_root_.scala.Int]).getOrElse(0)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = UserInfoApiProto.javaDescriptor.getMessageTypes.get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = UserInfoApiProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.zz.ady.idl.UserInfo(
    id = 0,
    name = "",
    password = "",
    roleId = 0,
    createdAt = "",
    updatedAt = "",
    isDeleted = 0
  )
  implicit class UserInfoLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.idl.UserInfo]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.zz.ady.idl.UserInfo](_l) {
    def id: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.id)((c_, f_) => c_.copy(id = f_))
    def name: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.name)((c_, f_) => c_.copy(name = f_))
    def password: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.password)((c_, f_) => c_.copy(password = f_))
    def roleId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.roleId)((c_, f_) => c_.copy(roleId = f_))
    def createdAt: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.createdAt)((c_, f_) => c_.copy(createdAt = f_))
    def updatedAt: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.updatedAt)((c_, f_) => c_.copy(updatedAt = f_))
    def isDeleted: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.isDeleted)((c_, f_) => c_.copy(isDeleted = f_))
  }
  final val ID_FIELD_NUMBER = 1
  final val NAME_FIELD_NUMBER = 2
  final val PASSWORD_FIELD_NUMBER = 3
  final val ROLE_ID_FIELD_NUMBER = 4
  final val CREATED_AT_FIELD_NUMBER = 5
  final val UPDATED_AT_FIELD_NUMBER = 6
  final val IS_DELETED_FIELD_NUMBER = 7
  def of(
    id: _root_.scala.Int,
    name: _root_.scala.Predef.String,
    password: _root_.scala.Predef.String,
    roleId: _root_.scala.Int,
    createdAt: _root_.scala.Predef.String,
    updatedAt: _root_.scala.Predef.String,
    isDeleted: _root_.scala.Int
  ): _root_.com.zz.ady.idl.UserInfo = _root_.com.zz.ady.idl.UserInfo(
    id,
    name,
    password,
    roleId,
    createdAt,
    updatedAt,
    isDeleted
  )
}
