ThisBuild / scalaVersion := "2.12.10"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % "test"

enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true
