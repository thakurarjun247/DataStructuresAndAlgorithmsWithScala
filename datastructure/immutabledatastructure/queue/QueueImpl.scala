package datastructure.immutabledatastructure.queue
import scala.collection.mutable.DoubleLinkedList
/**
  * Doubly LinkedList based implementation of immutable queue,
  * implements all the methods.
  * Parameters are immutable, also the class itself is a case class
  *
  * @param list
  * @tparam T
  */
final case class QueueImpl[T](list: DoubleLinkedList[T]) extends Queue[T] {
  override final def isEmpty: Boolean = list.isEmpty
  override final def enQueue(item: T): Queue[T] = new QueueImpl[T](list :+ item)
  override final def deQueue(): Queue[T] = if (list.size == 0) throw new NoSuchElementException("Queue is empty, can't dequeue") else new QueueImpl[T](list.tail)
  override final def head: Option[T] = list.headOption
}
