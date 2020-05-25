package com.zz.ady.backstage.api

import com.zz.ady.common.json.SimpleJsonSupport
import org.http4s.circe.{CirceEntityDecoder, CirceEntityEncoder}

trait SimpleJsonApi[F[_]] extends EffectApi[F] with Api[F] with CirceEntityEncoder with CirceEntityDecoder with SimpleJsonSupport
