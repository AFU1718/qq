package com.zz.ady.backstage

import java.time.Instant

import scalapb.TypeMapper

package object idl {

  implicit val mapper: TypeMapper[Long, Instant] = TypeMapper(Instant.ofEpochMilli)(_.toEpochMilli)

}
