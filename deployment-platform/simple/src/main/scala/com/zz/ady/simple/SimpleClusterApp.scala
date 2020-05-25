package com.zz.ady.simple

import java.time.Instant
import java.util.UUID

import scala.concurrent.duration._
import scala.util.control.NonFatal

import akka.actor.typed.{ActorRef, ActorSystem, Behavior, SpawnProtocol, SupervisorStrategy}
import akka.actor.typed.SpawnProtocol.Command
import akka.actor.typed.pubsub.Topic
import akka.actor.typed.scaladsl.Behaviors
import akka.cluster.typed.{ClusterSingleton, SingletonActor}
import akka.stream.{ActorAttributes, Supervision}
import akka.stream.scaladsl._
import cats.implicits._
import cats.effect.{ExitCode, IO, IOApp, Resource}
import com.ag.akka.discovery.consul.ConsulAkkaNodeDiscoverer
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import pureconfig.ConfigSource

object SimpleClusterApp extends IOApp {

  import scala.concurrent.ExecutionContext.Implicits.global

  val logger = Logger(getClass)

  val config: Config = ConfigFactory.load()

  val systemId: String                      = ConfigSource.default.at("akka.system.name").loadOrThrow[String]
  val selfUuid: String                      = UUID.randomUUID().toString
  implicit val system: ActorSystem[Command] = ActorSystem(SpawnProtocol(), systemId)

  def startAkkaCluster(): Option[ActorRef[_]] =
    ConfigSource.default
      .at("akka.cluster.seed-nodes")
      .load[Vector[String]] match {
      case Right(xs) if xs.nonEmpty => None
      case _                        => Option(ConsulAkkaNodeDiscoverer(selfUuid))
    }

  def clusterSingleton(): ActorRef[Unit] = {
    val singletonManager = ClusterSingleton(system)
    val proxy = singletonManager.init(
      SingletonActor(
        Behaviors
          .supervise(
            Behaviors.setup[Unit] { ctx =>
              val topicActor = ctx.spawn(Topic[String]("simple"), "SingletonActor")
              Source.fromIterator(() => Iterator.from(1, 1))
                .throttle(1, 1.seconds)
                //.tick(Duration.Zero, 1.seconds, ())
                .map(m => topicActor ! Topic.Publish(s"simple message: $m"))
                .to(Sink.ignore)
                .withAttributes(ActorAttributes.supervisionStrategy({
                  case NonFatal(e) =>
                    e.printStackTrace()
                    Supervision.Resume
                }))
                .run()
              Behaviors.empty
            }
          )
          .onFailure[Exception](SupervisorStrategy.restart),
        "PubSubCacheMasterSingletonActor"
      ))
    proxy
  }

  def subscriber(): Behavior[Unit] = {
    val b2 = Behaviors.setup[Unit] { ctx =>
      val topicActor = ctx.spawn(Topic[String]("simple"), "Actor")
      val s = ctx.spawn(Behaviors.receive[String] {
        case message =>
          logger.info("receive message: {}", message)
          Behaviors.same
      }, "receiver")
      topicActor ! Topic.Subscribe(s)
      Behaviors.ignore
    }
    b2
  }

//  def startClusterActor() = {
//    val b2 = Behaviors.setup[Unit] { ctx =>
//      val topicActor = ctx.spawn(Topic[String]("simple"), "Actor")
//      val s = ctx.spawn(Behaviors.receive[String] {
//        case message =>
//          logger.info("receive message: {}", message)
//          Behaviors.same
//      }, "receiver")
//      topicActor ! Topic.Subscribe(s)
//      Source
//        .tick(Duration.Zero, 1.seconds, ())
//        .map(_ => topicActor ! Topic.Publish(s"simple message, ts: ${Instant.now()}"))
//        .to(Sink.ignore)
//        .withAttributes(ActorAttributes.supervisionStrategy({
//          case NonFatal(e) =>
//            e.printStackTrace()
//            Supervision.Resume
//        }))
//        .run()
//      Behaviors.ignore
//    }
//
//    system.systemActorOf(b2, "simple")
//  }

  def run(args: List[String]): IO[ExitCode] = {
    startAkkaCluster()
    //startClusterActor()
    clusterSingleton()
    system.systemActorOf(subscriber(), "subscriberA")
    IO.never *> IO(ExitCode.Success)
  }

}
