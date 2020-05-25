// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.backstage.idl

/** 查询单个DSP应用广告位返回
  *
  * @param id
  *   ID
  */
@SerialVersionUID(0L)
final case class QueryDspAppPlacementResult(
    id: _root_.scala.Int = 0,
    dspId: _root_.scala.Int = 0,
    dspAppId: _root_.scala.Int = 0,
    name: _root_.scala.Predef.String = "",
    placementType: com.zz.ady.backstage.idl.PlacementType = com.zz.ady.backstage.idl.PlacementType.UNKNOWN_PLACEMENT_TYPE,
    placementId: _root_.scala.Predef.String = "",
    effectiveTime: _root_.scala.Predef.String = "",
    impCap: _root_.scala.Long = 0L
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[QueryDspAppPlacementResult] {
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
        val __value = dspId
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(2, __value)
        }
      };
      
      {
        val __value = dspAppId
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(3, __value)
        }
      };
      
      {
        val __value = name
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(4, __value)
        }
      };
      
      {
        val __value = placementType.value
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeEnumSize(5, __value)
        }
      };
      
      {
        val __value = placementId
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(6, __value)
        }
      };
      
      {
        val __value = effectiveTime
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(7, __value)
        }
      };
      
      {
        val __value = impCap
        if (__value != 0L) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt64Size(8, __value)
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
        val __v = dspId
        if (__v != 0) {
          _output__.writeInt32(2, __v)
        }
      };
      {
        val __v = dspAppId
        if (__v != 0) {
          _output__.writeInt32(3, __v)
        }
      };
      {
        val __v = name
        if (!__v.isEmpty) {
          _output__.writeString(4, __v)
        }
      };
      {
        val __v = placementType.value
        if (__v != 0) {
          _output__.writeEnum(5, __v)
        }
      };
      {
        val __v = placementId
        if (!__v.isEmpty) {
          _output__.writeString(6, __v)
        }
      };
      {
        val __v = effectiveTime
        if (!__v.isEmpty) {
          _output__.writeString(7, __v)
        }
      };
      {
        val __v = impCap
        if (__v != 0L) {
          _output__.writeInt64(8, __v)
        }
      };
    }
    def withId(__v: _root_.scala.Int): QueryDspAppPlacementResult = copy(id = __v)
    def withDspId(__v: _root_.scala.Int): QueryDspAppPlacementResult = copy(dspId = __v)
    def withDspAppId(__v: _root_.scala.Int): QueryDspAppPlacementResult = copy(dspAppId = __v)
    def withName(__v: _root_.scala.Predef.String): QueryDspAppPlacementResult = copy(name = __v)
    def withPlacementType(__v: com.zz.ady.backstage.idl.PlacementType): QueryDspAppPlacementResult = copy(placementType = __v)
    def withPlacementId(__v: _root_.scala.Predef.String): QueryDspAppPlacementResult = copy(placementId = __v)
    def withEffectiveTime(__v: _root_.scala.Predef.String): QueryDspAppPlacementResult = copy(effectiveTime = __v)
    def withImpCap(__v: _root_.scala.Long): QueryDspAppPlacementResult = copy(impCap = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = id
          if (__t != 0) __t else null
        }
        case 2 => {
          val __t = dspId
          if (__t != 0) __t else null
        }
        case 3 => {
          val __t = dspAppId
          if (__t != 0) __t else null
        }
        case 4 => {
          val __t = name
          if (__t != "") __t else null
        }
        case 5 => {
          val __t = placementType.javaValueDescriptor
          if (__t.getNumber() != 0) __t else null
        }
        case 6 => {
          val __t = placementId
          if (__t != "") __t else null
        }
        case 7 => {
          val __t = effectiveTime
          if (__t != "") __t else null
        }
        case 8 => {
          val __t = impCap
          if (__t != 0L) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PInt(id)
        case 2 => _root_.scalapb.descriptors.PInt(dspId)
        case 3 => _root_.scalapb.descriptors.PInt(dspAppId)
        case 4 => _root_.scalapb.descriptors.PString(name)
        case 5 => _root_.scalapb.descriptors.PEnum(placementType.scalaValueDescriptor)
        case 6 => _root_.scalapb.descriptors.PString(placementId)
        case 7 => _root_.scalapb.descriptors.PString(effectiveTime)
        case 8 => _root_.scalapb.descriptors.PLong(impCap)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.zz.ady.backstage.idl.QueryDspAppPlacementResult
}

object QueryDspAppPlacementResult extends scalapb.GeneratedMessageCompanion[com.zz.ady.backstage.idl.QueryDspAppPlacementResult] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.zz.ady.backstage.idl.QueryDspAppPlacementResult] = this
  def merge(`_message__`: com.zz.ady.backstage.idl.QueryDspAppPlacementResult, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.zz.ady.backstage.idl.QueryDspAppPlacementResult = {
    var __id = `_message__`.id
    var __dspId = `_message__`.dspId
    var __dspAppId = `_message__`.dspAppId
    var __name = `_message__`.name
    var __placementType = `_message__`.placementType
    var __placementId = `_message__`.placementId
    var __effectiveTime = `_message__`.effectiveTime
    var __impCap = `_message__`.impCap
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __id = _input__.readInt32()
        case 16 =>
          __dspId = _input__.readInt32()
        case 24 =>
          __dspAppId = _input__.readInt32()
        case 34 =>
          __name = _input__.readStringRequireUtf8()
        case 40 =>
          __placementType = com.zz.ady.backstage.idl.PlacementType.fromValue(_input__.readEnum())
        case 50 =>
          __placementId = _input__.readStringRequireUtf8()
        case 58 =>
          __effectiveTime = _input__.readStringRequireUtf8()
        case 64 =>
          __impCap = _input__.readInt64()
        case tag => _input__.skipField(tag)
      }
    }
    com.zz.ady.backstage.idl.QueryDspAppPlacementResult(
        id = __id,
        dspId = __dspId,
        dspAppId = __dspAppId,
        name = __name,
        placementType = __placementType,
        placementId = __placementId,
        effectiveTime = __effectiveTime,
        impCap = __impCap
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.zz.ady.backstage.idl.QueryDspAppPlacementResult] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.zz.ady.backstage.idl.QueryDspAppPlacementResult(
        id = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        dspId = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        dspAppId = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        name = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        placementType = com.zz.ady.backstage.idl.PlacementType.fromValue(__fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scalapb.descriptors.EnumValueDescriptor]).getOrElse(com.zz.ady.backstage.idl.PlacementType.UNKNOWN_PLACEMENT_TYPE.scalaValueDescriptor).number),
        placementId = __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        effectiveTime = __fieldsMap.get(scalaDescriptor.findFieldByNumber(7).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        impCap = __fieldsMap.get(scalaDescriptor.findFieldByNumber(8).get).map(_.as[_root_.scala.Long]).getOrElse(0L)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = DspProto.javaDescriptor.getMessageTypes.get(5)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = DspProto.scalaDescriptor.messages(5)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = {
    (__fieldNumber: @_root_.scala.unchecked) match {
      case 5 => com.zz.ady.backstage.idl.PlacementType
    }
  }
  lazy val defaultInstance = com.zz.ady.backstage.idl.QueryDspAppPlacementResult(
    id = 0,
    dspId = 0,
    dspAppId = 0,
    name = "",
    placementType = com.zz.ady.backstage.idl.PlacementType.UNKNOWN_PLACEMENT_TYPE,
    placementId = "",
    effectiveTime = "",
    impCap = 0L
  )
  implicit class QueryDspAppPlacementResultLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.backstage.idl.QueryDspAppPlacementResult]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.zz.ady.backstage.idl.QueryDspAppPlacementResult](_l) {
    def id: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.id)((c_, f_) => c_.copy(id = f_))
    def dspId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.dspId)((c_, f_) => c_.copy(dspId = f_))
    def dspAppId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.dspAppId)((c_, f_) => c_.copy(dspAppId = f_))
    def name: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.name)((c_, f_) => c_.copy(name = f_))
    def placementType: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.backstage.idl.PlacementType] = field(_.placementType)((c_, f_) => c_.copy(placementType = f_))
    def placementId: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.placementId)((c_, f_) => c_.copy(placementId = f_))
    def effectiveTime: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.effectiveTime)((c_, f_) => c_.copy(effectiveTime = f_))
    def impCap: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Long] = field(_.impCap)((c_, f_) => c_.copy(impCap = f_))
  }
  final val ID_FIELD_NUMBER = 1
  final val DSP_ID_FIELD_NUMBER = 2
  final val DSP_APP_ID_FIELD_NUMBER = 3
  final val NAME_FIELD_NUMBER = 4
  final val PLACEMENT_TYPE_FIELD_NUMBER = 5
  final val PLACEMENT_ID_FIELD_NUMBER = 6
  final val EFFECTIVE_TIME_FIELD_NUMBER = 7
  final val IMP_CAP_FIELD_NUMBER = 8
  def of(
    id: _root_.scala.Int,
    dspId: _root_.scala.Int,
    dspAppId: _root_.scala.Int,
    name: _root_.scala.Predef.String,
    placementType: com.zz.ady.backstage.idl.PlacementType,
    placementId: _root_.scala.Predef.String,
    effectiveTime: _root_.scala.Predef.String,
    impCap: _root_.scala.Long
  ): _root_.com.zz.ady.backstage.idl.QueryDspAppPlacementResult = _root_.com.zz.ady.backstage.idl.QueryDspAppPlacementResult(
    id,
    dspId,
    dspAppId,
    name,
    placementType,
    placementId,
    effectiveTime,
    impCap
  )
}