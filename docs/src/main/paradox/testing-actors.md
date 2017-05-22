## Testing Actors
 
The tests in the Hello World example illustrates use of the [ScalaTest](http://www.scalatest.org/) framework. The test coverage is not complete. It simply shows how easy it is to test actor code and provides some basic concepts. You could add to it as an exercise to increase your own knowledge.  

### Test class definition
  
Let's start by looking at the test class definition in the `AkkaQuickstartSpec.scala` source file:
 
@@snip [AkkaQuickstartSpec.scala]($g8srctest$/scala/com/lightbend/akka/sample/AkkaQuickstartSpec.scala) { #test-classes }
 
The test class extends `akka.test.TestKit`, which is a module for integration testing of actors and actor systems. This class only uses a fraction of the functionality provided by [TestKit](http://doc.akka.io/docs/akka/2.5/scala/testing.html). The other extended classes are from `ScalaTest`. They provide syntax and functionality for the Hello World test cases. For example,  by extending `FlatSpecLike`, we can write test specifications in the format of "X should Y", like this for example:
 
@@snip [AkkaQuickstartSpec.scala]($g8srctest$/scala/com/lightbend/akka/sample/AkkaQuickstartSpec.scala) { #specification-example }
 
### Test methods

Now that we know some of the basic concepts, let's look at the implemented test methods.
 
Integration testing can help us ensure that Actors are behaving asynchronously. This first test uses `TestProbe` to interrogate and verify the expected behavior. Let's look at a source code snippet:
 
@@snip [AkkaQuickstartSpec.scala]($g8srctest$/scala/com/lightbend/akka/sample/AkkaQuickstartSpec.scala) { #first-test }
 
Once we have a reference to  `TestProbe` we pass it to `Greeter` as part of the constructor arguments. We thereafter send two messages to `Greeter`; one to set the greeting person to greet and another to trigger the sending of a `Greeting`. The `expectMsg` method on the `TestProbe` verifies whether the message got sent. 
 
### Full test code
 
And, here is the complete code:
 
@@snip [AkkaQuickstartSpec.scala]($g8srctest$/scala/com/lightbend/akka/sample/AkkaQuickstartSpec.scala) { #full-example }
 
The example code just scratches the surface of the functionality available in `TestKit`. A complete overview can be found [here](http://doc.akka.io/docs/akka/2.5/scala/testing.html).
 
Now that we've reviewed all of the code. Let's run the example again and look at its output.
