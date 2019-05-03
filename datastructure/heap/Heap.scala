package datastructure.heap
trait Heap[T] {
  def delete: T
  def add(t: T): Unit
  def head: T
  def parent(t:T):T
}
