package datastructure.immutable.queue
trait Queue[T] {
  def isEmpty: Boolean
  def enQueue(t: T): Queue[T]
  def deQueue(): Queue[T]
  def head: Option[T]
}
object Queue {
  import scala.collection.mutable.DoubleLinkedList
  def empty[T]: Queue[T] = new QueueImpl[T](DoubleLinkedList[T]())
}
