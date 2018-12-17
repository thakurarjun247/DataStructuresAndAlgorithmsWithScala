package ds.tree

import scala.collection.mutable
import scala.io.StdIn._

class Node(var key: Int, var left: Node = null, var right: Node = null, var hd: Int = 0)

object BinarySearchTree extends App {
  var root: Node = null
  create()
  println("\nInorder traversal...")
  inorder(root)
  levelOrder(root)
  bottomView(root)
  topView(root)

  def insert(root: Node, key: Int): Node = {
    if (root == null) return new Node(key)
    else {
      if (key <= root.key) root.left = insert(root.left, key)
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
    println("\nCreating BST..")
    println("Enter # nodes in tree")
    var n = readInt
    while (n != 0) {
      println("Enter node value: ")
      root = insert(root, readInt())
      n = n - 1
    }
  }

  def levelOrder(root: Node) =
    if (root != null) {
      println("\nLevel order traversal...")
      val q = new mutable.Queue[Node]()
      q.enqueue(root)
      while (q.size != 0) {
        val node = q.dequeue()
        print(s"${node.key} ")
        if (node.left != null) q.enqueue(node.left)
        if (node.right != null) q.enqueue(node.right)
      }
    }

  def bottomView(root: Node) = {
    println("\nBottom view..")
    //keep them ordered
    val map = mutable.TreeMap[Int, Int]()
    if (root != null) {
      val q = new mutable.Queue[Node]()
      q.enqueue(root)
      while (q.size != 0) {
        var hd = 0
        val node = q.dequeue()
        //notice: the only diff b/n top and bottom view is to replace or not replae map entries
        map += (node.hd -> node.key)
        if (node.left != null) {
          node.left.hd = node.hd - 1
          q.enqueue(node.left)
        }
        if (node.right != null) {
          node.right.hd = node.hd + 1
          q.enqueue(node.right)
        }
      }
    }
    map
      .foreach(pair => print(s" ${pair._2}"))

  }

  def topView(root: Node) = {
    println("\nTop view..")
    //keep them ordered
    val map = mutable.TreeMap[Int, Int]()
    if (root != null) {
      val q = new mutable.Queue[Node]()
      q.enqueue(root)
      while (q.size != 0) {
        var hd = 0
        val node = q.dequeue()
        //notice: the only diff b/n top and bottom view is to replace or not replae map entries

        if (!map.contains(node.hd)) map += (node.hd -> node.key)
        if (node.left != null) {
          node.left.hd = node.hd - 1
          q.enqueue(node.left)
        }
        if (node.right != null) {
          node.right.hd = node.hd + 1
          q.enqueue(node.right)
        }
      }
    }
    map
      .foreach(pair => print(s" ${pair._2}"))

  }

}
