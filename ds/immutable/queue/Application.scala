package ds.immutable.queue
/**
  * Creates an immutable queue and runs some assertions on it.
  */
object Application extends App {
  val q = Queue.empty[Int]
  val h = q.head
  val q1 = q.enQueue(5)
  val q2 = q1.enQueue(10)
  val q3 = q2.enQueue(15)
  val q3Head = q3.head
  val q4 = q3.deQueue()
  val q5 = q4.deQueue()
  val q6 = q5.deQueue()
  assert(h == None)
  assert(q3Head == Option(5))
  assert(q1.isEmpty == false)
}
