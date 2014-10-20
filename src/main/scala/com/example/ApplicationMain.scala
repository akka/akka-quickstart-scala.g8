package com.example

import akka.actor.ActorSystem

object ApplicationMain extends App {
  val system = ActorSystem("MyActorSystem")
  val pingActor = system.actorOf(PingActor.props, "pingActor")
  pingActor ! PingActor.Initialize
  system.awaitTermination
}