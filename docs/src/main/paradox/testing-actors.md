Testing Actors
--------------

We will use the [ScalaTest](http://www.scalatest.org/) framework to conduct the testing of our sample. The test coverage is not complete in this example. We leave that as an exercise for the interested reader. Instead, the test code is there to showcase how how easy it is to test actor code and also to provide some basic concepts.

### Test Class Definition

Let's start by looking at the test class definition:

@@snip [AkkaQuickstartSpec.scala]($g8srctest$/scala/com/lightbend/akka/sample/AkkaQuickstartSpec.scala) { #test-classes }

The test class extends `akka.test.TestKit` which is a module for integration testing of actors and actor systems. The showcased test class only uses a fraction of the functionality provided by [TestKit](http://doc.akka.io/docs/akka/2.5/scala/testing.html). The rest of the classes extended are from ScalaTest and the provide syntax and functionality that we use in our test cases. We will use `FlatSpecLike` with with we can write test specifications in the format of "X should Y", like this for example:

@@snip [AkkaQuickstartSpec.scala]($g8srctest$/scala/com/lightbend/akka/sample/AkkaQuickstartSpec.scala) { #specification-example }

### Test Methods

Now that we know some of the basic concepts it is time to look at the implemented test methods.

When working with Actors everything is asynchronous and as such we need to ensure that we can test this asynchronous behavior. This is where integration testing comes in handy. In this test we will create a so-called `TestProbe` that we can interrogate to verify the expected behavior. Once we have a reference to this `TestProbe` we pass it to `Greeter` as part of the constructor arguments. We thereafter send two messages to `Greeter`; one to set the greeting person to greet and another to trigger the sending of a `Greeting`. It is this sending that we then verify took place with the `expectMsg` method on the `TestProbe`. Let's look at the source code for this:

@@snip [AkkaQuickstartSpec.scala]($g8srctest$/scala/com/lightbend/akka/sample/AkkaQuickstartSpec.scala) { #first-test }

### Full Test Code

@@snip [AkkaQuickstartSpec.scala]($g8srctest$/scala/com/lightbend/akka/sample/AkkaQuickstartSpec.scala) { #full-example }

### Just the Surface

The above code is just scratching the surface of the available functionality in `TestKit`. A complete overview can be found [here](http://doc.akka.io/docs/akka/2.5/scala/testing.html).

Now that we are done writing all the code we should of course look at the output of it. The next section is all about running the code and it also analyzes the output thereof.
