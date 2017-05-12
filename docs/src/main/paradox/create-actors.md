Create the Actors
-----------------

So far we have defined our Actors and its messages. Now let's create instances of the actors.

### The Power of Location Transparency

In Akka you *can't* create an instance of an Actor the regular way using `new`, instead, you create it using a factory. What is returned from this factory is not an instance of the Actor itself but an `akka.actor.ActorRef` pointing to the actor instance. This level of indirection adds a lot of power and flexibility. It enables for example location transparency
meaning that the `ActorRef` can, while retaining the same semantics, represent an instance of the running actor
in-process or on a remote machine. _In Akka location doesn't matter_. This also means that the runtime can if needed to
optimize the system by changing an Actor's location or the application's topology while it is running. Another
thing that this level of indirection enables is the "let it crash" model of failure management in which the
system can heal itself by crashing and restarting faulty Actors.

### The Akka ActorSystem

This factory used to create Actors in Akka is called an `akka.actor.ActorSystem` and is, to some extent, similar to Spring's `BeanFactory` in that it also acts as a container for your Actors, managing their life-cycles etc. We create an Actor through the `actorOf` factory method. This method takes a configuration object called `Props` and a name.
Actor (and ActorSystem) names are important in Akka, you use them for example when looking up Actors. One advice is to try to keep the names in accordance with your domain model as this makes things easier to reason about down the road.

In the previous section we defined two actors; `Greeter` and `Printer`. Let's go ahead and create instances of these:

@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #create-actors }

As you can see we start off by creating the `Printer` Actor using the `actorOf` method on the `ActorSystem`. Note that we are using the `props` method of the `Printer` companion object to get the `Props` value (as we discussed in the previous section).

Once we have a reference, i.e. `ActorRef`, to the `Printer` Actor we can create the `Greeter` actor instances. In this case, we create three Actor instances each with its specific greeting message. The `Greeter` Actors will all use the same `Printer` instance, but we could have created multiple instances of the `Printer` Actor if we would have wanted to. In this sample, we use one because we want to illustrate an important concept of message passing. More about this later.

Now that we have running instances of `Printer` and `Greeter` actors we will look at how to communicate with actors.
