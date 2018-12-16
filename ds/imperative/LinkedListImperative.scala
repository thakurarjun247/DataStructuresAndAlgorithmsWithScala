package ds.imperative

import scala.io.StdIn.readInt


class Node(var key: Int, var next: Node = null)

object LinkedList extends App {

  var start = new Node(0)
  create()
  traverse(start)
  println("what index to delete?")
  val deleteAt=readInt()
  val index=delete(start, deleteAt)
  println(s"found at ${index.getOrElse("not found")}")
  traverse(start)

  def create() = {
    print("enter length of LL: ")
    val len = readInt
    (1 to len) foreach (item => {
      println("enter node key: ")
      insert(readInt)
    })
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

  }

  def delete(start:Node, key:Int):Option[Int]={
    var i=0
    while(start.next!=null || start.next.key!=key){
      if(start.next.key==key) return Some(i)
      else i+=1
    }
    None
      }


}



