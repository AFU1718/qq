package com.zz.ady.dal.model

import java.time.Instant

final case class UserInfo(
                           id: Int
                           , name: String
                           , password: String
                           , roleId: Int
                           , createdBy: Int
                           , updatedBy: Int
                           , createdAt: Instant
                           , updatedAt: Instant
                           , isDeleted: Int
                         )

object UserInfo extends TableSchema {
  val table: String = "user_info"
}
