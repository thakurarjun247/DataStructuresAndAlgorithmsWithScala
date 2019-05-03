package scalaprogramminglanguage.concurrency
import scalaprogramminglanguage.util.ConcurrencyUtil._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
object ThreadFutureECPart2 {
  def main(args: Array[String]): Unit = {
    debug("Starting Main")
    val tasks = (1 to 20).map(i => createTask(i))
    debug("Continuing Main")
    // waits for all tasks to complete before exiting
    Await.result(Future.sequence(tasks), Duration.Inf)
    //It took 10 second to complete 20 task of 2 sec each
    //20*2/10 =4
    //becuase we have 4 core processor so by default  4 thread created
    /*
    When the property scala.concurrent.context.maxThreads is not set it defaults
     to the number of available cores on the system.
     In my windows machine case it’s 4. It might be different on different machine.
     More importantly it means that it’s quite likely that the settings are going to be different
     between the developper environment and the production environment.
     Something worth to keep in mind in case of performance issues …
     For instance let’s set this property to 10 in the build.sbt:
    fork in run := true

    javaOptions += "-Dscala.concurrent.context.maxThreads=1"


    */
    //now lets use blocking keyword
    /*
    Now if we run our program again it starts all the tasks at once and completes
    in only 2s.
    That’s because the global execution context is “blocking” aware and starts extra
    threads for blocking computations.
    This setting is controlled by
    the property scala.concurrent.context.maxExtraThreads which defaults to 256.
    However it’s only useful for IO-bound tasks where the threads are left idle
    waiting for a resource to be available. It’s useless
    for CPU-bound task where the threads is kept busy.
    */
  }
}
