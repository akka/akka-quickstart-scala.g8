## Creating the Actors
 
So far we have looked at the definitions of Actors and their messages. Now let's dive a bit deeper into the power of location transparency and see how to create Actor instances.
 
### The power of location transparency
 
In Akka you *can't* create an instance of an Actor using the `new` keyword. Instead, you create Actor instances using a factory. The factory does not return an actor instance, but a reference, `akka.actor.ActorRef`, that points to the actor instance. This level of indirection adds a lot of power and flexibility in a distributed system. 
 
_In Akka location doesn't matter_. Location transparency means that the `ActorRef` can, while retaining the same semantics, represent an instance of the running actor in-process or on a remote machine.  If needed, the runtime can optimize the system by changing an Actor's location or the entire application topology while it is running. This enables the "let it crash" model of failure management in which the system can heal itself by crashing faulty Actors and restarting healthy ones.
 
### The Akka ActorSystem
 
The `akka.actor.ActorSystem` factory is, to some extent, similar to Spring's `BeanFactory`. It acts as a container for Actors and manages their life-cycles. The `actorOf` factory method creates Actors and takes two parameters, a configuration object called `Props` and a name.
 
Actor and `ActorSystem` names are important in Akka. For example, you use them for lookups. _Using meaningful names consistent with your domain model makes it easier to reason about them down the road._
 
The previous topic reviewed the definition of Hello World Actors. Let's look at the code in the `AkkaQuickstart.scala` file that creates `Greeter` and `Printer` Actor instances:
 
@@snip [AkkaQuickstart.scala](/src/main/g8/src/main/scala/$package$/AkkaQuickstart.scala) { #create-actors }
 
Notice the following:

* The `actorOf` method on the `ActorSystem` creates the `Printer` Actor. As we discussed in the previous topic, this uses the `props` method of the `Printer` companion object to get the `Props` value. `ActorRef` provides the reference to newly created `Printer` Actor instances. 
* For `Greeter`, the code creates three Actor instances, each with a specific greeting message. 
 
Note: In this example, the `Greeter` Actors all use the same `Printer` instance, but we could have created multiple instances of the `Printer` Actor. The sample uses one to illustrate an important concept of message passing that we will cover later.
 
Next, let's look at how to communicate with actors.
