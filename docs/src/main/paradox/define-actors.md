## Defining Actors and messages      

Messages can be of arbitrary type (any subtype of `Any`). You can send boxed primitive values (such as `String`, `Integer`, `Boolean` etc.) as messages as well as plain data structures like arrays and collection types. Case classes and case objects make excellent messages since they are immutable and have support for pattern matching, something we will take advantage of in the Actor when matching on the messages it has received. 

Hello World Actors use three different messages:

* `WhoToGreet`: recipient of the greeting
* `Greet`: instruction to execute greeting
* `Greeting`: message containing the greeting

When defining Actors and their messages, keep these recommendations in mind:

* Since messages are the Actor's public API, _it is a good practice to define messages with good names and rich semantic and domain specific meaning_, even if they just wrap your data type. This will make it easier to use, understand and debug actor-based systems. 

* _Messages should be immutable_, since they are shared between different threads.

* _It is a good practice to put an actor's associated messages in its companion object_. This makes it easier to understand what type of messages the actor expects and handles. 

* _It is also a common pattern to use a `props` method in the companion object that describes how to construct the Actor._ 

Lets see how the companion objects and Actor implementations for `Greeter` and `Printer` demonstrate these best practices. 

### The Greeter Actor companion object

The following code snippet in the `AkkaQuickstart.scala` file for the companion object defines the messages handled by the `Greeter` Actor:
 
@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #greeter-messages }

The following snippet defines the `props` method.

@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #greeter-companion }
 
The `props` method creates and returns a `Props` instance. `Props` is a configuration class to specify options for the creation of actors, think of it as an immutable and thus freely shareable recipe for creating an actor that can include associated deployment information. This example simply passes the parameters that the Actor requires when being constructed. We will see the `props` method in action later in this tutorial.
 
#### The Greeter Actor implementation
 
The following snippet from the `AkkaQuickstart.scala` implements the `Greeter` Actor:  
 
@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #greeter-actor }
 
Let's break down the functionality:

* The `Greeter` class extends the `akka.actor.Actor` trait and implements the `receive` method. 
* The `Greeter` constructor accepts two parameters: `message: String`, which will be used when building greeting messages and `printerActor: ActorRef`, which is a reference to the Actor handling the outputting of the greeting.
* The `receive` method defines behavior; how the Actor should react to the different messages it receives. An Actor can have state. Accessing or mutating the internal state of an Actor is fully thread safe since it is protected by the Actor model. The `receive` method should handle the messages the actor expects. In the case of `Greeter`, it expects two types of messages: `WhoToGreet` and `Greet`. The former will update the `greeting` state of the Actor and the latter will trigger a sending of the `greeting` to the `Printer` Actor.
* The `greeting` variable contains the Actor's state and is set to `""` by default.
 
### Printer Actor companion object

Similar to 'Greeter', the companion object defines the messages handled by the `Printer` Actor:

@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #printer-messages }
  
And, the companion object of `Printer` defines a `props` method and the message that the Actor expects:
 
@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #printer-companion }
 
### Printer Actor implementation
 
The `Printer` implementation is very simple:

* It extends `akka.actor.ActorLogging` to automatically get a reference to a logger. By doing this we can write `log.info()` in the Actor without any additional importing or wiring.
* It just handles one type of message, `Greeting`, and logs the content of that message.  
 
@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #printer-actor }
