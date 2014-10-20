name := "akka-scala-seed"

version := "1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.11" % "2.3.6",
  "com.typesafe.akka" % "akka-testkit_2.11" % "2.3.6" % "test",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test")
  