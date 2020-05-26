package com.zz.ady

import java.time.Instant
import java.util.UUID

import scalapb.TypeMapper

package object idl {
  implicit val mapper: TypeMapper[Long, Instant] = com.zz.idl.instantMapper
  implicit val uuidMapper: TypeMapper[String, UUID] = com.zz.idl.uuidMapper
}
