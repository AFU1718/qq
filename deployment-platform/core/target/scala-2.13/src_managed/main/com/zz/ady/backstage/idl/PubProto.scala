// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.backstage.idl

object PubProto extends _root_.scalapb.GeneratedFileObject {
  lazy val dependencies: Seq[_root_.scalapb.GeneratedFileObject] = Seq(
    scalapb.options.ScalapbProto,
    com.google.protobuf.wrappers.WrappersProto,
    com.zz.ady.backstage.idl.EnumsProto
  )
  lazy val messagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] =
    Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]](
      com.zz.ady.backstage.idl.PubUpdateForm,
      com.zz.ady.backstage.idl.PubAppUpdateForm,
      com.zz.ady.backstage.idl.PubAppPlacementUpdateForm,
      com.zz.ady.backstage.idl.QueryPubResult,
      com.zz.ady.backstage.idl.QueryPubAppResult,
      com.zz.ady.backstage.idl.QueryPubAppPlacementResult,
      com.zz.ady.backstage.idl.QueryPubListResponse,
      com.zz.ady.backstage.idl.QueryPubListResult,
      com.zz.ady.backstage.idl.QueryPubAppListResponse,
      com.zz.ady.backstage.idl.QueryPubAppListResult,
      com.zz.ady.backstage.idl.QueryPubAppPlacementListResponse,
      com.zz.ady.backstage.idl.QueryPubAppPlacementListResult,
      com.zz.ady.backstage.idl.QueryPubListForm,
      com.zz.ady.backstage.idl.QueryPubAppListForm,
      com.zz.ady.backstage.idl.QueryPubAppPlacementListForm
    )
  private lazy val ProtoBytes: Array[Byte] =
      scalapb.Encoding.fromBase64(scala.collection.immutable.Seq(
  """CglwdWIucHJvdG8SGGNvbS56ei5hZHkuYmFja3N0YWdlLmlkbBoVc2NhbGFwYi9zY2FsYXBiLnByb3RvGh5nb29nbGUvcHJvd
  G9idWYvd3JhcHBlcnMucHJvdG8aC2VudW1zLnByb3RvItEBCg1QdWJVcGRhdGVGb3JtEh0KBG5hbWUYASABKAlCCeI/BhIEbmFtZ
  VIEbmFtZRJaCgxhY2NvdW50X3R5cGUYAiABKA4yJS5jb20uenouYWR5LmJhY2tzdGFnZS5pZGwuQWNjb3VudFR5cGVCEOI/DRILY
  WNjb3VudFR5cGVSC2FjY291bnRUeXBlEkUKBnN0YXR1cxgDIAEoDjIgLmNvbS56ei5hZHkuYmFja3N0YWdlLmlkbC5TdGF0dXNCC
  +I/CBIGc3RhdHVzUgZzdGF0dXMivQEKEFB1YkFwcFVwZGF0ZUZvcm0SIQoGcHViX2lkGAEgASgFQgriPwcSBXB1YklkUgVwdWJJZ
  BIdCgRuYW1lGAIgASgJQgniPwYSBG5hbWVSBG5hbWUSHQoEY29kZRgDIAEoCUIJ4j8GEgRjb2RlUgRjb2RlEkgKCWlzX3p6X2Fwa
  RgEIAEoDjIeLmNvbS56ei5hZHkuYmFja3N0YWdlLmlkbC5Cb29sQgziPwkSB2lzWnpBcGlSB2lzWnpBcGkivwMKGVB1YkFwcFBsY
  WNlbWVudFVwZGF0ZUZvcm0SIQoGcHViX2lkGAEgASgFQgriPwcSBXB1YklkUgVwdWJJZBIrCgpwdWJfYXBwX2lkGAIgASgFQg3iP
  woSCHB1YkFwcElkUghwdWJBcHBJZBIdCgRuYW1lGAMgASgJQgniPwYSBG5hbWVSBG5hbWUSYgoOcGxhY2VtZW50X3R5cGUYBCABK
  A4yJy5jb20uenouYWR5LmJhY2tzdGFnZS5pZGwuUGxhY2VtZW50VHlwZUIS4j8PEg1wbGFjZW1lbnRUeXBlUg1wbGFjZW1lbnRUe
  XBlEjMKDHBsYWNlbWVudF9pZBgFIAEoBUIQ4j8NEgtwbGFjZW1lbnRJZFILcGxhY2VtZW50SWQSSgoIaW1wX3R5cGUYBiABKA4yI
  S5jb20uenouYWR5LmJhY2tzdGFnZS5pZGwuSW1wVHlwZUIM4j8JEgdpbXBUeXBlUgdpbXBUeXBlEk4KCXNwZWNfdHlwZRgHIAEoD
  jIiLmNvbS56ei5hZHkuYmFja3N0YWdlLmlkbC5TcGVjVHlwZUIN4j8KEghzcGVjVHlwZVIIc3BlY1R5cGUi6wEKDlF1ZXJ5UHViU
  mVzdWx0EhcKAmlkGAEgASgFQgfiPwQSAmlkUgJpZBIdCgRuYW1lGAIgASgJQgniPwYSBG5hbWVSBG5hbWUSWgoMYWNjb3VudF90e
  XBlGAMgASgOMiUuY29tLnp6LmFkeS5iYWNrc3RhZ2UuaWRsLkFjY291bnRUeXBlQhDiPw0SC2FjY291bnRUeXBlUgthY2NvdW50V
  HlwZRJFCgZzdGF0dXMYBCABKA4yIC5jb20uenouYWR5LmJhY2tzdGFnZS5pZGwuU3RhdHVzQgviPwgSBnN0YXR1c1IGc3RhdHVzI
  tcBChFRdWVyeVB1YkFwcFJlc3VsdBIXCgJpZBgBIAEoBUIH4j8EEgJpZFICaWQSIQoGcHViX2lkGAIgASgFQgriPwcSBXB1YklkU
  gVwdWJJZBIdCgRuYW1lGAMgASgJQgniPwYSBG5hbWVSBG5hbWUSHQoEY29kZRgEIAEoCUIJ4j8GEgRjb2RlUgRjb2RlEkgKCWlzX
  3p6X2FwaRgFIAEoDjIeLmNvbS56ei5hZHkuYmFja3N0YWdlLmlkbC5Cb29sQgziPwkSB2lzWnpBcGlSB2lzWnpBcGki2QMKGlF1Z
  XJ5UHViQXBwUGxhY2VtZW50UmVzdWx0EhcKAmlkGAEgASgFQgfiPwQSAmlkUgJpZBIhCgZwdWJfaWQYAiABKAVCCuI/BxIFcHViS
  WRSBXB1YklkEisKCnB1Yl9hcHBfaWQYAyABKAVCDeI/ChIIcHViQXBwSWRSCHB1YkFwcElkEh0KBG5hbWUYBCABKAlCCeI/BhIEb
  mFtZVIEbmFtZRJiCg5wbGFjZW1lbnRfdHlwZRgFIAEoDjInLmNvbS56ei5hZHkuYmFja3N0YWdlLmlkbC5QbGFjZW1lbnRUeXBlQ
  hLiPw8SDXBsYWNlbWVudFR5cGVSDXBsYWNlbWVudFR5cGUSMwoMcGxhY2VtZW50X2lkGAYgASgJQhDiPw0SC3BsYWNlbWVudElkU
  gtwbGFjZW1lbnRJZBJKCghpbXBfdHlwZRgHIAEoDjIhLmNvbS56ei5hZHkuYmFja3N0YWdlLmlkbC5JbXBUeXBlQgziPwkSB2ltc
  FR5cGVSB2ltcFR5cGUSTgoJc3BlY190eXBlGAggASgOMiIuY29tLnp6LmFkeS5iYWNrc3RhZ2UuaWRsLlNwZWNUeXBlQg3iPwoSC
  HNwZWNUeXBlUghzcGVjVHlwZSLyAQoUUXVlcnlQdWJMaXN0UmVzcG9uc2USIAoFaW5kZXgYASABKAVCCuI/BxIFaW5kZXhSBWluZ
  GV4EioKCXBhZ2Vfc2l6ZRgCIAEoBUIN4j8KEghwYWdlU2l6ZVIIcGFnZVNpemUSIAoFY291bnQYAyABKAVCCuI/BxIFY291bnRSB
  WNvdW50Eh0KBHNpemUYBCABKAVCCeI/BhIEc2l6ZVIEc2l6ZRJLCgRsaXN0GAUgAygLMiwuY29tLnp6LmFkeS5iYWNrc3RhZ2Uua
  WRsLlF1ZXJ5UHViTGlzdFJlc3VsdEIJ4j8GEgRsaXN0UgRsaXN0Iu8BChJRdWVyeVB1Ykxpc3RSZXN1bHQSFwoCaWQYASABKAVCB
  +I/BBICaWRSAmlkEh0KBG5hbWUYAiABKAlCCeI/BhIEbmFtZVIEbmFtZRJaCgxhY2NvdW50X3R5cGUYAyABKA4yJS5jb20uenouY
  WR5LmJhY2tzdGFnZS5pZGwuQWNjb3VudFR5cGVCEOI/DRILYWNjb3VudFR5cGVSC2FjY291bnRUeXBlEkUKBnN0YXR1cxgEIAEoD
  jIgLmNvbS56ei5hZHkuYmFja3N0YWdlLmlkbC5TdGF0dXNCC+I/CBIGc3RhdHVzUgZzdGF0dXMi+AEKF1F1ZXJ5UHViQXBwTGlzd
  FJlc3BvbnNlEiAKBWluZGV4GAEgASgFQgriPwcSBWluZGV4UgVpbmRleBIqCglwYWdlX3NpemUYAiABKAVCDeI/ChIIcGFnZVNpe
  mVSCHBhZ2VTaXplEiAKBWNvdW50GAMgASgFQgriPwcSBWNvdW50UgVjb3VudBIdCgRzaXplGAQgASgFQgniPwYSBHNpemVSBHNpe
  mUSTgoEbGlzdBgFIAMoCzIvLmNvbS56ei5hZHkuYmFja3N0YWdlLmlkbC5RdWVyeVB1YkFwcExpc3RSZXN1bHRCCeI/BhIEbGlzd
  FIEbGlzdCKoAgoVUXVlcnlQdWJBcHBMaXN0UmVzdWx0EhcKAmlkGAEgASgFQgfiPwQSAmlkUgJpZBIdCgRuYW1lGAIgASgJQgniP
  wYSBG5hbWVSBG5hbWUSJwoIcHViX25hbWUYAyABKAlCDOI/CRIHcHViTmFtZVIHcHViTmFtZRIdCgRjb2RlGAQgASgJQgniPwYSB
  GNvZGVSBGNvZGUSSAoJaXNfenpfYXBpGAUgASgOMh4uY29tLnp6LmFkeS5iYWNrc3RhZ2UuaWRsLkJvb2xCDOI/CRIHaXNaekFwa
  VIHaXNaekFwaRJFCgZzdGF0dXMYBiABKA4yIC5jb20uenouYWR5LmJhY2tzdGFnZS5pZGwuU3RhdHVzQgviPwgSBnN0YXR1c1IGc
  3RhdHVzIooCCiBRdWVyeVB1YkFwcFBsYWNlbWVudExpc3RSZXNwb25zZRIgCgVpbmRleBgBIAEoBUIK4j8HEgVpbmRleFIFaW5kZ
  XgSKgoJcGFnZV9zaXplGAIgASgFQg3iPwoSCHBhZ2VTaXplUghwYWdlU2l6ZRIgCgVjb3VudBgDIAEoBUIK4j8HEgVjb3VudFIFY
  291bnQSHQoEc2l6ZRgEIAEoBUIJ4j8GEgRzaXplUgRzaXplElcKBGxpc3QYBSADKAsyOC5jb20uenouYWR5LmJhY2tzdGFnZS5pZ
  GwuUXVlcnlQdWJBcHBQbGFjZW1lbnRMaXN0UmVzdWx0QgniPwYSBGxpc3RSBGxpc3QisAQKHlF1ZXJ5UHViQXBwUGxhY2VtZW50T
  GlzdFJlc3VsdBIXCgJpZBgBIAEoBUIH4j8EEgJpZFICaWQSMwoMcGxhY2VtZW50X2lkGAIgASgJQhDiPw0SC3BsYWNlbWVudElkU
  gtwbGFjZW1lbnRJZBIdCgRuYW1lGAMgASgJQgniPwYSBG5hbWVSBG5hbWUSYgoOcGxhY2VtZW50X3R5cGUYBCABKA4yJy5jb20ue
  nouYWR5LmJhY2tzdGFnZS5pZGwuUGxhY2VtZW50VHlwZUIS4j8PEg1wbGFjZW1lbnRUeXBlUg1wbGFjZW1lbnRUeXBlEjEKDHB1Y
  l9hcHBfbmFtZRgFIAEoCUIP4j8MEgpwdWJBcHBOYW1lUgpwdWJBcHBOYW1lEicKCHB1Yl9uYW1lGAYgASgJQgziPwkSB3B1Yk5hb
  WVSB3B1Yk5hbWUSSgoIaW1wX3R5cGUYByABKA4yIS5jb20uenouYWR5LmJhY2tzdGFnZS5pZGwuSW1wVHlwZUIM4j8JEgdpbXBUe
  XBlUgdpbXBUeXBlEk4KCXNwZWNfdHlwZRgIIAEoDjIiLmNvbS56ei5hZHkuYmFja3N0YWdlLmlkbC5TcGVjVHlwZUIN4j8KEghzc
  GVjVHlwZVIIc3BlY1R5cGUSRQoGc3RhdHVzGAkgASgOMiAuY29tLnp6LmFkeS5iYWNrc3RhZ2UuaWRsLlN0YXR1c0IL4j8IEgZzd
  GF0dXNSBnN0YXR1cyLrAgoQUXVlcnlQdWJMaXN0Rm9ybRI7CgRuYW1lGAEgASgLMhwuZ29vZ2xlLnByb3RvYnVmLlN0cmluZ1Zhb
  HVlQgniPwYSBG5hbWVSBG5hbWUSUAoMYWNjb3VudF90eXBlGAIgASgLMhsuZ29vZ2xlLnByb3RvYnVmLkludDMyVmFsdWVCEOI/D
  RILYWNjb3VudFR5cGVSC2FjY291bnRUeXBlEkAKBnN0YXR1cxgDIAEoCzIbLmdvb2dsZS5wcm90b2J1Zi5JbnQzMlZhbHVlQgviP
  wgSBnN0YXR1c1IGc3RhdHVzEj0KBWluZGV4GAQgASgLMhsuZ29vZ2xlLnByb3RvYnVmLkludDMyVmFsdWVCCuI/BxIFaW5kZXhSB
  WluZGV4EkcKCXBhZ2Vfc2l6ZRgFIAEoCzIbLmdvb2dsZS5wcm90b2J1Zi5JbnQzMlZhbHVlQg3iPwoSCHBhZ2VTaXplUghwYWdlU
  2l6ZSKjAwoTUXVlcnlQdWJBcHBMaXN0Rm9ybRI7CgRuYW1lGAEgASgLMhwuZ29vZ2xlLnByb3RvYnVmLlN0cmluZ1ZhbHVlQgniP
  wYSBG5hbWVSBG5hbWUSPgoGcHViX2lkGAIgASgLMhsuZ29vZ2xlLnByb3RvYnVmLkludDMyVmFsdWVCCuI/BxIFcHViSWRSBXB1Y
  klkEkAKBnN0YXR1cxgDIAEoCzIbLmdvb2dsZS5wcm90b2J1Zi5JbnQzMlZhbHVlQgviPwgSBnN0YXR1c1IGc3RhdHVzEkUKCWlzX
  3p6X2FwaRgEIAEoCzIbLmdvb2dsZS5wcm90b2J1Zi5JbnQzMlZhbHVlQgziPwkSB2lzWnpBcGlSB2lzWnpBcGkSPQoFaW5kZXgYB
  SABKAsyGy5nb29nbGUucHJvdG9idWYuSW50MzJWYWx1ZUIK4j8HEgVpbmRleFIFaW5kZXgSRwoJcGFnZV9zaXplGAYgASgLMhsuZ
  29vZ2xlLnByb3RvYnVmLkludDMyVmFsdWVCDeI/ChIIcGFnZVNpemVSCHBhZ2VTaXplItoEChxRdWVyeVB1YkFwcFBsYWNlbWVud
  Expc3RGb3JtElEKDHBsYWNlbWVudF9pZBgBIAEoCzIcLmdvb2dsZS5wcm90b2J1Zi5TdHJpbmdWYWx1ZUIQ4j8NEgtwbGFjZW1lb
  nRJZFILcGxhY2VtZW50SWQSOwoEbmFtZRgCIAEoCzIcLmdvb2dsZS5wcm90b2J1Zi5TdHJpbmdWYWx1ZUIJ4j8GEgRuYW1lUgRuY
  W1lElYKDnBsYWNlbWVudF90eXBlGAMgASgLMhsuZ29vZ2xlLnByb3RvYnVmLkludDMyVmFsdWVCEuI/DxINcGxhY2VtZW50VHlwZ
  VINcGxhY2VtZW50VHlwZRI+CgZwdWJfaWQYBCABKAsyGy5nb29nbGUucHJvdG9idWYuSW50MzJWYWx1ZUIK4j8HEgVwdWJJZFIFc
  HViSWQSSAoKcHViX2FwcF9pZBgFIAEoCzIbLmdvb2dsZS5wcm90b2J1Zi5JbnQzMlZhbHVlQg3iPwoSCHB1YkFwcElkUghwdWJBc
  HBJZBJACgZzdGF0dXMYBiABKAsyGy5nb29nbGUucHJvdG9idWYuSW50MzJWYWx1ZUIL4j8IEgZzdGF0dXNSBnN0YXR1cxI9CgVpb
  mRleBgHIAEoCzIbLmdvb2dsZS5wcm90b2J1Zi5JbnQzMlZhbHVlQgriPwcSBWluZGV4UgVpbmRleBJHCglwYWdlX3NpemUYCCABK
  AsyGy5nb29nbGUucHJvdG9idWYuSW50MzJWYWx1ZUIN4j8KEghwYWdlU2l6ZVIIcGFnZVNpemVCB0gB4j8CSABiBnByb3RvMw=="""
      ).mkString)
  lazy val scalaDescriptor: _root_.scalapb.descriptors.FileDescriptor = {
    val scalaProto = com.google.protobuf.descriptor.FileDescriptorProto.parseFrom(ProtoBytes)
    _root_.scalapb.descriptors.FileDescriptor.buildFrom(scalaProto, dependencies.map(_.scalaDescriptor))
  }
  lazy val javaDescriptor: com.google.protobuf.Descriptors.FileDescriptor = {
    val javaProto = com.google.protobuf.DescriptorProtos.FileDescriptorProto.parseFrom(ProtoBytes)
    com.google.protobuf.Descriptors.FileDescriptor.buildFrom(javaProto, Array(
      scalapb.options.ScalapbProto.javaDescriptor,
      com.google.protobuf.wrappers.WrappersProto.javaDescriptor,
      com.zz.ady.backstage.idl.EnumsProto.javaDescriptor
    ))
  }
  @deprecated("Use javaDescriptor instead. In a future version this will refer to scalaDescriptor.", "ScalaPB 0.5.47")
  def descriptor: com.google.protobuf.Descriptors.FileDescriptor = javaDescriptor
}