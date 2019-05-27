package scala.collection
import scala.collection.mutable
object Queue extends App {
  val q = mutable.Queue[Int]()
  q.size
  //add elements
  q += 1
  q.enqueue(333)
  //enqueue is internally  ++=
  q ++= List(2, 3)
  println(q)
  /** Returns the first element in the queue, and removes this element
    * from the queue.
    *
    * @throws java.util.NoSuchElementException
    * @return the first element of the queue.
    */
  val nullableItem: Int = q.dequeue()
  val firstWithSomeCondition: Option[Int] = q.dequeueFirst(x => x > 10)
}
