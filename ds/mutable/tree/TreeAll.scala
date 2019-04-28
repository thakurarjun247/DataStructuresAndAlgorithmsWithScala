package ds.mutable.tree
import scala.collection.mutable
import scala.io.StdIn._
class Node(var key: Int,
           var left: Node = null,
           var right: Node = null,
           var hd: Int = 0,
           var level: Int = 0,
           var parent: Node = null) {
  override def toString = getTabs(level) + s"($key)"
  def getTabs(level: Int): String =
    level match {
      case 0 => "\t\t  "
      case 1 => "\t  "
      case 2 => "  "
      case _ => " "
    }
}
object BinarySearchTree extends App {
  //
  var root: Node = null
  val inputStack = mutable.Stack[Int](4, 2, 6, 1, 3, 5, 7)
  create()
  def insert(root: Node, key: Int): Node = {
    if (root == null) return new Node(key)
    //can't be rewritten as
    //if (root == null) root=new Node(key)
    //reassign to val root
    else {
      //need to set to left so that tree expands in left and right.
      if (key <= root.key) {
        root.left = insert(root.left, key)
        //set parent so that we can use this infor in
        //finding inorder successor
        root.left.parent = root
      }
      else {
        root.right = insert(root.right, key)
        root.right.parent = root
      }
    }
    //need to return root here so that caller always have the same/original root
    root
  }
  def inorder(root: Node): Unit = {
    if (root != null) {
      inorder(root.left)
      print(root.key + " ")
      inorder(root.right)
    }
  }
  def create() = {
    println("Creating BST..")
    //println("Enter # nodes in tree")
    var n = inputStack.size //readInt
    while (n != 0) {
      // println("Enter node value: ")
      root = insert(root, inputStack.pop() /*readInt()*/)
      n = n - 1
    }
  }
}
