package com.zz.ady.dal.model

import java.time.Instant

final case class ProjectGroup(
                               id: Int
                               , projectGroupName: String
                               , note: String
                               , createdBy: Int
                               , updatedBy: Int
                               , createdAt: Instant
                               , updatedAt: Instant
                               , isDeleted: Int
                             )

object ProjectGroup extends TableSchema {
  val table: String = "project_group"
}
