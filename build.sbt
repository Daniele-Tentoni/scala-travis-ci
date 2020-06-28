ThisBuild / scalaVersion := "2.12.10"

val scalactic = "org.scalactic" %% "scalactic" % "3.2.0"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello",
    libraryDependencies ++= Seq(
      scalactic
    )
  )

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % "test"

enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true

coverageEnabled := true
