package scalaprogramminglanguage.concurrency
import scalaprogramminglanguage.concurrency.SynchronizedMethod.count
class Count(var count: Int = 0) {
  //note removing the synch keyword below will cause concurrency problems
  def increament = {
    synchronized {
      count += 1
    }
  }
}
class ThreadByExtendingThreadClass extends Thread() {
  override def run() = 1 to 1000 foreach (_ => count.increament)
}
//see https://www.youtube.com/watch?v=RH7G-N2pa8M
object SynchronizedMethod extends App {
  val count = new Count()
  val threadCreatedWithRunnable = new Thread(() => 1 to 1000 foreach (_ => count.increament))
  val threadByExtendingThreadClass = new ThreadByExtendingThreadClass()
  threadByExtendingThreadClass.start()
  threadCreatedWithRunnable.start()
  threadCreatedWithRunnable.join()
  threadByExtendingThreadClass.join()
  println(count.count)
}
