package scalaprogramminglanguage.concurrency
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
object FutureDemo extends App {
  val fut: Future[Int] = Future {
    5
  }
  println(fut.isCompleted)
  fut onComplete {
    case scala.util.Success(value) => println(value.toString)
    case scala.util.Failure(exception) => println(exception.printStackTrace())
  }
  val one: Future[Int] = Future {
    1
  }
  val two: Future[Int] = Future {
    2
  }
  val sum = for {
    x <- one
    y <- two
  } yield x + y
  print("printing sum")
  print(sum.isCompleted)
  Thread.sleep(10)
  sum onComplete {
    case scala.util.Success(value) => println(value.toString)
    case scala.util.Failure(exception) => println(exception.printStackTrace())
  }
}
