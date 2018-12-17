package ds.tree

import scala.io.StdIn._

class Node(var key: Int, var left: Node = null, var right: Node = null)

object BinarySearchTree extends App {
  var root: Node = null
  def insert(root: Node, key: Int): Node = {
    if (root == null) return new Node(key)
    else {
      if (key < root.key) root.left = insert(root.left, key)
      else root.right = insert(root.right, key)
    }
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
    println("# nodes in tree")
    var n = readInt
    while (n != 0) {
      println("enter node ")
      root = insert(root, readInt())
      n = n - 1
    }
  }

  println("creating..")
  create()
  println("traversing..")
  inorder(root)
}
