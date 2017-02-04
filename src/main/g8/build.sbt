import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.1"
    )),
    name := "$name$",
    libraryDependencies ++= Seq(akkaActor, akkaTestkit % Test, scalaTest % Test)
  )
