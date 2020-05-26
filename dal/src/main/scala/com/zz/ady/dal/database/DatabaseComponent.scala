package com.zz.ady.dal.database

import cats.effect._
import com.zaxxer.hikari.HikariConfig
import doobie.hikari.HikariTransactor
import doobie.util.ExecutionContexts

object DatabaseComponent {

  def transactorFromConfig[F[_]: Async: ContextShift](config: DbConfig): Resource[F, HikariTransactor[F]] = {
    val c = config
    val hc: HikariConfig = {
      val config = new HikariConfig

      config.setJdbcUrl(c.url)
      config.setUsername(c.properties.user)
      config.setPassword(c.properties.password)
      config.setMaximumPoolSize(c.maximumPoolSize)
      config.setConnectionTimeout(c.connectionTimeout)
      config
    }
    for {
      c1 <- ExecutionContexts.fixedThreadPool[F](size = c.numThreads)
      c2 <- ExecutionContexts.cachedThreadPool[F]
      xa <- HikariTransactor.fromHikariConfig(hikariConfig = hc, connectEC = c1, blocker = Blocker.liftExecutionContext(c2))
    } yield xa
  }

  def apply[F[_]: Async: ContextShift](config: DbConfigs): Resource[F, DatabaseComponent[F]] =
    for {
      xa <- transactorFromConfig(config.main)
      ro <- transactorFromConfig(config.ro)
      re <- transactorFromConfig(config.report)
      fl <- transactorFromConfig(config.file)
      //my <- transactorFromConfig(config.mysql)
    } yield DatabaseComponent(xa, ro, re, fl)//, my)
}

final case class DatabaseComponent[F[_]: Async: ContextShift](
    xa: HikariTransactor[F]
  , ro: HikariTransactor[F]
  , report: HikariTransactor[F]
  , fileMate: HikariTransactor[F]
  //, mysql: HikariTransactor[F]
)
