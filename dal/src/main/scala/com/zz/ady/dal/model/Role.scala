package com.zz.ady.dal.model

import java.time.Instant

final case class Role(
                       id: Int
                       , roleName: String
                       , note: String
                       , createdBy: Int
                       , updatedBy: Int
                       , createdAt: Instant
                       , updatedAt: Instant
                       , isDeleted: Int
                     )

object Role extends TableSchema {
  val table: String = "role"
}
