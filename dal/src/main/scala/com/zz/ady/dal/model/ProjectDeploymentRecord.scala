package com.zz.ady.dal.model

import java.time.Instant

final case class ProjectDeploymentRecord(
                                          id: Int
                                          , projectId: Int
                                          , status: Int
                                          , version: String
                                          , changeLog: String
                                          , developers: String
                                          , testers: String
                                          , deployedAt: Instant
                                          , totalTime: Int
                                          , note: String
                                          , createdBy: Int
                                          , updatedBy: Int
                                          , createdAt: Instant
                                          , updatedAt: Instant
                                          , isDeleted: Int
                                        )

object ProjectDeploymentRecord extends TableSchema {
  val table: String = "deployment"
}
