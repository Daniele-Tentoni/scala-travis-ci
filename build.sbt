ThisBuild / scalaVersion := "2.12.10"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello"
  )

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % "test"

// Removed Scala.JS plugin, we'll use ScalaFX instead.
// libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0"
// enablePlugins(ScalaJSPlugin)
// scalaJSUseMainModuleInitializer := true

coverageEnabled := true
