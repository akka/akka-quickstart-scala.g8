## Running the application
 
You can run the Hello World application from the command line or an IDE. The final topic in this guide describes how to run it from @ref:[IntelliJ IDEA](intellij-idea.md). But, before we run the application again, let's take a quick look at the build tool: [sbt](http://www.scala-sbt.org). 
 
### The build files

sbt uses a `build.sbt` file to handle the project. This project's `build.sbt` file looks like this:
 
@@snip [build.sbt]($g8root$/build.sbt)
 
This build file is very simple. In essence, it creates one project `hello-akka-scala` and declares project dependencies. We must also declare what version of sbt to use and this is done in the file `project/build.properties`:
 
@@snip [build.properties]($g8root$/project/build.properties)
 
### Running the project

Just as you did earlier, run the application from a console:

1. Enter `./sbt` on OSX/Linux or `sbt.bat` on Windows 

   sbt downloads project dependencies. The `>` prompt indicates sbt has started in interactive mode.

1. At the sbt prompt, enter `reStart`.
   
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
 
Remember that the implementation set the `Greeter` Actor used the logger from the `ActorContext`? 
This provides a lot of extra information. For example, the log output contains includes the time and name of the object the behavior was defined. 
 
To run the tests, enter `test` at the sbt prompt.
 
### Next steps

If you use IntelliJ, try integrating the sample project with @ref:[IntelliJ IDEA](intellij-idea.md).

To continue learning more about Akka and Actor Systems, look at the [Getting Started Guide](http://doc.akka.io/docs/akka/current/scala/guide/introduction.html) next. Happy hakking!
