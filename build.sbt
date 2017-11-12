import BaseSettings._
import Dependencies._
import Testing._
import Versioning._
import sbt._

lazy val root = Project("scalajava", file("."))
  .aggregate(lang)
  .settings(baseSettings: _*)

lazy val lang = project.in(file("lang"))
  .settings(baseSettings: _*)
  .settings(versionSettings: _*)
  .settings(testSettings: _*)
  .settings(langDeps: _*)
