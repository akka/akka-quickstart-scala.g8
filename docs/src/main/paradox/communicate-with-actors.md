Communicate with Actors
-----------------------

All communication with Actors is done through asynchronous message passing. This is what makes Actors reactive and message driven. An Actor doesn't do anything unless it's been told to do something, and we tell it to do something by sending the message. Sending a message asynchronously means that the sender does not stick around waiting for the message to be processed by the recipient actor. Instead, the Actor hands the message off by putting it on the recipient's mailbox and is then free to do something more important than waiting for the recipient to react on the message. The Actor's mailbox is essentially a
message queue and has ordering semantics, this guarantees that the ordering of multiple messages sent from the same Actor is preserved, while they can be interleaved with the messages sent by another actor.

You might be wondering what the Actor is doing when it is not processing messages, i.e. doing actual work? It is in a suspended state in which it does not consume any resources apart from memory.

You tell an Actor to do something by passing a message into the `!` (bang) method on the `ActorRef`. This method puts the message on the Actor's mailbox.

In the main class we send messages to the `Greeter` Actor:

@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #main-send-messages }

The `Greeter` Actor also sends a message to the `Printer` Actor:

@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #greeter-send-message }
