package dsalgo.datastructure.tree.traversal
import dsalgo.datastructure.tree.create.Node
import scala.collection.mutable
object TraverseTree extends App {
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
    //or
    println
    map.values.foreach(value => print(s"$value "))
  }
  def bottomViewWithManualSorting(root: Node) = {
    println("\nBottom view without TreeMap...")
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
    println("without sorting...")
    map.values.foreach(value => print(s"$value "))
    println("\nafter manual sorting...")
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
      val q = mutable.Queue[Node]()
      //root's level is already set by default to 0
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
  def connectSameLevelNodes(root: Node) = {
    val firstNodeOfLevel = mutable.Queue[Node]()
    if (root != null) {
      val q = mutable.Queue[Node]()
      //root's level is already set by default to 0
      q.enqueue(root)
      var prevNode: Node = new Node(key = 0, level = -1)
      while (q.size != 0) {
        val node = q.dequeue()
        if (node.level == prevNode.level) {
          prevNode.sibling = node
          prevNode = node
        }
        else {
          prevNode = node
          firstNodeOfLevel += node
        }
        if (node.left != null) {
          node.left.level = node.level + 1
          q.enqueue(node.left)
        }
        if (node.right != null) {
          node.right.level = node.level + 1
          q.enqueue(node.right)
        }
      }
      while (firstNodeOfLevel.nonEmpty) {
        var node = firstNodeOfLevel.dequeue()
        println("\n---------------------------------------------------")
        while (node != null) {
          print(s"${node.key} -> ")
          node = node.sibling
        }
      }
    }
  }

  def printNodeAtDistanceKFromRoot(root: Node, k: Int, currNodeDistFromRoot: Int): Unit = {
    if (root != null && currNodeDistFromRoot<=k) {
      if (currNodeDistFromRoot == k) print(" "+root.key)
      else {
        printNodeAtDistanceKFromRoot(root.left, k , currNodeDistFromRoot+1)
        printNodeAtDistanceKFromRoot(root.right, k , currNodeDistFromRoot+1)
      }
    }

  }
}
