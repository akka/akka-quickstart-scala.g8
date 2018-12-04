## The Main class
 
The `Main` class in Hello World creates and controls the actors. Notice the use of an `ActorSystem` as a container and the `actorOf` method to create the Actors. Finally, the class creates the messages to send to the Actors.
 
@@snip [AkkaQuickstart.scala](/src/main/g8/src/main/scala/$package$/AkkaQuickstart.scala) { #main-class }
 
Similarly, let's look again at the full source code that defines the Actors and the Messages they accept.

