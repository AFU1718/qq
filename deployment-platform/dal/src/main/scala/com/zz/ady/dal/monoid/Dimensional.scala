package com.zz.ady.dal.monoid

trait Dimensional[A] {
  def dimension(a: A): A
}