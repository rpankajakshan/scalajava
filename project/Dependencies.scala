import sbt._
import Keys._

object Dependencies {

  val akkaVersion = "2.5.6"
  val akkaHttpVersion = "10.0.10"
  val mongoScalaDriverVersion = "2.1.0"
  val cucumberVersion = "1.2.5"
  val scalaConfigVersion = "1.3.1"
  val scalaLoggingVersion = "3.7.2"
  val logbackVersion = "1.2.3"
  val logstashLogbackVersion = "4.11"
  val activemqCamelVersion = "5.15.2"
  val camelVersion = "2.19.4"
  val s3ClientVersion = "1.11.214"
  val jclOverSlf4jVersion = "1.7.25"

  val loggingJars: Seq[ModuleID] =
    Seq(
      "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,
      "ch.qos.logback" % "logback-classic" % logbackVersion,
      "net.logstash.logback" % "logstash-logback-encoder" % logstashLogbackVersion,
      "org.slf4j" % "jcl-over-slf4j" % jclOverSlf4jVersion
    )

  val testingJars: Seq[ModuleID] =
    Seq(
      "org.scalatest" %% "scalatest" % "3.0.0",
      "org.scalamock" %% "scalamock-scalatest-support" % "3.5.0",
      "org.hamcrest" % "hamcrest-junit" % "2.0.0.0"
    )

  val langDeps: Seq[Setting[_]] = deps(
    Seq(
      "org.scala-lang" % "scala-library" % BaseSettings.projectScalaVersion,
      "com.typesafe" % "config" % scalaConfigVersion,

      "com.github.swagger-akka-http" %% "swagger-akka-http" % "0.9.1",

      "com.softwaremill.macwire" %% "macros" % "2.3.0",
      "com.softwaremill.macwire" %% "macrosakka" % "2.3.0",
      "com.softwaremill.macwire" %% "util" % "2.3.0",
      "com.softwaremill.macwire" %% "proxy" % "2.3.0"
    ) ++ loggingJars ++ testingJars
  )

  private def deps(modules: Seq[ModuleID]): Seq[Setting[_]] = Seq(libraryDependencies ++= modules)

}