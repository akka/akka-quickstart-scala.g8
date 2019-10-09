name := "akka-quickstart-scala"

version := "1.0"

scalaVersion := "2.12.8"

lazy val akkaVersion = "$akka_version$"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test,
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)
