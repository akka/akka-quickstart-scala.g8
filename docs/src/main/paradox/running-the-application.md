Running the Application
-----------------------

Before we run the application we have to first build it. Let's take a look at the build tool in action for this project: [sbt](http://www.scala-sbt.org). _If you prefer to run the application from an IDE instead of a Terminal window you should look at the @ref:[IntelliJ IDEA](intellij-idea.md) section._

### The Build Files

sbt uses a `build.sbt` file to handle the project. This project's `build.sbt` file looks like this:

@@snip [build.sbt]($g8root$/build.sbt)

This build file is very simple. In essence, it creates one project `hello-akka-scala` and declares the dependencies for this project. We must also declare what version of sbt to use and this is done in the file `project/build.properties`:

@@snip [build.properties]($g8root$/project/build.properties)

Now we are ready to build and run the project.

### Compiling the Project

We will use sbt to handle the compilation and run. We open a Terminal window and, from inside the project directory, type the following:

```
$ sbt
> compile
```

The above should render an output _similar_ to this one:

```
[info] Loading global plugins from /Users/x/.sbt/0.13/plugins
[info] Loading project definition from /Users/x/akka-quickstart-scala/project
[info] Updating {file:/Users/x/hello-akka-scala/project/}akka-quickstart-scala-build...
[info] Resolving org.fusesource.jansi#jansi;1.4 ...
[info] Done updating.
[info] Set current project to hello-akka-scala (in build file:/Users/x/akka-quickstart-scala/)
[info] Updating {file:/Users/x/hello-akka-scala/}akka-quickstart--scala...
[info] Resolving jline#jline;2.14.3 ...
[info] Done updating.
[info] Compiling 1 Scala source and 1 Java source to /Users/x/akka-quickstart-scala/target/scala-2.12/classes...
[success] Total time: 5 s, completed May 9, 2017 9:52:34 AM
```

### Running the Project

Now it is time to run the project. We will run it using `sbt` by issuing the following command in a Terminal window:

```
$ sbt
> run
```

The output should look _something_ like this (scroll all the way to the right to see the Actor output):

```
[info] Loading global plugins from /Users/x/.sbt/0.13/plugins
[info] Loading project definition from /Users/x/akka-quickstart-scala/project
[info] Set current project to hello-akka-scala (in build file:/Users/x/akka-quickstart-scala)
[info] Running com.lightbend.akka.sample.AkkaQuickstart
>>> Press ENTER to exit <<<
[INFO] [05/09/2017 09:57:15.979] [helloAkka-akka.actor.default-dispatcher-2] [akka://helloAkka/user/printerActor] Greeting received (from Actor[akka://helloAkka/user/howdyGreeter#-1854995773]): Howdy, Akka
[INFO] [05/09/2017 09:57:15.980] [helloAkka-akka.actor.default-dispatcher-2] [akka://helloAkka/user/printerActor] Greeting received (from Actor[akka://helloAkka/user/helloGreeter#-1072877049]): Hello, Scala
[INFO] [05/09/2017 09:57:15.980] [helloAkka-akka.actor.default-dispatcher-2] [akka://helloAkka/user/printerActor] Greeting received (from Actor[akka://helloAkka/user/goodDayGreeter#1972065097]): Good day, Play
[INFO] [05/09/2017 09:57:15.980] [helloAkka-akka.actor.default-dispatcher-2] [akka://helloAkka/user/printerActor] Greeting received (from Actor[akka://helloAkka/user/howdyGreeter#-1854995773]): Howdy, Lightbend
```

Remember that we set our `Printer` Actor to use the Logger from Akka? This is why there is a lot of extra information when we log things. The log output contains information like when and from what actor it was logged. Let's focus on the output from the `Printer` Actor for a while:

```
... Howdy, Akka
... Hello, Scala
... Good day, Play
... Howdy, Lightbend
```

This is the result of our code that sends messages to the `Greeter` Actor:

@@snip [AkkaQuickstart.scala]($g8src$/scala/com/lightbend/akka/sample/AkkaQuickstart.scala) { #main-send-messages }

Try running the code a couple of more times and make sure to notice the order of the logging. Does it remain the same or does it change? As you can see it changes sometimes when you run. What's happening here? For the sake of brevity, we will not explain this in detail. For now, it is enough to say that when you send messages to Actors this happens asynchronously and we have to design our program with this in mind. This is a new mindset but rest assured that it is not rocket science and once you get it everything will become clear; just like for <a href="https://en.wikipedia.org/wiki/Neo_(The_Matrix)">Neo in the Matrix</a>.

### The Next Step

This tutorial just scratches the surface of the functionality of Akka. The next natural step would be to continue with the [Getting Started Guide](http://doc.akka.io/docs/akka/2.5/scala.html) and the more detailed information about Akka and actor systems.  
