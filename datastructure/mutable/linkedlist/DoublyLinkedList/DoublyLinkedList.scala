package datastructure.mutable.linkedlist.DoublyLinkedList
case class Node(val key: (String, String), var next: Node = null, var prev: Node = null) {
  override def toString: String = s"(${key._1}, ${key._2})"
}
class DoublyLinkedList {
  var head: Node = null
  var tail: Node = null
  def moveNodeToFront(node: Node) = {
    deleteNode(node)
    insertNodeAtHead(node)
  }
  override def toString = printLL("", head)
  def printLL(ans: String, head: Node): String = {
    if (head == null) ans
    else printLL(ans + head.toString + " <=> " /*s"(${head.key._1}, ${head.key._2}) <=> "*/ , head.next)
    //  println("start to end...")
    /* while (tempHead != null) {
       builder.append()
       tempHead = tempHead.next
     }
     builder.toString*/
    /*    println("end to start...")
        var tempTail = tail
        while (tempTail != null) {
          print(s"(${tempTail.key._1}, ${tempTail.key._2}) -> ")
          tempTail = tempTail.prev
        }*/
  }
  def deleteNode(node: Node): Unit = {
    if (node == null) throw new Exception("can't delete null node")
    if (node == tail) deleteTail
    else if (node == head) deleteHead
    else deleteMiddleNode(node)
  }
  def deleteTail: Unit = {
    if (tail != null) {
      if (tail.prev != null)
        tail.prev.next = null
      tail = tail.prev
    }
  }
  def deleteHead = {
    if (head != null) {
      head = head.next
      if (head != null) head.prev = null
    }
  }
  def deleteMiddleNode(node: Node) = {
    {
      node.prev.next = node.next
      node.next.prev = node.prev
    }
  }
  def clear
  = {
    head = null
    tail = null
  }
  def insertNodeAtHead(node: Node): Unit = {
    if (head == null) {
      head = node
      tail = node
    }
    else {
      //  null <=> newNode <=> head <=> someNode
      //create new Node, set it's next to current head,
      node.next = head
      //update prev pointer to point to new Node
      head.prev = node
      // make newNode the new head
      head = node
    }
  }
}
