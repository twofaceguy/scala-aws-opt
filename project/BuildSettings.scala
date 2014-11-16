import sbt._
import Keys._
import org.sbtidea.SbtIdeaPlugin._




object BuildSettings {
  val VERSION = "0.0.1-SNAPSHOT"

  lazy val basicSettings = seq(
    version := NightlyBuildSupport.buildVersion(VERSION),
    homepage := Some(new URL("https://github.com/twofaceguy/scala-aws-opt")),
    organization := "com.github.twofaceguy",
    description := "demos for use aws by scala",
    startYear := Some(2014),
    licenses  := Seq("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt")),
    scalaVersion := "2.11.4",
    crossScalaVersions := Seq("2.11.4", "2.10.4"),
    resolvers ++= Dependencies.resolutionRepos,
    scalacOptions := Seq(
      "-encoding", "utf8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-target:jvm-1.6",
      "-language:_",
      "-Xlog-reflective-calls",
      "-language:reflectiveCalls",
      "-language:existentials"
    ),
    ideaExcludeFolders := ".idea" :: ".idea_modules" :: Nil
  )
 
  lazy val moduleSettings =
    basicSettings ++
      NightlyBuildSupport.settings ++
      seq(
        // scaladoc settings
        (scalacOptions in doc) <++= (name, version).map {
          (n, v) => Seq("-doc-title", n, "-doc-version", v)
        },
        // publishing
        crossPaths := false,
        publishMavenStyle := true,
         publishTo <<= version { (v: String) => 
            val nexus = "https://oss.sonatype.org/"
            if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
            else Some("releases" at nexus + "service/local/staging/deploy/maven2")
          }
      )

  lazy val noPublishing = seq(
    publish :=(),
    publishLocal :=()
  )

  def systemPropertyAsSeq(name: String): Seq[String] = {
    val prop = System.getProperty(name, "")
    if (prop.isEmpty) Seq.empty else prop.split(",").toSeq
  }

  lazy val docsSettings = basicSettings ++ noPublishing ++ seq(
    unmanagedSourceDirectories in Test <<= baseDirectory {
      _ ** "code" get
    }
  )

  lazy val exampleSettings = basicSettings ++ noPublishing
}