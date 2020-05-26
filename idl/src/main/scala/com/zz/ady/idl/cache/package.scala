package com.zz.ady.idl

import java.time.Instant

import scalapb.TypeMapper

package object cache {
  implicit val mapper: TypeMapper[Long, Instant] = com.zz.ady.idl.mapper
}
