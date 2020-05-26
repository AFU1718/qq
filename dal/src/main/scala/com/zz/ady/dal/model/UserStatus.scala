package com.zz.ady.dal.model

sealed abstract class UserStatus(val value: Int, val name: String) extends SimpleEnum {
  type EnumType = UserStatus
  def companion: SimpleEnumCompanion[UserStatus] = UserStatus
}

object UserStatus extends SimpleEnumCompanion[UserStatus] {

  case object Default  extends UserStatus(0, "Default")
  case object Active   extends UserStatus(1, "Ok")
  case object InActive extends UserStatus(2, "InActive")

  val default: UserStatus = Default

  val values: Vector[UserStatus] = Vector(Default, Active, InActive)

}
