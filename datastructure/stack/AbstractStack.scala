package datastructure.stack
trait AbstractStack[T] {
  def pop: T
  def push(item: T): Unit
  def peek: T
  def isEmpty: Boolean
}
