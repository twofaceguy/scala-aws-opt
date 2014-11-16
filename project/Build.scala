import sbt._
import Keys._

object Build extends Build {

  import BuildSettings._
  import Dependencies._

  // configure prompt to show current project
  override lazy val settings = super.settings :+ {
    shellPrompt := {
      s => Project.extract(s).currentProject.id + " > "
    }
  }

  // -------------------------------------------------------------------------------------------------------------------
  // Root Project
  // -------------------------------------------------------------------------------------------------------------------

  lazy val root = Project("scala-aws-opt", file("."))
    .aggregate(ec2)
    .settings(basicSettings: _*)
    .settings(noPublishing: _*)


  // -------------------------------------------------------------------------------------------------------------------
  // Modules
  // -------------------------------------------------------------------------------------------------------------------

  lazy val ec2 = Project("aws-ec2", file("aws-ec2"))
    .settings(moduleSettings: _*)
    .settings(libraryDependencies ++=
    compile(awsScala) ++
      test(scalatest) ++
      runtime(logback)
    )
}