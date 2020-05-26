package com.zz

import java.util.UUID
import java.time.Instant

import scalapb.TypeMapper

package object idl {

  implicit val instantMapper: TypeMapper[Long, Instant] = TypeMapper(Instant.ofEpochMilli)(_.toEpochMilli)

  implicit val uuidMapper: TypeMapper[String, UUID] = TypeMapper(UUID.fromString)(_.toString)

}
