lazy val root = (project in file("."))
  .enablePlugins(JmhPlugin)
  .settings(
    name := "jmh-benchmark-example",
    version := "1.0",
    scalaVersion := "2.13.1",
  )
