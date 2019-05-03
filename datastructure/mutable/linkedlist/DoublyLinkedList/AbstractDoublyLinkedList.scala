package datastructure.mutable.linkedlist.DoublyLinkedList
trait AbstractDoublyLinkedList[T] {
  def deleteNode(t: T): Unit
  def deleteLastNode: Unit
  def insertNodeAtHead(t: T): Unit
  var head: T
}
