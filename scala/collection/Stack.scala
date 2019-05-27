package scala.collection
import scala.collection.mutable
object Stack extends App {
  val stack = mutable.Stack[Int]()
  //for stack there are no += or ++=
  stack.size
  stack.push(1)
  stack.pushAll(Seq(1, 2, 3))
  //remove top element or throw exception
  println(stack.pop())
  println(stack.clear)
  //head and top are same, return top elem but don't delete it, readonly
  //throw exception if empty
  println(stack.head)
  println(stack.top)
  stack.pushAll(List(2, 3))
  //can check it with
  stack.isEmpty
}
