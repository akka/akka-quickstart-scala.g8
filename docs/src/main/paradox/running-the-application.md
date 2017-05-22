## Running the application
 
You can run the Hello World application from the command line or an IDE. The final topic in this guide describes how to run it from @ref:[IntelliJ IDEA](intellij-idea.md). But, before we run the application again, let's take a quick look at the build tool: [sbt](http://www.scala-sbt.org). 
 
### The build files

sbt uses a `build.sbt` file to handle the project. This project's `build.sbt` file looks like this:
 
@@snip [build.sbt]($g8root$/build.sbt)
 
This build file is very simple. In essence, it creates one project `hello-akka-scala` and declares project dependencies. We must also declare what version of sbt to use and this is done in the file `project/build.properties`:
 
@@snip [build.properties]($g8root$/project/build.properties)
 
### Running the project

Just as you did earlier, run the application from a console:

1. Enter `./sbt` on OSX/Linux or `sbt-dist/bin/sbt.bat` on Windows 

   sbt downloads project dependencies. The `>` prompt indicates sbt has started in interactive mode.

1. At the sbt prompt, enter `run`. 
   
   The output should look _something_ like this (scroll all the way to the right to see the Actor output):
 
```
[info] Compiling 1 Scala source and 1 Java source to /Users/x/akka-quickstart-scala/target/scala-2.12/classes...
[info] Running com.lightbend.akka.sample.AkkaQuickstart
>>> Press ENTER to exit <<<
[INFO] [05/09/2017 09:57:15.979] [helloAkka-akka.actor.default-dispatcher-2] [akka://helloAkka/user/printerActor] Greeting received (from Actor[akka://helloAkka/user/howdyGreeter#-1854995773]): Howdy, Akka
[INFO] [05/09/2017 09:57:15.980] [helloAkka-akka.actor.default-dispatcher-2] [akka://helloAkka/user/printerActor] Greeting received (from Actor[akka://helloAkka/user/helloGreeter#-1072877049]): Hello, Scala
[INFO] [05/09/2017 09:57:15.980] [helloAkka-akka.actor.default-dispatcher-2] [akka://helloAkka/user/printerActor] Greeting received (from Actor[akka://helloAkka/user/goodDayGreeter#1972065097]): Good day, Play
[INFO] [05/09/2017 09:57:15.980] [helloAkka-akka.actor.default-dispatcher-2] [akka://helloAkka/user/printerActor] Greeting received (from Actor[akka://helloAkka/user/howdyGreeter#-1854995773]): Howdy, Lightbend
[success] Total time: 5 s, completed May 9, 2017 9:52:34 AM
```
 
Remember that the test implementation set the `Printer` Actor to use Akka logger? This provides a lot of extra information. For example, the log output contains includes the time and name of the Actor. Let's focus on the output from the `Printer` Actor for a while:
 
 ```
 ... Howdy, Akka
 ... Hello, Scala
 ... Good day, Play
 ... Howdy, Lightbend
 ```
 
This is the result of our code that sends messages to the `Greeter` Actor:
 
@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #main-send-messages }

To run the tests, enter `test` at the sbt prompt.
 
Try running the code a couple of more times and make sure to notice the order of the logging. Did you notice that it can change from one run to another. What's happening here? The asynchronous behavior becomes evident. This might be a new mental model for you. But, once you gain experience with it everything will become clear; just like for <a href="https://en.wikipedia.org/wiki/Neo_(The_Matrix)">Neo in the Matrix</a>.
 
### Next steps

If you use IntelliJ, try integrating the sample project with @ref:[IntelliJ IDEA](intellij-idea.md).

To continue learning more about Akka and Actor Systems, look at the [Getting Started Guide](http://doc.akka.io/docs/akka/2.5/scala.html) next. Happy hakking!
