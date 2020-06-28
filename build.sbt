// Version of Scala used by the project
scalaVersion := "2.12.10"

// Project version
version := "14-R19"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello"
  )

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "14-R19"
resolvers += Resolver.sonatypeRepo("snapshots")

// Test libraries.
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % "test"

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true

// Removed Scala.JS plugin, we'll use ScalaFX instead.
// libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0"
// enablePlugins(ScalaJSPlugin)
// scalaJSUseMainModuleInitializer := true

coverageEnabled := true

// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

// Add JavaFX dependencies
lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map( m=>
  "org.openjfx" % s"javafx-$m" % "14.0.1" classifier osName
)