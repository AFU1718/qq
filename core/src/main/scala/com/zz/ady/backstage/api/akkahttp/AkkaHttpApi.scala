package com.zz.ady.backstage.api.akkahttp

import akka.http.scaladsl.server.Route

trait AkkaHttpApi {

  def routes: Route

}
