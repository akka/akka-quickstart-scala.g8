The Main Class
--------------

The main class is where we, in this example, create and control the actors. As previously explained we need an `ActorSystem` in which we can create the Actor instances. To create actors we use the `actorOf` method available in the `ActorSystem`. Once we have created the Actors the next thing we do is to send messages to them.

@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #main-class }

We will look and dissect the output when running this main class in the @ref:[Running the Application](running-the-application.md) section. Before we get there it is time to look at the complete source code of this sample application.
