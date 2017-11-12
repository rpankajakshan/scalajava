import sbt._

object Aliases {

  val aliases = addCommandAlias("testCustomHeader", ";project customheader ;clean ;test") ++
    addCommandAlias("testTempFileService", ";project tempfileservice ;clean ;test") ++
    addCommandAlias("testCoreServer", ";project coreserver ;clean ;test")
}