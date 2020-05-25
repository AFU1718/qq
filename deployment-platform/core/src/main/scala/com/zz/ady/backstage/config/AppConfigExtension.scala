package com.zz.ady.backstage.config

import akka.actor._
import com.typesafe.scalalogging.Logger
import com.zz.ady.common.json.SimpleJsonSupport
import io.circe.Printer
import io.circe.generic.auto._
import io.circe.syntax._

object AppConfigExtension extends ExtensionId[AppConfigExtension] with ExtensionIdProvider {

  override def lookup(): AppConfigExtension.type = AppConfigExtension

  override def createExtension(system: ExtendedActorSystem) = new AppConfigExtension(system)

  override def get(system: ActorSystem): AppConfigExtension = super.get(system)
}

class AppConfigExtension(system: ExtendedActorSystem) extends Extension with SimpleJsonSupport {

  private [this] val logger  = Logger(getClass)

  private [this] val printer = Printer.spaces2SortKeys

  val config: AppConfig = {
    val c = AppConfig.loadOrThrow()
    logger.info("app config:\n{}", printer.print(c.asJson))
    c
  }

}
