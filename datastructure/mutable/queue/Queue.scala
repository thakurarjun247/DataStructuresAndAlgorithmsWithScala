package datastructure.mutable.queue
class Queue[T] extends AbstractQueue[T] {
  private var front: Node = null
  private var rear: Node = null
  private case class Node(val key: T, var next: Node = null)
  override def dequeue() = {
    if (isEmpty) throw new NoSuchElementException("Queue is empty, can't dequeue")
    val returnValue = front.key
    front = front.next
    returnValue
  }
  override def enqueue(t: T) = {
    val newNode = Node(t)
    if (rear != null) rear.next = newNode
    rear = newNode
    if (front == null) front = rear
  }
  override def isEmpty = front == null
}
