import sbt.Keys._

lazy val root = (project in file(".")).
  enablePlugins(JmhPlugin).
  settings(
    name := "benchmark-example",
    version := "1.0",
    scalaVersion := "2.13.1"
  )
