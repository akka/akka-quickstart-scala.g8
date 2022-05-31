## Testing Actors
 
The test in the Hello World example illustrates use of the [ScalaTest](http://www.scalatest.org/) framework. The test coverage is not complete. It simply shows how easy it is to test actor code and provides some basic concepts. You could add to it as an exercise to increase your own knowledge.  

### Test class definition

@@snip [AkkaQuickstartSpec.scala](/src/main/g8/src/test/scala/$package$/AkkaQuickstartSpec.scala) { #definition }

Support for ScalaTest is included by extending `ScalaTestWithActorTestKit`. For other test frameworks the testkit can be
used directly. See the [full documentation](https://doc.akka.io/docs/akka/2.6/typed/testing-async.html).

This manages the lifecycle of the `ActorTestKit` we'll use in the tests.

### Test methods

This test uses TestProbe to interrogate and verify the expected behavior. Let’s look at a source code snippet:

@@snip [AkkaQuickstartSpec.scala](/src/main/g8/src/test/scala/$package$/AkkaQuickstartSpec.scala) { #test }

Once we have a reference to TestProbe we pass it to `Greeter` as part of the `Greet` message. 
We then verify that the `Greeter` responds that the greeting has taken place.

### Full test code
 
And, here is the complete code:
 
@@snip [AkkaQuickstartSpec.scala](/src/main/g8/src/test/scala/$package$/AkkaQuickstartSpec.scala) { #full-example }
 
The example code just scratches the surface of the functionality available in `ActorTestKit`. A complete overview can be found [here](https://doc.akka.io/docs/akka/2.6/typed/testing-async.html).
 
