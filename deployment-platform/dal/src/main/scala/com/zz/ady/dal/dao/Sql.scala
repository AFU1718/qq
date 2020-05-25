package com.zz.ady.dal.dao

//import doobie.util.Meta
//import scalapb._
//
//object Sql extends Sql
//
//trait Sql {
//
//  implicit def scalaPbEnumMapping[A <: GeneratedEnum : GeneratedEnumCompanion]: Meta[A] =
//    Meta[Short].imap(v => implicitly[GeneratedEnumCompanion[A]].fromValue(v.toInt))(_.value.toShort)
//
////  implicit def simpleEnumMapping[A <: SimpleEnum : SimpleEnumCompanion]: Meta[A] =
////    Meta[Int].imap(implicitly[SimpleEnumCompanion[A]].fromValue)(_.value)
//
//}
