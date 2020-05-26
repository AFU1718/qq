package com.zz.ady.dal.model

import java.time.Instant

final case class Project(
                          id: Int
                          , projectGroupId: Int
                          , projectName: String
                          , projectType: String
                          , note: String
                          , createdBy: Int
                          , updatedBy: Int
                          , createdAt: Instant
                          , updatedAt: Instant
                          , isDeleted: Int
                        )

object Project extends TableSchema {
  val table: String = "project"
}
