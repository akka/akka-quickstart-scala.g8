# Akka Actors Quickstart with Scala
 
Akka is a toolkit and runtime for building highly concurrent, distributed, and fault-tolerant event-driven applications on the JVM. Akka can be used with both Java and Scala.
This guide introduces Akka Actors by describing the Scala version of the Hello World example. If you prefer to use Akka with Java, switch to the [Akka Quickstart with Java guide](https://developer.lightbend.com/guides/akka-quickstart-java/).

Actors are the unit of execution in Akka. The Actor model is an abstraction that makes it easier to write correct concurrent, parallel and distributed systems. 
The Hello World example illustrates Akka basics. Within 30 minutes, you should be able to download and run the example and use this guide to understand how the example is constructed. 
This will get your feet wet, and hopefully inspire you to dive deeper into the wonderful sea of Akka!

After trying this example the comprehensive [Getting Started Guide](http://doc.akka.io/docs/akka/2.6/scala/guide/introduction.html) is a good next step to continue learning more about Akka.

The [Akka Platform Guide](https://developer.lightbend.com/docs/akka-platform-guide/) discusses more Akka concepts and features and gives an overview of Akka as a toolkit.

## Downloading the example 

The Hello World example for Scala is a zipped project that includes a distribution of sbt (build tool). You can run it on Linux, MacOS, or Windows. The only prerequisite is Java 8.

Download and unzip the example:

1. Download the zip file from [Lightbend Tech Hub](https://developer.lightbend.com/start/?group=akka&project=akka-quickstart-scala) by clicking `CREATE A PROJECT FOR ME`. 
1. Extract the zip file to a convenient location: 
  - On Linux and OSX systems, open a terminal and use the command `unzip akka-quickstart-scala.zip`. Note: On OSX, if you unzip using Archiver, you also have to make the sbt files executable:
```
 $ chmod u+x ./sbt
 $ chmod u+x ./sbt-dist/bin/sbt
```
  - On Windows, use a tool such as File Explorer to extract the project. 

## Running the example

To run Hello World:

1. In a console, change directories to the top level of the unzipped project.
 
    For example, if you used the default project name, akka-quickstart-scala, and extracted the project to your root directory,
    from the root directory, enter: `cd akka-quickstart-scala`

1. Enter `./sbt` on OSX/Linux or `sbt.bat` on Windows to start sbt.
 
    sbt downloads project dependencies. The `>` prompt indicates sbt has started in interactive mode.

1. At the sbt prompt, enter `reStart`.
 
    sbt builds the project and runs Hello World

The output should look _something_ like this (scroll all the way to the right to see the Actor output):

```
[2019-10-09 09:55:23,390] [INFO ] [com.example.Greeter$] [AkkaQuickStart-akka.actor.default-dispatcher-5]
[akka://AkkaQuickStart/user/greeter] - Hello Charles!
[2019-10-09 09:55:23,392] [INFO ] [com.example.GreeterBot$] [AkkaQuickStart-akka.actor.default-dispatcher-3]
[akka://AkkaQuickStart/user/Charles] - Greeting 1 for Charles
[2019-10-09 09:55:23,392] [INFO ] [com.example.Greeter$] [AkkaQuickStart-akka.actor.default-dispatcher-5]
[akka://AkkaQuickStart/user/greeter] - Hello Charles!
[2019-10-09 09:55:23,392] [INFO ] [com.example.GreeterBot$] [AkkaQuickStart-akka.actor.default-dispatcher-3]
[akka://AkkaQuickStart/user/Charles] - Greeting 2 for Charles
[2019-10-09 09:55:23,392] [INFO ] [com.example.Greeter$] [AkkaQuickStart-akka.actor.default-dispatcher-5]
[akka://AkkaQuickStart/user/greeter] - Hello Charles!
[2019-10-09 09:55:23,392] [INFO ] [com.example.GreeterBot$] [AkkaQuickStart-akka.actor.default-dispatcher-3]
[akka://AkkaQuickStart/user/Charles] - Greeting 3 for Charles
```
   
Congratulations, you just ran your first Akka app. Now take a look at what happened under the covers. 

## What Hello World does

The example consists of three actors:

* Greet: Receives commands to `Greet` someone and responds with a `Greeted` to confirm the greeting has taken place
* GreeterBot: receives the reply from the Greeter and sends a number of additional greeting messages and collect the replies until a given max number of messages have been reached.
* GreeterMain: The guardian actor that bootstraps everything

## Benefits of using the Actor Model

The following characteristics of Akka allow you to solve difficult concurrency and scalability challenges in an intuitive way: 

* Event-driven model &#8212; Actors perform work in response to messages. Communication between Actors is asynchronous, allowing Actors to send messages and continue their own work without blocking to wait for a reply.
* Strong isolation principles &#8212; Unlike regular objects in Scala, an Actor does not have a public API in terms of methods that you can invoke. Instead, its public API is defined through messages that the actor handles. This prevents any sharing of state between Actors; the only way to observe another actor's state is by sending it a message asking for it.
* Location transparency &#8212; The system constructs Actors from a factory and returns references to the instances. Because location doesn't matter, Actor instances can start, stop, move, and restart to scale up and down as well as recover from unexpected failures. 
* Lightweight &#8212; Each instance consumes only a few hundred bytes, which realistically allows millions of concurrent Actors to exist in a single application.
 
Let's look at some best practices for working with Actors and messages in the context of the Hello World example.

@@@index

* [Define the Actors and messages](define-actors.md)
* [Create the Actors](create-actors.md)
* [Communicate with Actors](communicate-with-actors.md)
* [The Main Class](main-class.md)
* [Full Example](full-example.md)
* [Testing Actors](testing-actors.md)
* [Running the Application](running-the-application.md)
* [IntelliJ](intellij-idea.md)

@@@
