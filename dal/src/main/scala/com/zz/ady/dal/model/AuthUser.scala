package com.zz.ady.dal.model

import java.time._

final case class AuthUser(
    id: Long
  , createdAt: Instant
  , updatedAt: Instant
  , status: UserStatus
  , username: String
  , email: String
  , password: String
  , firstName: String
  , lastName: String
  , isStaff: Boolean
  , isSuperuser: Boolean
  , lastLoginAt: Instant
)

object AuthUser extends TableSchema {
  val table: String = "auth_user"
}

final case class AuthGroup(
    id: Long     // id
  , name: String // 组名
)

object AuthGroup extends TableSchema {
  val table: String = "auth_group"
}

final case class AuthUserGroups(
    id: Long
  , userId: Long
  , groupId: Long
)

object AuthUserGroups extends TableSchema {
  val table: String = "auth_user_groups"
}

final case class AuthPermission(
    id: Long     // id
  , name: String // 组名
  , contentTypeId: Int
  , codename: String
)

object AuthPermission extends TableSchema {
  val table: String = "auth_permission"
}

final case class AuthGroupPermissions(
    id: Long
  , groupId: Long
  , permissionId: Long
)

object AuthGroupPermissions extends TableSchema {
  val table: String = "auth_group_permissions"
}

final case class AuthUserPermissions(
    id: Long
  , userId: Long
  , permissionId: Int
)

object AuthUserPermissions extends TableSchema {
  val table: String = "auth_user_permissions"
}

final case class ContentType(
    id: Int
  , appLabel: String
  , model: String
)

object ContentType extends TableSchema {
  val table: String = "content_type"
}

final case class InviteCode(
    id: Long             // id
  , code: String         // 邀请码本身
  , isAvailable: Boolean // 是否可用
  , ownerId: Long        // 拥有者 id
  , userId: Long         // 使用者(用来注册者) id
  , createdAt: Long      // 创建时间
  , updatedAt: Long      // 更新时间
)

object InviteCode extends TableSchema {
  val table: String = "invite_code"
}

final case class AuthenticatedUser(
    authUser: AuthUser
  , groups: Vector[AuthGroup]
  , permissions: Vector[AuthPermission]
)
