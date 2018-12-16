/*
package ds.binarytree.ds.linkedlist

import scala.io.StdIn.readInt

class Node {
  var key: Int=0
  var next: Node=null
}

object LinkedList extends App{
  var start = new Node
  create()
  traverse(start)
  def create() = {
    print("enter the elments in the LL: ")
    val len = readInt
    (1 to len) foreach (item => {
      println("enter node key: ")
      insert(readInt)
    })
  }

  def traverse(temp: Node) = {
    var start = temp
    while (start!=null) {

      print(s"${start.key} -> ")

      start = start.next

    }
  }

  def insert(key: Int) = {
    var temp = start
    if (start.key!=null) start.key = key
    else {
      while (temp.next!=null) {
        temp = temp.next
      }
      val node = new Node
      node.key = key
      temp.next = node
    }

  }
}

*/
