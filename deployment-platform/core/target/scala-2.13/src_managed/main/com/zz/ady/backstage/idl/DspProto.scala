// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.zz.ady.backstage.idl

object DspProto extends _root_.scalapb.GeneratedFileObject {
  lazy val dependencies: Seq[_root_.scalapb.GeneratedFileObject] = Seq(
    scalapb.options.ScalapbProto,
    com.google.protobuf.wrappers.WrappersProto,
    com.zz.ady.backstage.idl.EnumsProto
  )
  lazy val messagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] =
    Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]](
      com.zz.ady.backstage.idl.DspUpdateForm,
      com.zz.ady.backstage.idl.DspAppUpdateForm,
      com.zz.ady.backstage.idl.DspAppPlacementUpdateForm,
      com.zz.ady.backstage.idl.QueryDspResult,
      com.zz.ady.backstage.idl.QueryDspAppResult,
      com.zz.ady.backstage.idl.QueryDspAppPlacementResult,
      com.zz.ady.backstage.idl.QueryDspListResponse,
      com.zz.ady.backstage.idl.QueryDspListResult,
      com.zz.ady.backstage.idl.QueryDspAppListResponse,
      com.zz.ady.backstage.idl.QueryDspAppListResult,
      com.zz.ady.backstage.idl.QueryDspAppPlacementListResponse,
      com.zz.ady.backstage.idl.QueryDspAppPlacementListResult,
      com.zz.ady.backstage.idl.QueryDspListForm,
      com.zz.ady.backstage.idl.QueryDspAppListForm,
      com.zz.ady.backstage.idl.QueryDspAppPlacementListForm
    )
  private lazy val ProtoBytes: Array[Byte] =
      scalapb.Encoding.fromBase64(scala.collection.immutable.Seq(
  """Cglkc3AucHJvdG8SGGNvbS56ei5hZHkuYmFja3N0YWdlLmlkbBoVc2NhbGFwYi9zY2FsYXBiLnByb3RvGh5nb29nbGUvcHJvd
  G9idWYvd3JhcHBlcnMucHJvdG8aC2VudW1zLnByb3RvIpQBCg1Ec3BVcGRhdGVGb3JtEh0KBG5hbWUYASABKAlCCeI/BhIEbmFtZ
  VIEbmFtZRIdCgRjb2RlGAIgASgFQgniPwYSBGNvZGVSBGNvZGUSRQoGc3RhdHVzGAMgASgOMiAuY29tLnp6LmFkeS5iYWNrc3RhZ
  2UuaWRsLlN0YXR1c0IL4j8IEgZzdGF0dXNSBnN0YXR1cyKcAwoQRHNwQXBwVXBkYXRlRm9ybRIhCgZkc3BfaWQYASABKAVCCuI/B
  xIFZHNwSWRSBWRzcElkEh0KBG5hbWUYAiABKAlCCeI/BhIEbmFtZVIEbmFtZRJICglpc196el9hcGkYAyABKA4yHi5jb20uenouY
  WR5LmJhY2tzdGFnZS5pZGwuQm9vbEIM4j8JEgdpc1p6QXBpUgdpc1p6QXBpEhoKA3VybBgEIAEoCUII4j8FEgN1cmxSA3VybBIjC
  gZsb3dlc3QYBSABKAVCC+I/CBIGbG93ZXN0UgZsb3dlc3QSGgoDcGtnGAYgASgJQgjiPwUSA3BrZ1IDcGtnEjAKC3BrZ192ZXJza
  W9uGAcgASgJQg/iPwwSCnBrZ1ZlcnNpb25SCnBrZ1ZlcnNpb24SPQoQcGtnX3ZlcnNpb25fbmFtZRgIIAEoCUIT4j8QEg5wa2dWZ
  XJzaW9uTmFtZVIOcGtnVmVyc2lvbk5hbWUSLgoLZHNwX2FwcF9rZXkYCSABKAlCDuI/CxIJZHNwQXBwS2V5Uglkc3BBcHBLZXkih
  AMKGURzcEFwcFBsYWNlbWVudFVwZGF0ZUZvcm0SIQoGZHNwX2lkGAEgASgFQgriPwcSBWRzcElkUgVkc3BJZBIrCgpkc3BfYXBwX
  2lkGAIgASgFQg3iPwoSCGRzcEFwcElkUghkc3BBcHBJZBIdCgRuYW1lGAMgASgJQgniPwYSBG5hbWVSBG5hbWUSYgoOcGxhY2VtZ
  W50X3R5cGUYBCABKA4yJy5jb20uenouYWR5LmJhY2tzdGFnZS5pZGwuUGxhY2VtZW50VHlwZUIS4j8PEg1wbGFjZW1lbnRUeXBlU
  g1wbGFjZW1lbnRUeXBlEjMKDHBsYWNlbWVudF9pZBgFIAEoCUIQ4j8NEgtwbGFjZW1lbnRJZFILcGxhY2VtZW50SWQSOQoOZWZmZ
  WN0aXZlX3RpbWUYBiABKAlCEuI/DxINZWZmZWN0aXZlVGltZVINZWZmZWN0aXZlVGltZRIkCgdpbXBfY2FwGAcgASgDQgviPwgSB
  mltcENhcFIGaW1wQ2FwIq4BCg5RdWVyeURzcFJlc3VsdBIXCgJpZBgBIAEoBUIH4j8EEgJpZFICaWQSHQoEbmFtZRgCIAEoCUIJ4
  j8GEgRuYW1lUgRuYW1lEh0KBGNvZGUYAyABKAlCCeI/BhIEY29kZVIEY29kZRJFCgZzdGF0dXMYBCABKA4yIC5jb20uenouYWR5L
  mJhY2tzdGFnZS5pZGwuU3RhdHVzQgviPwgSBnN0YXR1c1IGc3RhdHVzIrYDChFRdWVyeURzcEFwcFJlc3VsdBIXCgJpZBgBIAEoB
  UIH4j8EEgJpZFICaWQSHQoEbmFtZRgCIAEoCUIJ4j8GEgRuYW1lUgRuYW1lEiEKBmRzcF9pZBgDIAEoBUIK4j8HEgVkc3BJZFIFZ
  HNwSWQSSAoJaXNfenpfYXBpGAQgASgOMh4uY29tLnp6LmFkeS5iYWNrc3RhZ2UuaWRsLkJvb2xCDOI/CRIHaXNaekFwaVIHaXNae
  kFwaRIaCgN1cmwYBSABKAlCCOI/BRIDdXJsUgN1cmwSIwoGbG93ZXN0GAYgASgFQgviPwgSBmxvd2VzdFIGbG93ZXN0EhoKA3BrZ
  xgHIAEoCUII4j8FEgNwa2dSA3BrZxIwCgtwa2dfdmVyc2lvbhgIIAEoCUIP4j8MEgpwa2dWZXJzaW9uUgpwa2dWZXJzaW9uEj0KE
  HBrZ192ZXJzaW9uX25hbWUYCSABKAlCE+I/EBIOcGtnVmVyc2lvbk5hbWVSDnBrZ1ZlcnNpb25OYW1lEi4KC2RzcF9hcHBfa2V5G
  AogASgJQg7iPwsSCWRzcEFwcEtleVIJZHNwQXBwS2V5Ip4DChpRdWVyeURzcEFwcFBsYWNlbWVudFJlc3VsdBIXCgJpZBgBIAEoB
  UIH4j8EEgJpZFICaWQSIQoGZHNwX2lkGAIgASgFQgriPwcSBWRzcElkUgVkc3BJZBIrCgpkc3BfYXBwX2lkGAMgASgFQg3iPwoSC
  GRzcEFwcElkUghkc3BBcHBJZBIdCgRuYW1lGAQgASgJQgniPwYSBG5hbWVSBG5hbWUSYgoOcGxhY2VtZW50X3R5cGUYBSABKA4yJ
  y5jb20uenouYWR5LmJhY2tzdGFnZS5pZGwuUGxhY2VtZW50VHlwZUIS4j8PEg1wbGFjZW1lbnRUeXBlUg1wbGFjZW1lbnRUeXBlE
  jMKDHBsYWNlbWVudF9pZBgGIAEoCUIQ4j8NEgtwbGFjZW1lbnRJZFILcGxhY2VtZW50SWQSOQoOZWZmZWN0aXZlX3RpbWUYByABK
  AlCEuI/DxINZWZmZWN0aXZlVGltZVINZWZmZWN0aXZlVGltZRIkCgdpbXBfY2FwGAggASgDQgviPwgSBmltcENhcFIGaW1wQ2FwI
  vIBChRRdWVyeURzcExpc3RSZXNwb25zZRIgCgVpbmRleBgBIAEoBUIK4j8HEgVpbmRleFIFaW5kZXgSKgoJcGFnZV9zaXplGAIgA
  SgFQg3iPwoSCHBhZ2VTaXplUghwYWdlU2l6ZRIgCgVjb3VudBgDIAEoBUIK4j8HEgVjb3VudFIFY291bnQSHQoEc2l6ZRgEIAEoB
  UIJ4j8GEgRzaXplUgRzaXplEksKBGxpc3QYBSADKAsyLC5jb20uenouYWR5LmJhY2tzdGFnZS5pZGwuUXVlcnlEc3BMaXN0UmVzd
  Wx0QgniPwYSBGxpc3RSBGxpc3QisgEKElF1ZXJ5RHNwTGlzdFJlc3VsdBIXCgJpZBgBIAEoBUIH4j8EEgJpZFICaWQSHQoEbmFtZ
  RgCIAEoCUIJ4j8GEgRuYW1lUgRuYW1lEh0KBGNvZGUYAyABKAlCCeI/BhIEY29kZVIEY29kZRJFCgZzdGF0dXMYBCABKA4yIC5jb
  20uenouYWR5LmJhY2tzdGFnZS5pZGwuU3RhdHVzQgviPwgSBnN0YXR1c1IGc3RhdHVzIvgBChdRdWVyeURzcEFwcExpc3RSZXNwb
  25zZRIgCgVpbmRleBgBIAEoBUIK4j8HEgVpbmRleFIFaW5kZXgSKgoJcGFnZV9zaXplGAIgASgFQg3iPwoSCHBhZ2VTaXplUghwY
  WdlU2l6ZRIgCgVjb3VudBgDIAEoBUIK4j8HEgVjb3VudFIFY291bnQSHQoEc2l6ZRgEIAEoBUIJ4j8GEgRzaXplUgRzaXplEk4KB
  Gxpc3QYBSADKAsyLy5jb20uenouYWR5LmJhY2tzdGFnZS5pZGwuUXVlcnlEc3BBcHBMaXN0UmVzdWx0QgniPwYSBGxpc3RSBGxpc
  3Qi5AEKFVF1ZXJ5RHNwQXBwTGlzdFJlc3VsdBIXCgJpZBgBIAEoBUIH4j8EEgJpZFICaWQSHQoEbmFtZRgCIAEoCUIJ4j8GEgRuY
  W1lUgRuYW1lEicKCGRzcF9uYW1lGAMgASgJQgziPwkSB2RzcE5hbWVSB2RzcE5hbWUSIwoGbG93ZXN0GAQgASgFQgviPwgSBmxvd
  2VzdFIGbG93ZXN0EkUKBnN0YXR1cxgFIAEoDjIgLmNvbS56ei5hZHkuYmFja3N0YWdlLmlkbC5TdGF0dXNCC+I/CBIGc3RhdHVzU
  gZzdGF0dXMiigIKIFF1ZXJ5RHNwQXBwUGxhY2VtZW50TGlzdFJlc3BvbnNlEiAKBWluZGV4GAEgASgFQgriPwcSBWluZGV4UgVpb
  mRleBIqCglwYWdlX3NpemUYAiABKAVCDeI/ChIIcGFnZVNpemVSCHBhZ2VTaXplEiAKBWNvdW50GAMgASgFQgriPwcSBWNvdW50U
  gVjb3VudBIdCgRzaXplGAQgASgFQgniPwYSBHNpemVSBHNpemUSVwoEbGlzdBgFIAMoCzI4LmNvbS56ei5hZHkuYmFja3N0YWdlL
  mlkbC5RdWVyeURzcEFwcFBsYWNlbWVudExpc3RSZXN1bHRCCeI/BhIEbGlzdFIEbGlzdCKUAwoeUXVlcnlEc3BBcHBQbGFjZW1lb
  nRMaXN0UmVzdWx0EhcKAmlkGAEgASgFQgfiPwQSAmlkUgJpZBIzCgxwbGFjZW1lbnRfaWQYAiABKAlCEOI/DRILcGxhY2VtZW50S
  WRSC3BsYWNlbWVudElkEh0KBG5hbWUYAyABKAlCCeI/BhIEbmFtZVIEbmFtZRJiCg5wbGFjZW1lbnRfdHlwZRgEIAEoDjInLmNvb
  S56ei5hZHkuYmFja3N0YWdlLmlkbC5QbGFjZW1lbnRUeXBlQhLiPw8SDXBsYWNlbWVudFR5cGVSDXBsYWNlbWVudFR5cGUSMQoMZ
  HNwX2FwcF9uYW1lGAUgASgJQg/iPwwSCmRzcEFwcE5hbWVSCmRzcEFwcE5hbWUSJwoIZHNwX25hbWUYBiABKAlCDOI/CRIHZHNwT
  mFtZVIHZHNwTmFtZRJFCgZzdGF0dXMYByABKA4yIC5jb20uenouYWR5LmJhY2tzdGFnZS5pZGwuU3RhdHVzQgviPwgSBnN0YXR1c
  1IGc3RhdHVzIpkCChBRdWVyeURzcExpc3RGb3JtEjsKBG5hbWUYASABKAsyHC5nb29nbGUucHJvdG9idWYuU3RyaW5nVmFsdWVCC
  eI/BhIEbmFtZVIEbmFtZRJACgZzdGF0dXMYAiABKAsyGy5nb29nbGUucHJvdG9idWYuSW50MzJWYWx1ZUIL4j8IEgZzdGF0dXNSB
  nN0YXR1cxI9CgVpbmRleBgDIAEoCzIbLmdvb2dsZS5wcm90b2J1Zi5JbnQzMlZhbHVlQgriPwcSBWluZGV4UgVpbmRleBJHCglwY
  WdlX3NpemUYBCABKAsyGy5nb29nbGUucHJvdG9idWYuSW50MzJWYWx1ZUIN4j8KEghwYWdlU2l6ZVIIcGFnZVNpemUiowMKE1F1Z
  XJ5RHNwQXBwTGlzdEZvcm0SPgoGZHNwX2lkGAEgASgLMhsuZ29vZ2xlLnByb3RvYnVmLkludDMyVmFsdWVCCuI/BxIFZHNwSWRSB
  WRzcElkEjsKBG5hbWUYAiABKAsyHC5nb29nbGUucHJvdG9idWYuU3RyaW5nVmFsdWVCCeI/BhIEbmFtZVIEbmFtZRJACgZzdGF0d
  XMYAyABKAsyGy5nb29nbGUucHJvdG9idWYuSW50MzJWYWx1ZUIL4j8IEgZzdGF0dXNSBnN0YXR1cxJFCglpc196el9hcGkYBCABK
  AsyGy5nb29nbGUucHJvdG9idWYuSW50MzJWYWx1ZUIM4j8JEgdpc1p6QXBpUgdpc1p6QXBpEj0KBWluZGV4GAUgASgLMhsuZ29vZ
  2xlLnByb3RvYnVmLkludDMyVmFsdWVCCuI/BxIFaW5kZXhSBWluZGV4EkcKCXBhZ2Vfc2l6ZRgGIAEoCzIbLmdvb2dsZS5wcm90b
  2J1Zi5JbnQzMlZhbHVlQg3iPwoSCHBhZ2VTaXplUghwYWdlU2l6ZSLaBAocUXVlcnlEc3BBcHBQbGFjZW1lbnRMaXN0Rm9ybRJRC
  gxwbGFjZW1lbnRfaWQYASABKAsyHC5nb29nbGUucHJvdG9idWYuU3RyaW5nVmFsdWVCEOI/DRILcGxhY2VtZW50SWRSC3BsYWNlb
  WVudElkEjsKBG5hbWUYAiABKAsyHC5nb29nbGUucHJvdG9idWYuU3RyaW5nVmFsdWVCCeI/BhIEbmFtZVIEbmFtZRJWCg5wbGFjZ
  W1lbnRfdHlwZRgDIAEoCzIbLmdvb2dsZS5wcm90b2J1Zi5JbnQzMlZhbHVlQhLiPw8SDXBsYWNlbWVudFR5cGVSDXBsYWNlbWVud
  FR5cGUSPgoGZHNwX2lkGAQgASgLMhsuZ29vZ2xlLnByb3RvYnVmLkludDMyVmFsdWVCCuI/BxIFZHNwSWRSBWRzcElkEkgKCmRzc
  F9hcHBfaWQYBSABKAsyGy5nb29nbGUucHJvdG9idWYuSW50MzJWYWx1ZUIN4j8KEghkc3BBcHBJZFIIZHNwQXBwSWQSQAoGc3Rhd
  HVzGAYgASgLMhsuZ29vZ2xlLnByb3RvYnVmLkludDMyVmFsdWVCC+I/CBIGc3RhdHVzUgZzdGF0dXMSPQoFaW5kZXgYByABKAsyG
  y5nb29nbGUucHJvdG9idWYuSW50MzJWYWx1ZUIK4j8HEgVpbmRleFIFaW5kZXgSRwoJcGFnZV9zaXplGAggASgLMhsuZ29vZ2xlL
  nByb3RvYnVmLkludDMyVmFsdWVCDeI/ChIIcGFnZVNpemVSCHBhZ2VTaXplQgdIAeI/AkgAYgZwcm90bzM="""
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