package util
import scala.concurrent.{Await, Future}
//same as
import scala.concurrent.ExecutionContext.Implicits.global
object ConcurrencyUtil {
  def debug(message: String): Unit = {
    val now = java.time.format.DateTimeFormatter.ISO_INSTANT
      .format(java.time.Instant.now)
      .substring(11, 23) // keep only time component
    val thread = Thread.currentThread.getName()
    println(s"$now [$thread] $message")
  }

  def createTask(n:Int):Future[Unit]=Future{
    debug(s"task $n starts.")
    Thread.sleep(2000)
    debug(s"task $n ends!")
  }

    def startBlockingTask(number: Int): Future[Unit] = Future {
      scala.concurrent.blocking {
        debug(s"Starting task#$number")
        Thread.sleep(2000) // wait 2secs
        debug(s"Finished task#$number")
      }
    }
}
