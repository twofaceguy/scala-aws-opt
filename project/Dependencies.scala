import sbt._
import sbt.Keys._

object Dependencies {

  val resolutionRepos = Seq(
    "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/releases/",
    "Spray Repository" at "http://repo.spray.io/"
  )
  val akkaVersion = "2.3.3"

  def compile(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")

  def provided(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")

  def test(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")

  def runtime(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "runtime")

  def container(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "container")

  val scalaReflect = "org.scala-lang" % "scala-reflect" % "2.10.4"
  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
  val akkaKernel = "com.typesafe.akka" %% "akka-kernel" % akkaVersion
  val akkaTestKit = "com.typesafe.akka" %% "akka-testkit" % akkaVersion
  val akkaRemoteTest = "com.typesafe.akka" %% "akka-remote-tests" % akkaVersion
  val akkaRemote = "com.typesafe.akka" %% "akka-remote" % akkaVersion
  val shapeless = "com.chuusai" %% "shapeless"    % "1.2.4"
  val scalatest = "org.scalatest" %% "scalatest" % "2.2.0-RC1"
  val logback = "ch.qos.logback" % "logback-classic" % "1.1.2"

  val config = "com.typesafe" % "config" % "1.2.1"
  val nScalaTime = "com.github.nscala-time" %% "nscala-time" % "1.2.0"
  val scalaStm = "org.scala-stm" %% "scala-stm" % "0.7"
  val awsScala = "com.github.seratch" %% "awscala" % "0.4.1"

}
