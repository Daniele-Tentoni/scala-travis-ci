ThisBuild / scalaVersion := "2.12.10"

val scalactic = "org.scalactic" %% "scalactic" % "3.2.0"
val scalatest = "org.scalatest" %% "scalatest" % "3.2.0" % Test

lazy val hello = (project in file("."))
  .settings(
    name := "Hello",
    libraryDependencies ++= Seq(
      scalatest,
      scalactic
    )
  )

enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true

coverageEnabled := true
