ThisBuild / name := "simple"
ThisBuild / organization := "com.zz"
ThisBuild / scalaVersion := "2.13.2"

lazy val root = project
  .in(file("."))
  .settings(name := (name in ThisBuild).value)
  .settings(version := (version in ThisBuild).value)
  .settings(coverageSettings)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(UniversalPlugin)
  .aggregate(idl, dal, core, bench, test, simple)

lazy val idl = project
  .in(file("idl"))
  .settings(name := "simple-idl")
  .settings(version := (version in ThisBuild).value)
  .settings(scalacOptions ++= commonScalacOptions)
  .settings(Seq(jettyAlpnAgent, scalapbDeps))
  .enablePlugins(AkkaGrpcPlugin)
  .enablePlugins(JavaAgent)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(UniversalPlugin)
  .settings(depOverrides)

lazy val common = project
  .in(file("common"))
  .settings(name := "simple-common")
  .settings(version := (version in ThisBuild).value)
  .settings(scalacOptions ++= commonScalacOptions)
  .settings(Seq(jettyAlpnAgent, scalapbDeps))
  .enablePlugins(AkkaGrpcPlugin)
  .enablePlugins(JavaAgent)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(UniversalPlugin)
  .settings(commonD, depOverrides)

lazy val dal = project
  .in(file("dal"))
  .dependsOn(idl, common)
  .settings(name := "simple-dal")
  .settings(version := (version in ThisBuild).value)
  .settings(scalacOptions ++= commonScalacOptions)
  .settings(addKinkProjector)
  .enablePlugins(AkkaGrpcPlugin)
  .enablePlugins(JavaAgent)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(UniversalPlugin)
  .settings(dalD)
  .settings(depOverrides)

lazy val simple = project
  .in(file("simple"))
  .dependsOn(idl)
  .settings(name := "simple")
  .settings(version := (version in ThisBuild).value)
  .settings(scalacOptions ++= commonScalacOptions)
  .settings(addKinkProjector)
  .enablePlugins(AkkaGrpcPlugin)
  .enablePlugins(JavaAgent)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(UniversalPlugin)
  .settings(dalD, clusterD)
  .settings(depOverrides)

lazy val core = project
  .in(file("core"))
  .dependsOn(dal)
  .settings(name := "simple-core")
  .settings(scalacOptions ++= commonScalacOptions)
  .settings(addKinkProjector)
  .enablePlugins(AkkaGrpcPlugin)
  .enablePlugins(JavaAgent)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(UniversalPlugin, GraalVMNativeImagePlugin)
  .settings(coreD, clusterD)
  .settings(depOverrides)
  .settings(scalacOptions ++= commonScalacOptions)
  .settings(packagerSettings)

lazy val bench = project
  .in(file("bench"))
  .settings(name := "simple-bench")
  .settings(scalacOptions ++= commonScalacOptions)
  .settings(commonD, coreD, edgeD, depOverrides)
  .settings(addKinkProjector)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(UniversalPlugin)

lazy val test = project
  .in(file("test"))
  .settings(name := "simple-test")
  .dependsOn(core)

lazy val wartRemoverSettings = Seq(
  wartremoverWarnings ++= Warts.allBut(Wart.Equals)
)

val akkaV          = "2.6.5"
val akkaHttpV      = "10.1.12"
val akkaHttpJsonV  = "1.29.1"
val alpAkkaKafkaV  = "2.0.2"
val slickV         = "3.3.2"
val catsV          = "2.1.0"
val circeV         = "0.13.0"
val prometheusV    = "0.8.0"
val http4sV        = "0.21.2"
val doobieV        = "0.8.8"
val tsecV          = "0.2.0-M2"
val nettyV         = "4.1.38.Final"
val quillV         = "3.4.11-M1"
val pulsar4sV      = "2.4.3"
val monixV         = "3.1.0"
val zioV           = "1.0.0-RC18-2"
val zioCatsV       = "2.0.0.0-RC13"
val akkaDiscoveryV = "0.0.7"

lazy val jettyAlpnAgent   = javaAgents += "org.mortbay.jetty.alpn" % "jetty-alpn-agent" % "2.0.9" % "runtime;test"
lazy val scalapbDeps      = libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
lazy val addKinkProjector = addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3")

lazy val auditD = libraryDependencies ++= Seq(
  "com.sun.mail" % "javax.mail" % "1.5.5",
  "javax.mail"   % "mail"       % "1.4"
)

lazy val commonD = libraryDependencies ++= Seq(
  "com.typesafe.akka"          %% "akka-actor-typed"          % akkaV,
  "org.typelevel"              %% "cats-core"                 % catsV,
  "io.circe"                   %% "circe-core"                % circeV,
  "io.circe"                   %% "circe-generic"             % circeV,
  "io.circe"                   %% "circe-parser"              % circeV,
  "io.circe"                   %% "circe-generic-extras"      % circeV,
  "org.http4s"                 %% "http4s-blaze-server"       % http4sV,
  "org.http4s"                 %% "http4s-blaze-client"       % http4sV,
  "org.http4s"                 %% "http4s-circe"              % http4sV,
  "org.http4s"                 %% "http4s-dsl"                % http4sV,
  "org.http4s"                 %% "http4s-twirl"              % http4sV,
  "org.http4s"                 %% "http4s-prometheus-metrics" % http4sV,
  "io.prometheus"              % "simpleclient"               % prometheusV,
  "io.prometheus"              % "simpleclient_hotspot"       % prometheusV,
  "io.prometheus"              % "simpleclient_common"        % prometheusV,
  "org.tpolecat"               %% "doobie-core"               % doobieV,
  "org.tpolecat"               %% "doobie-hikari"             % doobieV,
  "org.tpolecat"               %% "doobie-postgres"           % doobieV,
  "ch.qos.logback"             % "logback-classic"            % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging"             % "3.9.2",
  "com.github.pureconfig"      %% "pureconfig"                % "0.12.1",
  "com.sun.mail"               % "javax.mail"                 % "1.5.5",
  "javax.mail"                 % "mail"                       % "1.4",
  "com.typesafe"               % "config"                     % "1.4.0"
)

lazy val dalD = libraryDependencies ++= Seq(
  "org.typelevel"              %% "cats-core"            % catsV,
  "io.circe"                   %% "circe-core"           % circeV,
  "io.circe"                   %% "circe-generic"        % circeV,
  "io.circe"                   %% "circe-parser"         % circeV,
  "io.circe"                   %% "circe-generic-extras" % circeV,
  "io.prometheus"              % "simpleclient"          % prometheusV,
  "io.prometheus"              % "simpleclient_hotspot"  % prometheusV,
  "io.prometheus"              % "simpleclient_common"   % prometheusV,
  "com.typesafe.slick"         %% "slick"                % slickV,
  "com.typesafe.slick"         %% "slick-hikaricp"       % slickV,
  "org.tpolecat"               %% "doobie-core"          % doobieV,
  "org.tpolecat"               %% "doobie-hikari"        % doobieV,
  "org.tpolecat"               %% "doobie-postgres"      % doobieV,
  "ch.qos.logback"             % "logback-classic"       % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging"        % "3.9.2",
  "com.github.pureconfig"      %% "pureconfig"           % "0.12.1"
)

lazy val coreD = libraryDependencies ++= Seq(
  "com.typesafe.akka"  %% "akka-slf4j"                % akkaV,
  "com.typesafe.akka"  %% "akka-actor"                % akkaV,
  "com.typesafe.akka"  %% "akka-stream"               % akkaV,
  "com.typesafe.akka"  %% "akka-actor-typed"          % akkaV,
  "com.typesafe.akka"  %% "akka-stream-typed"         % akkaV,
  "com.typesafe.akka"  %% "akka-http-core"            % akkaHttpV,
  "com.typesafe.akka"  %% "akka-http"                 % akkaHttpV,
  "com.typesafe.akka"  %% "akka-http2-support"        % akkaHttpV,
  "de.heikoseeberger"  %% "akka-http-circe"           % akkaHttpJsonV,
  "org.http4s"         %% "http4s-blaze-server"       % http4sV,
  "org.http4s"         %% "http4s-blaze-client"       % http4sV,
  "org.http4s"         %% "http4s-circe"              % http4sV,
  "org.http4s"         %% "http4s-dsl"                % http4sV,
  "org.http4s"         %% "http4s-twirl"              % http4sV,
  "org.http4s"         %% "http4s-prometheus-metrics" % http4sV,
  "org.http4s"         %% "http4s-async-http-client"  % http4sV,
  "io.github.jmcardon" %% "tsec-common"               % tsecV,
  "io.github.jmcardon" %% "tsec-password"             % tsecV,
  "io.github.jmcardon" %% "tsec-cipher-jca"           % tsecV,
  "io.github.jmcardon" %% "tsec-cipher-bouncy"        % tsecV,
  "io.github.jmcardon" %% "tsec-mac"                  % tsecV,
  "io.github.jmcardon" %% "tsec-signatures"           % tsecV,
  "io.github.jmcardon" %% "tsec-hash-jca"             % tsecV,
  "io.github.jmcardon" %% "tsec-hash-bouncy"          % tsecV,
  "io.github.jmcardon" %% "tsec-jwt-mac"              % tsecV,
  "io.github.jmcardon" %% "tsec-jwt-sig"              % tsecV,
  "io.github.jmcardon" %% "tsec-http4s"               % tsecV,
  "io.monix"           %% "monix"                     % monixV,
  "io.monix"           %% "monix-catnap"              % monixV,
).map(
  _.excludeAll(
    ExclusionRule("org.log4j")
  ))

lazy val streamingD = libraryDependencies ++= Seq(
  "com.zz"             %% "simple-pulsar-client-core" % "0.0.1-M4",
  "com.typesafe.akka"  %% "akka-stream-kafka"         % alpAkkaKafkaV,
  "io.getquill"        %% "quill-cassandra"           % quillV,
  "com.lightbend.akka" %% "akka-stream-alpakka-csv"   % "1.1.2",
)

lazy val edgeD = libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream-kafka" % alpAkkaKafkaV,
  "dev.zio"           %% "zio-interop-cats"  % zioCatsV,
  //"io.getquill"       %% "quill-cassandra"           % quillV,
)

lazy val clusterD = libraryDependencies ++= List(
  "com.typesafe.akka" %% "akka-cluster"               % akkaV,
  "com.typesafe.akka" %% "akka-cluster-tools"         % akkaV,
  "com.typesafe.akka" %% "akka-cluster-metrics"       % akkaV,
  "com.typesafe.akka" %% "akka-cluster-typed"         % akkaV,
  "io.aeron"          % "aeron-driver"                % "1.25.1",
  "io.aeron"          % "aeron-client"                % "1.25.1",
  "com.ag"            %% "akka-node-discovery-consul" % akkaDiscoveryV,
  "com.twitter"       %% "chill-akka"                 % "0.9.5",
)

lazy val commonScalacOptions = Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-unchecked",
  "-Ywarn-dead-code",
  "-language:postfixOps",
  "-language:higherKinds",
  "-language:existentials"
)

lazy val coverageSettings = Seq(
  coverageEnabled := false,
  coverageFailOnMinimum := true,
  coverageMinimum := 80,
  coverageOutputCobertura := false,
  coverageOutputXML := false
)

addCommandAlias("validate", ";clean;protobuf:protobufGenerate;coverage;test;coverageReport")
addCommandAlias("package", ";core/universal:packageZipTarball")
addCommandAlias("stage", ";core/stage")
addCommandAlias("build", ";validate;coverageOff;package")
addCommandAlias("run", ";core/run")
addCommandAlias("pkg", ";core/universal:packageZipTarball")

ThisBuild / publishTo := Some("Artifactory Realm" at "https://repo1.iadmob.com/artifactory/libs-release")
ThisBuild / credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

ThisBuild / sources in doc in Compile := List()
ThisBuild / publishArtifact in packageDoc := false
ThisBuild / publishArtifact in packageSrc := true

lazy val depOverrides = dependencyOverrides ++= Seq(
  "com.typesafe.akka" %% "akka-slf4j"           % akkaV,
  "com.typesafe.akka" %% "akka-actor"           % akkaV,
  "com.typesafe.akka" %% "akka-stream"          % akkaV,
  "com.typesafe.akka" %% "akka-cluster"         % akkaV,
  "com.typesafe.akka" %% "akka-cluster-tools"   % akkaV,
  "com.typesafe.akka" %% "akka-cluster-metrics" % akkaV,
  "com.typesafe.akka" %% "akka-discovery"       % akkaV,
  "com.typesafe.akka" %% "akka-http-core"       % akkaHttpV,
  "com.typesafe.akka" %% "akka-http"            % akkaHttpV,
  "com.typesafe.akka" %% "akka-http2-support"   % akkaHttpV,
  "org.typelevel"     %% "cats-core"            % catsV,
  "org.typelevel"     %% "cats-free"            % catsV,
  "io.circe"          %% "circe-core"           % circeV,
  "io.circe"          %% "circe-generic"        % circeV,
  "io.circe"          %% "circe-parser"         % circeV,
  "io.circe"          %% "circe-generic-extras" % circeV
)

lazy val packagerSettings = Seq(mappings in Universal += baseDirectory.value / "deploy/app.sh" -> "app.sh") ++
  Option(System.getProperty("conf")).toList.map { conf =>
    mappings in Universal ++= {
      (baseDirectory.value / "deploy" / conf * "*").get.map { f =>
        f -> s"config/${f.name}"
      }
    }
  }
