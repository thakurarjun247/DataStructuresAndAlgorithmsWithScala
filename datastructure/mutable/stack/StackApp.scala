package datastructure.mutable.stack

object StackApp extends App{
val stack=new Stack[Int]
  0 to 5 foreach(stack.push)
  0 to 6 foreach(item=>println(stack.pop))
}
