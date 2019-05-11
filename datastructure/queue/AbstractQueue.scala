package datastructure.queue
trait AbstractQueue[T] {
  def dequeue: T
  def enqueue(item: T): Unit
  def isEmpty: Boolean
}
