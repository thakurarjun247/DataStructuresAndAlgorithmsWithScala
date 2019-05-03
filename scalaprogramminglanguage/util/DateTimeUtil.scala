package scalaprogramminglanguage.util
object DateTimeUtil {
  def timeIt[B](block: => B): Long = {
    val startTime = System.nanoTime()
    val result = block // call-by-name
    val endTime = System.nanoTime()
    val timeElaspsedNanos = endTime - startTime
    println("\nTime elaspsed to execute the code block: " + timeElaspsedNanos + " ns, " + timeElaspsedNanos.toString.length + " digits.")
    timeElaspsedNanos
  }
  /* def timeIt[B](block: => B, timeUnit:String): Long = {
     val timeElaspsedNanos=timeIt[B](block)
     timeUnit match {
       case "second" => timeElaspsedNanos/1000000000
       case "micro" => timeElaspsedNanos/1000
       case "nano" => timeElaspsedNanos
         //defaults to millis
       case _ => timeElaspsedNanos/1000000
     }

   }*/
}
