// Version of Scala used by the project
// scalaVersion := "2.12.10"
name := "scala-travis-ci"
scalaVersion in ThisBuild := "2.12.11"
organization in ThisBuild := "it.parttimeteam.scalatravisci"

// Project version
version := "0.1.0"

// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

/*
 * START LIBRARY DEFINITIONS.
 */

// TESTS.
val scalatestV = "3.2.0"
val scalatest = "org.scalatest" %% "scalatest" % scalatestV % "test"
val scalactic = "org.scalactic" %% "scalactic" % scalatestV
val scalafx = "org.scalafx" %% "scalafx" % "14-R19"

// AKKA ACTORS.
val akkaV = "2.6.4"
val akkaTyped = "com.typesafe.akka"  %% "akka-actor-typed" % akkaV
val akkaTest = "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaV
val akkaSerialize = "com.typesafe.akka" %% "akka-serialization-jackson" % akkaV
val akkaRemote = "com.typesafe.akka" %% "akka-remote" % akkaV
val akkaCluster = "com.typesafe.akka" %% "akka-cluster-typed" % akkaV

lazy val akkaDependencies = Seq(
  akkaTyped,
  //  akkaCluster,
  akkaRemote,
  akkaSerialize,
  akkaTest % "test"
)

lazy val testDependencies = Seq(
  scalatest,
  scalactic
)
/*
 * END LIBRARY DEFINITIONS.
 */

/*
 * START PROJECT DEFINITIONS.
 */

// MODEL PROJECT.
lazy val model = (project in file("model")).settings(
  name := "model",
  settings,
  libraryDependencies ++= testDependencies
)

lazy val commons = (project in file("commons")).settings(
  name := "commons",
  settings,
  libraryDependencies += akkaTyped
).dependsOn(
  model
)

lazy val server = (project in file("server")).settings(
  name := "server",
  settings,
  mainClass := Some("it.parttimeteam.RandomProducer"),
  libraryDependencies ++= (akkaDependencies ++ testDependencies)
).dependsOn(
  model,
  commons
)

lazy val client = (project in file("client")).settings(
  name := "client",
  settings,
  mainClass := Some("it.parttimeteam.ConstantProducer"),
  libraryDependencies ++= (akkaDependencies ++ testDependencies),
  exportJars := true
).dependsOn(
  model,
  commons
)

/*
 * END PROJECT DEFINITIONS.
 */

/*
 * START PROJECT SETTINGS.
 */
lazy val compilerOptions = Seq(
  "-deprecation",
  "-encoding",
  "utf8"
)

lazy val commonSettings = Seq(
  scalacOptions ++= compilerOptions,
  resolvers ++= Seq(
    Resolver.sonatypeRepo("snapshots")
  )
)

lazy val settings = commonSettings
/*
 * END PROJECT SETTINGS.
 */

// Add dependency on ScalaFX library
libraryDependencies += scalafx

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true

coverageEnabled := true

// Add JavaFX dependencies
lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map( m=>
  "org.openjfx" % s"javafx-$m" % "14.0.1" classifier osName
)

// Removed Scala.JS plugin, we'll use ScalaFX instead.
// libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0"
// enablePlugins(ScalaJSPlugin)
// scalaJSUseMainModuleInitializer := true