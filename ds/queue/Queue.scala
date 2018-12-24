package ds.queue

class Queue[T] extends AbstractQueue[T] {

  private class Node(val key: T, var next: Node = null)

  private var front: Node = null
  private var rear: Node = null

  override def dequeue() = {
   // if (isEmpty) throw new NoSuchElementException("Queue is empty, can't dequeue")
    val returnValue = front.key
    front = front.next
    returnValue
  }

  override def enqueue(t: T) = {
    if (rear == null) {rear = new Node(t)
      front=rear}
    else rear.next = new Node(t)
   // if(front==null)
  }

  override def isEmpty = front == null
}
