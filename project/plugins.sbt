
resolvers += "sbt-idea" at "http://mpeltonen.github.com/maven/"

libraryDependencies ++= Seq(
  "com.decodified" % "scala-ssh" % "0.6.2"
)


addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

