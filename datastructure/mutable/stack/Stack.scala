package datastructure.mutable.stack

class Stack[T] extends AbstractStack[T] {
  private case class Node(key: T, next: Node)
  private var top: Node = null
  override def isEmpty = top == null
  override def peek = top.key



  override def push(t: T) = {
    top = Node(t, top)
    //or
    /*val node = Node(t, top)
    top=node*/
  }

  override def pop() = {
    if(isEmpty) throw new NoSuchElementException("stack is empty, can't pop")
    val topKey = top.key
    top = top.next
    topKey
  }

}