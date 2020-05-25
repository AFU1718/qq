package com.zz.ady.dal.monoid

import cats.Monoid

trait StatsMonoid[A] extends Monoid[A] {

  // with dimensions but not metrics
  def zero(x: A): A

  def aggregateBy(xs: Seq[A])(f: A => A): Seq[A]

  def aggregateByMinute(x: Seq[A]): Seq[A]

  def aggregateByHour(x: Seq[A]): Seq[A]

  def aggregateByDay(x: Seq[A]): Seq[A]

}


