package ds.mutable.tree

import scala.collection.mutable
import scala.io.StdIn._

class Node(var key: Int,
           var left: Node = null,
           var right: Node = null,
           var hd: Int = 0,
           var level: Int = 0) {
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
  var root: Node = null
  val inputStack = mutable.Stack[Int](4, 2, 6, 1, 3, 5, 7)
  create()
  printLevelByLevel(root)
  println("\nInorder traversal...")
  inorder(root)
  levelOrder(root)
  bottomView(root)
  bottomViewWithManualSorting(root)
  topView(root)


  def insert(root: Node, key: Int): Node = {
    if (root == null) return new Node(key)
      //can't be rewritten as
    //if (root == null) root=new Node(key)
      //reassign to val root
    else {
      //need to set to left so that tree expands in left and right.
      if (key <= root.key) root.left = insert(root.left, key)
      else root.right = insert(root.right, key)
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
  def bottomViewWithManualSorting(root: Node) = {
    println("\nBottom view with manual sorting..")
    //keep them unordered, we dont use treemap here instead sort in the
    //end, more efficient as we don't need the ordering overhead during
    //the whole process
    val map = mutable.Map[Int, Int]()
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
      .toList
      //sort here
      .sortWith(_._1 < _._1)
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

  def printLevelByLevel(root: Node) = {
    val buffer = mutable.ListBuffer[Node]()
    if (root != null) {
      val q =  mutable.Queue[Node]()
      q.enqueue(root)
      while (q.size != 0) {
        val node = q.dequeue()
        buffer += node
        if (node.left != null) {
          node.left.level = node.level + 1
          q.enqueue(node.left)
        }
        if (node.right != null) {
          node.right.level = node.level + 1
          q.enqueue(node.right)
        }
      }
      buffer
        .groupBy(_.level)
        .toSeq
        .sortWith(_._1 < _._1)
        .foreach(level => {
          print(s"\n${level._1} => ")
          level._2.foreach(print)
        })
    }
  }
}
