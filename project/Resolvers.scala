import sbt._

object Resolvers {

  lazy val resolverSettings = Seq(
    "Sonatype Nexus Repository Manager" at "http://nexus.epg.bskyb.com/nexus/content/repositories/releases",
    "BSkyB Snapshot Repository" at "http://nexus.epg.bskyb.com/nexus/content/repositories/snapshots",
    "MilenKovicm Bitray Repository" at "https://dl.bintray.com/milenkovicm/maven/",
    "PJan Bitray Repository" at "http://dl.bintray.com/pjan/maven",
    "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  )
}
