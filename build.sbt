name := "akka-scala-seed"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.9",
  "com.typesafe.akka" %% "akka-testkit" % "2.4.9" % "test",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test")
