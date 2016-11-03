import sbt._

object Dependencies {
  lazy val akkaVersion = "2.4.12"
  lazy val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  lazy val akkaTestkit = "com.typesafe.akka" %% "akka-testkit" % akkaVersion
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.0"
}
