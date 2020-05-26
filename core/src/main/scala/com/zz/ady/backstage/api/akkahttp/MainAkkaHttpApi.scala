package com.zz.ady.backstage.api.akkahttp

import akka.http.scaladsl.server._
import akka.http.scaladsl.server.Directives._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
import io.circe.generic.auto._

import com.zz.ady.backstage.api.Pretty


object MainAkkaHttpApi {

  def apply(): MainAkkaHttpApi = new MainAkkaHttpApi

}

class MainAkkaHttpApi extends AkkaHttpApi with FailFastCirceSupport {

  override def routes: Route = rootR

  val rootR: Route = path("") {
    get {
      complete(Pretty("akka http works."))
    }
  }

}
