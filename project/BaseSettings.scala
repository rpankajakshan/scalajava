import Aliases._
import sbt.Keys._
import sbt._

object BaseSettings {

  final val projectScalaVersion: String = "2.12.3"

  lazy val baseSettings =
    Seq(
      version := Option(System.getProperty("pixel.version")).getOrElse("3.1-SNAPSHOT"),
      organization := "uk.co.zentium",
      description := "",
      scalaVersion := projectScalaVersion,
      isSnapshot := false,
      javacOptions := Seq(
        "-Xlint:unchecked",
        "-Xlint:deprecation"
      ),
      scalacOptions := Seq(
        "-unchecked",
        "-deprecation",
        "-feature",
        "-encoding",
        "utf8",
        "-target:jvm-1.8",
        "-Xfuture",
        "-language:postfixOps",
        "-language:implicitConversions",
        "-language:reflectiveCalls",
        "-Ypartial-unification"
      ),
      crossPaths := false,
      publishTo := Some("Pixel Nexus" at "http://nexus.epg.bskyb.com/nexus/content/repositories/releases"),
      fork in run := true
    ) ++
      aliases
}
