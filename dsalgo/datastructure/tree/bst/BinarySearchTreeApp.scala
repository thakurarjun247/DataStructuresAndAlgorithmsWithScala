package dsalgo.datastructure.tree.bst
import dsalgo.datastructure.tree.create.Node

import scala.collection.mutable
object BinarySearchTreeApp extends App {
  //
  var root: Node = null
  val inputStack = mutable.Stack[Int](4, 2, 6, 1, 3, 5, 7)
  createBST()
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
  def createBST() = {
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