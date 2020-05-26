package com.zz.ady.dal.monoid

import java.time.ZoneId

import com.zz.ady.idl.StatsA

object Implicits {

  implicit class StatsADimensionalOps[A](x: A)(implicit d: Dimensional[A]) {
    def dimension: A = d.dimension(x)
  }

  implicit val statsAMonoid: StatsAMonoid = new StatsAMonoid {}

  implicit class StatsAAggregator(xs: Seq[StatsA]) {
    def aggregateByMinute: Vector[StatsA] = statsAMonoid.aggregateByMinute(xs)

    def aggregateByHour: Vector[StatsA] = statsAMonoid.aggregateByHour(xs)

    def aggregateByDay: Vector[StatsA] = statsAMonoid.aggregateByDay(xs)

    def aggregated3: (Vector[StatsA], Vector[StatsA], Vector[StatsA]) = {
      val ms = statsAMonoid.aggregateByMinute(xs)
      val hs = statsAMonoid.aggregateByHour(ms)
      val ds = statsAMonoid.aggregateByDay(hs)
      (ms, hs, ds)
    }
  }

}
