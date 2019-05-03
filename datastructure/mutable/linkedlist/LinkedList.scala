package datastructure.mutable.linkedlist

import scala.collection.mutable
import scala.io.StdIn.readInt
class Node(var key: Int, var next: Node = null) {
  def nextNode = if (next == null) "null" else next.key.toString
  override def toString = s"$key ->($nextNode)"
}
object LinkedList extends App {
  val set=  mutable.Set[Int]()
  println(set.add(1))
  println(set.add(1))
  var start = new Node(0)
  //createUsingUserInput()
  createUsingGivenArray(Array(1,2,3,4))
  traverse(start)
  println("start is " + start.key)
  traverseNew(start.next)
 // reverse(start)
  reverseNew(start)

  /* println("what index to delete?")
  val deleteAt=readInt()
  val index=delete(start, deleteAt)
  println(s"found at ${index.getOrElse("not found")}")*/
  //traverse(start)
  def createUsingUserInput() = {
    print("enter length of LL: ")
    val len = readInt
    (1 to len) foreach (item => {
      println("enter node key: ")
      insert(readInt)
    })
  }

  def createUsingGivenArray(a:Array[Int]) = {
a.foreach(insert)
  }
  def reverse(node: Node): Node = {
    println("reversing...")
    if (node == null) return node
    var cur = node
    var next: Node = null
    var pre: Node = null
    while (cur.next != null) {
      next = cur.next
      cur.next = pre
      pre = cur
      cur = next
    }
    cur.next = pre
    traverseNew(cur)
    cur
  }
  def reverseNew(startNode: Node): Node = {
    println("currently it's => "+traverseNew(startNode.next))
    if (startNode == null) return startNode
    else {
      //temp head variable as the startNode is immutable
      var head = startNode
      var prev: Node = null
      var curr: Node = null
      var next:Node=null
      while (head != null) {
        next=head.next
        curr = head
        head.next = prev
        prev = curr
        head = next
      }
      println("after reversing =>" + traverseNew(curr))
      curr
    }
  }

  def traverse(start: Node) = {
    var temp = start
    while (temp.next != null) {
      print(s" ${temp.next.key} ->")
      temp = temp.next
    }
  }
  def insert(key: Int) = {
    var temp = start
    while (temp.next != null)
      temp = temp.next
    val newNode = new Node(key)
    temp.next = newNode

    //or
    //temp.next=new Node(key)
  }
  def delete(start: Node, key: Int): Option[Int] = {
    var i = 0
    while (start.next != null || start.next.key != key) {
      if (start.next.key == key) return Some(i)
      else i += 1
    }
    traverse(start)
    None
  }
  def traverseNew(node: Node): Unit = {
    if (node != null) {
      print(node.key + " ")
      traverseNew(node.next)
    }
  }

}


