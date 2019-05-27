package dsalgo.datastructure.linkedlist.DoublyLinkedList
//All methods are working fine
object DoublyLinkedListApp extends App {
  val dll = new DoublyLinkedList
  var tail = dll.tail
  var head = dll.head
  val node0 = Node(("zero", "0"))
  val node1 = Node(("one", "1"))
  val node2 = Node(("two", "2"))
  val node3 = Node(("three", "3"))
  dll.insertNodeAtHead(node3)
  dll.insertNodeAtHead(node2)
  dll.insertNodeAtHead(node1)
  dll.insertNodeAtHead(node0)
  //dll.deleteMiddleNode(node1)
  //  dll.deleteHead
  // dll.deleteTail
  // println()
  // dll.insertNodeAtHead(node0)
  /*  dll.deleteNode(node1)
    dll.deleteNode(node0)
    dll.deleteNode(node3)*/
  println()
  dll.moveNodeToFront(node3)
  dll.moveNodeToFront(node1)
  println()
}
