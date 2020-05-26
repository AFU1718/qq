package com.zz.ady.dal.model

sealed abstract class Status(val value: Int, val name: String) extends SimpleEnum {
  type EnumType = Status
  def companion: SimpleEnumCompanion[Status] = Status
}

object Status extends SimpleEnumCompanion[Status] {

  case object Default  extends Status(0, "Default")
  case object Active   extends Status(1, "Ok")
  case object InActive extends Status(2, "InActive")

  val default: Status = Default

  val values: Vector[Status] = Vector(Default, Active, InActive)

}
