package com.zz.ady.dal.database

import pureconfig.{CamelCase, ConfigFieldMapping, ConfigSource}
import pureconfig.generic.ProductHint

final case class DbProperties(
    serverName: String
  , portNumber: Int
  , databaseName: String
  , user: String
  , password: String
)

final case class DbConfig(
    dataSourceClass: String
  , properties: DbProperties
  , maximumPoolSize: Int = 32
  , connectionTimeout: Int = 500
  , numThreads: Int = 8
) {
  val url: String =
    if (dataSourceClass.contains("PGSimpleDataSource"))
      s"jdbc:postgresql://${properties.serverName}:${properties.portNumber}/${properties.databaseName}"
    else
      s"jdbc:mysql://${properties.serverName}:${properties.portNumber}/${properties.databaseName}"
}

final case class DbConfigs(main: DbConfig, ro: DbConfig, report: DbConfig, file: DbConfig)//, mysql: DbConfig)

object DbConfig {
  import pureconfig.generic.auto._
  private[this] val mapping: ConfigFieldMapping     = ConfigFieldMapping(CamelCase, CamelCase)
  implicit val hintA: ProductHint[DbProperties]     = ProductHint[DbProperties](mapping)
  implicit val hintB: ProductHint[DbConfig]         = ProductHint[DbConfig](mapping)
  def loadOrThrowDbConfig(config: String): DbConfig = ConfigSource.default.at(config).loadOrThrow[DbConfig]
}

object DbConfigs {
  import pureconfig.generic.auto._
  import DbConfig._
  def loadOrThrowDbConfigs(config: String): DbConfigs = ConfigSource.default.at(config).loadOrThrow[DbConfigs]
}
