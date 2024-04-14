ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.0"

lazy val root = (project in file("."))
  .settings(
    name := "ipTest"
  )

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.1-RC1",
  "dev.zio" %% "zio-json" % "0.6.2",
  "dev.zio" %% "zio-http" % "3.0.0-RC6",
  "dev.zio" %% "zio-test" % "2.1-RC1" % Test,
  "dev.zio" %% "zio-test-sbt" % "2.1-RC1" % Test
)

assembly / mainClass := Some("Main")
assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}