package collection

import scala.collection.mutable

object Stack extends App {
  val stack = mutable.Stack[Int]()
  stack.size
  stack.push(1)
  //remove top element or throw exception
  println(stack.pop())

  //head and top are same, return top elem but don't delete it, readonly
  //throw exception if empty
  println(stack.head)
  println(stack.top)
  stack.pushAll(List(2, 3))

}
