// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.backstage.idl

/** @param index
  *   当前页
  * @param pageSize
  *   每页条数
  * @param count
  *   总条数
  * @param size
  *   总页数
  * @param list
  *   列表
  */
@SerialVersionUID(0L)
final case class QueryDspAppListResponse(
    index: _root_.scala.Int = 0,
    pageSize: _root_.scala.Int = 0,
    count: _root_.scala.Int = 0,
    size: _root_.scala.Int = 0,
    list: _root_.scala.Seq[com.zz.ady.backstage.idl.QueryDspAppListResult] = _root_.scala.Seq.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[QueryDspAppListResponse] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = index
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(1, __value)
        }
      };
      
      {
        val __value = pageSize
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(2, __value)
        }
      };
      
      {
        val __value = count
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(3, __value)
        }
      };
      
      {
        val __value = size
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeInt32Size(4, __value)
        }
      };
      list.foreach { __item =>
        val __value = __item
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      }
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
        val __v = index
        if (__v != 0) {
          _output__.writeInt32(1, __v)
        }
      };
      {
        val __v = pageSize
        if (__v != 0) {
          _output__.writeInt32(2, __v)
        }
      };
      {
        val __v = count
        if (__v != 0) {
          _output__.writeInt32(3, __v)
        }
      };
      {
        val __v = size
        if (__v != 0) {
          _output__.writeInt32(4, __v)
        }
      };
      list.foreach { __v =>
        val __m = __v
        _output__.writeTag(5, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
    }
    def withIndex(__v: _root_.scala.Int): QueryDspAppListResponse = copy(index = __v)
    def withPageSize(__v: _root_.scala.Int): QueryDspAppListResponse = copy(pageSize = __v)
    def withCount(__v: _root_.scala.Int): QueryDspAppListResponse = copy(count = __v)
    def withSize(__v: _root_.scala.Int): QueryDspAppListResponse = copy(size = __v)
    def clearList = copy(list = _root_.scala.Seq.empty)
    def addList(__vs: com.zz.ady.backstage.idl.QueryDspAppListResult*): QueryDspAppListResponse = addAllList(__vs)
    def addAllList(__vs: Iterable[com.zz.ady.backstage.idl.QueryDspAppListResult]): QueryDspAppListResponse = copy(list = list ++ __vs)
    def withList(__v: _root_.scala.Seq[com.zz.ady.backstage.idl.QueryDspAppListResult]): QueryDspAppListResponse = copy(list = __v)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = index
          if (__t != 0) __t else null
        }
        case 2 => {
          val __t = pageSize
          if (__t != 0) __t else null
        }
        case 3 => {
          val __t = count
          if (__t != 0) __t else null
        }
        case 4 => {
          val __t = size
          if (__t != 0) __t else null
        }
        case 5 => list
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PInt(index)
        case 2 => _root_.scalapb.descriptors.PInt(pageSize)
        case 3 => _root_.scalapb.descriptors.PInt(count)
        case 4 => _root_.scalapb.descriptors.PInt(size)
        case 5 => _root_.scalapb.descriptors.PRepeated(list.iterator.map(_.toPMessage).toVector)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.zz.ady.backstage.idl.QueryDspAppListResponse
}

object QueryDspAppListResponse extends scalapb.GeneratedMessageCompanion[com.zz.ady.backstage.idl.QueryDspAppListResponse] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.zz.ady.backstage.idl.QueryDspAppListResponse] = this
  def merge(`_message__`: com.zz.ady.backstage.idl.QueryDspAppListResponse, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.zz.ady.backstage.idl.QueryDspAppListResponse = {
    var __index = `_message__`.index
    var __pageSize = `_message__`.pageSize
    var __count = `_message__`.count
    var __size = `_message__`.size
    val __list = (_root_.scala.collection.immutable.Vector.newBuilder[com.zz.ady.backstage.idl.QueryDspAppListResult] ++= `_message__`.list)
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 8 =>
          __index = _input__.readInt32()
        case 16 =>
          __pageSize = _input__.readInt32()
        case 24 =>
          __count = _input__.readInt32()
        case 32 =>
          __size = _input__.readInt32()
        case 42 =>
          __list += _root_.scalapb.LiteParser.readMessage(_input__, com.zz.ady.backstage.idl.QueryDspAppListResult.defaultInstance)
        case tag => _input__.skipField(tag)
      }
    }
    com.zz.ady.backstage.idl.QueryDspAppListResponse(
        index = __index,
        pageSize = __pageSize,
        count = __count,
        size = __size,
        list = __list.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.zz.ady.backstage.idl.QueryDspAppListResponse] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.zz.ady.backstage.idl.QueryDspAppListResponse(
        index = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        pageSize = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        count = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        size = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Int]).getOrElse(0),
        list = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).map(_.as[_root_.scala.Seq[com.zz.ady.backstage.idl.QueryDspAppListResult]]).getOrElse(_root_.scala.Seq.empty)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = DspProto.javaDescriptor.getMessageTypes.get(8)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = DspProto.scalaDescriptor.messages(8)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 5 => __out = com.zz.ady.backstage.idl.QueryDspAppListResult
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.zz.ady.backstage.idl.QueryDspAppListResponse(
    index = 0,
    pageSize = 0,
    count = 0,
    size = 0,
    list = _root_.scala.Seq.empty
  )
  implicit class QueryDspAppListResponseLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.zz.ady.backstage.idl.QueryDspAppListResponse]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.zz.ady.backstage.idl.QueryDspAppListResponse](_l) {
    def index: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.index)((c_, f_) => c_.copy(index = f_))
    def pageSize: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.pageSize)((c_, f_) => c_.copy(pageSize = f_))
    def count: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.count)((c_, f_) => c_.copy(count = f_))
    def size: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Int] = field(_.size)((c_, f_) => c_.copy(size = f_))
    def list: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[com.zz.ady.backstage.idl.QueryDspAppListResult]] = field(_.list)((c_, f_) => c_.copy(list = f_))
  }
  final val INDEX_FIELD_NUMBER = 1
  final val PAGE_SIZE_FIELD_NUMBER = 2
  final val COUNT_FIELD_NUMBER = 3
  final val SIZE_FIELD_NUMBER = 4
  final val LIST_FIELD_NUMBER = 5
  def of(
    index: _root_.scala.Int,
    pageSize: _root_.scala.Int,
    count: _root_.scala.Int,
    size: _root_.scala.Int,
    list: _root_.scala.Seq[com.zz.ady.backstage.idl.QueryDspAppListResult]
  ): _root_.com.zz.ady.backstage.idl.QueryDspAppListResponse = _root_.com.zz.ady.backstage.idl.QueryDspAppListResponse(
    index,
    pageSize,
    count,
    size,
    list
  )
}