## Asynchronous Communication

Actors are reactive and message driven. An Actor doesn't do anything until it receives a message. Actors communicate using asynchronous messages. This ensures that the sender does not stick around waiting for their message to be processed by the recipient. Instead, the sender puts the message in the recipient's mailbox and is free to do other work. The Actor's mailbox is essentially a message queue with ordering semantics. The order of multiple messages sent from the same Actor is preserved, but can be interleaved with messages sent by another Actor.
 
You might be wondering what the Actor is doing when it is not processing messages, i.e. doing actual work? It is in a suspended state in which it does not consume any resources apart from memory. Again, showing the lightweight, efficient nature of Actors. 

### Sending messages to an Actor

To put a message into an Actor's mailbox, use the `!` (bang) method on the `ActorRef`. For example, the main class of Hello World sends messages to the `Greeter` Actor like this:
 
@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #main-send-messages }
 
The `Greeter` Actor also sends a message to the `Printer` Actor:
 
@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #greeter-send-message }
 
We've looked at how to create actors and send messages. Now, let's review by looking at the `Main` class in its entirety. 