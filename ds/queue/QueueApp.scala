package ds.queue

object QueueApp extends App{
  val q=new Queue[String]
  println(q.isEmpty)
  0 to 5 foreach(item=>{
    println("enqueuing "+item.toString)
    q.enqueue(item.toString)
  })
  println(q.isEmpty)
  println(q.dequeue)
  println(q.dequeue)
  println(q.dequeue)
  println(q.dequeue)
 //Thread.sleep(1000)
  /*0 to 5 foreach(item=>
    println("dequeuing "+q.dequeue)
  )*/
}
