package scala.concurrency
import scala.util.ConcurrencyUtil.debug

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
object ThreadFutureECPart1 {
  def taskA = {
    debug("task A starts")
    Thread.sleep(1000)
    debug("task A ends")
  }
  def taskB = {
    debug("task B starts")
    Thread.sleep(2000)
    debug("task B ends")
  }
  def taskAFut = Future {
    taskA
  }
  def taskBFut = Future {
    taskB
  }
  def main(args: Array[String]): Unit = {
    println("href http://www.beyondthelines.net/computing/scala-future-and-execution-context/")
    debug("app start")
    taskA
    taskB
    debug("app end")
    /*
    Both tasks are executed sequentially on the same thread as the main program.
    The first tasks takes one second to complete and the second task takes 2.
    No doubt that we are wasting resources as the main thread should be able to
    continue execution while the tasks are executed. Also assuming no dependencies
    between the tasks we should be able to run them concurrently.
    */
    //lets wrap our tasks in Future to make then run concurrently
    debug("start main with Future")
    val futA = taskAFut
    val futB = taskBFut
    debug("end main with Future")
    //wait for Duration infinite
    Await.result(futA zip futB, Duration.Inf)
  }
}
