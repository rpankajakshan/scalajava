import sbt.Keys._
import sbt._

object Testing {

  lazy val defaultTestSettings = Seq(
    fork in Test := true,
    parallelExecution in Test := false
  )

  lazy val testSettings = defaultTestSettings

}
