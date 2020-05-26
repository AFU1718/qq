package com.zz.ady.backstage.api

import cats.effect.Effect
import com.zz.ady.backstage.database.DatabaseComponent

trait EffectApi[F[_]] {

  implicit def F: Effect[F]

}
