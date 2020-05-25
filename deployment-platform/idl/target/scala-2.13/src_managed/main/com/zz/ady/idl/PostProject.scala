// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.idl

/** 新建项目
  *
  * @param projectGroupId
  *   项目组id
  * @param projectName
  *   项目名称
  * @param projectType
  *   项目类型
  * @param note
  *   备注
  * @param createdBy
  *   创建人id
  * @param updatedBy
  *   最近更新人id
  */
@SerialVersionUID(0L)
final case class PostProject(
    projectGroupId: _root_.scala.Int = 0,
    projectName: _root_.scala.Predef.String = "",
    projectType: _root_.scala.Predef.String = "",
    note: _root_.scala.Predef.String = "",
    createdBy: _root_.scala.Int = 0,
    updatedBy: _root_.scala.Int = 0
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[PostProject] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = projectGroupId
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(1, __value)
        }
      };
      
      {
        val __value = projectName
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, __value)
        }
      };
      
      {
        val __value = projectType
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(3, __value)
        }
      };
      
      {
        val __value = note
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(4, __value)
        }
      };
      
      {
        val __value = createdBy
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(5, __value)
        }
      };
      
      {
        val __value = updatedBy
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(6, __value)
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
        val __v = projectGroupId
        if (__v != 0) {
          _output__.writeInt32(1, __v)
        }
      };
      {
        val __v = projectName
        if (!__v.isEmpty) {
          _output__.writeString(2, __v)
        }
      };
      {
        val __v = projectType
        if (!__v.isEmpty) {
          _output__.writeString(3, __v)
        }
      };
      {
        val __v = note
        if (!__v.isEmpty) {
          _output__.writeString(4, __v)
        }
      };
      {
        val __v = createdBy
        if (__v != 0) {
          _output__.writeInt32(5, __v)
        }
      };
      {
        val __v = updatedBy
        if (__v != 0) {
          _output__.writeInt32(6, __v)
        }
      };
    }
    def withProjectGroupId(__v: _root_.scala.Int): PostProject = copy(projectGroupId = __v)
    def withProjectName(__v: _root_.scala.Predef.String): PostProject = copy(projectName = __v)
    def withProjectType(__v: _root_.scala.Predef.String): PostProject = copy(projectType = __v)
    def withNote(__v: _root_.scala.Predef.String): PostProject = copy(note = __v)
    def withCreatedBy(__v: _root_.scala.Int): PostProject = copy(createdBy = __v)
    def withUpdatedBy(__v: _root_.scala.Int): PostProject = copy(updatedBy = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = projectGroupId
          if (__t != 0) __t else null
        }
        case 2 => {
          val __t = projectName
          if (__t != "") __t else null
        }
        case 3 => {
          val __t = projectType
          if (__t != "") __t else null
        }
        case 4 => {
          val __t = note
          if (__t != "") __t else null
        }
        case 5 => {
          val __t = createdBy
          if (__t != 0) __t else null
        }
        case 6 => {
          val __t = updatedBy
          if (__t != 0) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PInt(projectGroupId)
        case 2 => _root_.scalapb.descriptors.PString(projectName)
        case 3 => _root_.scalapb.descriptors.PString(projectType)
        case 4 => _root_.scalapb.descriptors.PString(note)
        case 5 => _root_.scalapb.descriptors.PInt(createdBy)
        case 6 => _root_.scalapb.descriptors.PInt(updatedBy)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.zz.ady.idl.PostProject
}

object PostProject extends scalapb.GeneratedMessageCompanion[com.zz.ady.idl.PostProject] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.zz.ady.idl.PostProject] = this
  def merge(`_message__`: com.zz.ady.idl.PostProject, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.zz.ady.idl.PostProject = {
    var __projectGroupId = `_message__`.projectGroupId
    var __projectName = `_message__`.projectName
    var __projectType = `_message__`.projectType
    var __note = `_message__`.note
    var __createdBy = `_message__`.createdBy
    var __updatedBy = `_message__`.updatedBy
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __projectGroupId = _input__.readInt32()
        case 18 =>
          __projectName = _input__.readStringRequireUtf8()
        case 26 =>
          __projectType = _input__.readStringRequireUtf8()
        case 34 =>
          __note = _input__.readStringRequireUtf8()
        case 40 =>
          __createdBy = _input__.readInt32()
        case 48 =>
          __updatedBy = _input__.readInt32()
        case tag => _input__.skipField(tag)
      }
    }
    com.zz.ady.idl.PostProject(
        projectGroupId = __projectGroupId,
        projectName = __projectName,
        projectType = __projectType,
        note = __note,
        createdBy = __createdBy,
        updatedBy = __updatedBy
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.zz.ady.idl.PostProject] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.zz.ady.idl.PostProject(
        projectGroupId = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        projectName = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        projectType = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        note = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        createdBy = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        updatedBy = __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.scala.Int]).getOrElse(0)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = ProjectApiProto.javaDescriptor.getMessageTypes.get(2)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = ProjectApiProto.scalaDescriptor.messages(2)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.zz.ady.idl.PostProject(
    projectGroupId = 0,
    projectName = "",
    projectType = "",
    note = "",
    createdBy = 0,
    updatedBy = 0
  )
  implicit class PostProjectLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.idl.PostProject]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.zz.ady.idl.PostProject](_l) {
    def projectGroupId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.projectGroupId)((c_, f_) => c_.copy(projectGroupId = f_))
    def projectName: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.projectName)((c_, f_) => c_.copy(projectName = f_))
    def projectType: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.projectType)((c_, f_) => c_.copy(projectType = f_))
    def note: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.note)((c_, f_) => c_.copy(note = f_))
    def createdBy: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.createdBy)((c_, f_) => c_.copy(createdBy = f_))
    def updatedBy: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.updatedBy)((c_, f_) => c_.copy(updatedBy = f_))
  }
  final val PROJECT_GROUP_ID_FIELD_NUMBER = 1
  final val PROJECT_NAME_FIELD_NUMBER = 2
  final val PROJECT_TYPE_FIELD_NUMBER = 3
  final val NOTE_FIELD_NUMBER = 4
  final val CREATED_BY_FIELD_NUMBER = 5
  final val UPDATED_BY_FIELD_NUMBER = 6
  def of(
    projectGroupId: _root_.scala.Int,
    projectName: _root_.scala.Predef.String,
    projectType: _root_.scala.Predef.String,
    note: _root_.scala.Predef.String,
    createdBy: _root_.scala.Int,
    updatedBy: _root_.scala.Int
  ): _root_.com.zz.ady.idl.PostProject = _root_.com.zz.ady.idl.PostProject(
    projectGroupId,
    projectName,
    projectType,
    note,
    createdBy,
    updatedBy
  )
}
