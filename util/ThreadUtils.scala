package util

object ThreadUtils {
  trait ThreadUtils {
    //create thread, start it and return it
    def thread(body: => Unit): Thread = {
      val t = new Thread {
        override def run(): Unit = body
      }
      t.start();
      t
    }
    def log(message: String) =

      println(s"${Thread.currentThread().getName}: $message")

  }

}