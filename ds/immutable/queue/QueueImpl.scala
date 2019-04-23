package ds.immutable.queue
import scala.reflect.ClassTag
class Node[T](key:T, next:Node[T])
//optimize use ArrayBuffer, append is O(1) for deleting use slice
//
class QueueImpl[T: ClassTag](array: Array[T]) extends Queue[T] {
  /*
    val front=list.head
    val rear=list.size-1*/
  val front:Option[Node[T]]= None
  val rear:Option[Node[T]]=None
  override def toString: String = array.toList.toString()
  override def isEmpty: Boolean = array.isEmpty
  // override def enQueue(t: T): Queue[T] = new QueueImpl[T](t::list)
  override def enQueue(item: T): Queue[T] = {
    //create a new array larger than this one to hold the new item
    val tempArray = Array.ofDim[T](array.length + 1)
    array.copyToArray(tempArray)
    //append this element to the rear of array
    tempArray(tempArray.length - 1) = item
    //create a new Queue with temp Array and return
    new QueueImpl[T](tempArray)
  }
  override def deQueue(): Queue[T] = if (array.size == 0) throw new NoSuchElementException("Queue is empty, can't dequeue") else new QueueImpl[T](array.tail)
  override def head: Option[T] = if(array.size==0) None else Some(array.head)

}
