package ds.mutable.tree
import util.DateTimeUtil

import scala.collection.mutable
object TreeUtil extends App {
  val root = createTreeFromArray(1 to 15 toArray)
  // val root2= f(1 to 100 toArray)
  // BinarySearchTree.inorder(root)
  //BinarySearchTree.printLevelByLevel(root)
  println(IsBinaryTreeHeightBalanced.isBalanced(root))
/*  DateTimeUtil.timeIt({
    IsBinaryTreeHeightBalanced.isBalanced(root)
  })*/

  def createBinarySearchTree(a: Array[Int]=Array(4, 2, 6, 1, 3, 5, 7))=createTreeFromArray(a)
  def createBinaryTree(a: Array[Int]= (1 to 10).toArray )=createTreeFromArray(a)

   private def createTreeFromArray(a: Array[Int]): Node = {
    if (a.isEmpty) null
    else {
      val (a1, a2) = a.splitAt(a.size / 2)
      val root = new Node(a2.head)
      root.left = (createTreeFromArray(a1))
      root.right = createTreeFromArray(a2.tail)
      root
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

  def createMirrorImage(originalNode: Node, mirroredNode: Node): Node = {
    if(originalNode==null) return null
    mirroredNode.key = (originalNode.key)
    if (originalNode.left != null) mirroredNode.left = (createMirrorImage(originalNode.right, new Node(0)))
    if (originalNode.right != null) mirroredNode.right = (createMirrorImage(originalNode.left, new Node(0)))
    mirroredNode
  }
  def printMirror(root: Node) = {
    print("\nCreating mirror image of the following tree")
    //original tree
    printLevelByLevel(root)
    val mirrorRootInitial = new Node(0)
    print("\nmirror tree...")
    val mirrorRootFinal = createMirrorImage(root, mirrorRootInitial)
    printLevelByLevel(mirrorRootFinal)
    print("\nnew mirror tree...")
  }

  def printInorderSuccessors(root: Node):Unit= {
    if (root != null) {
      printInorderSuccessors(root.left)
      println(s"${root.key} parent ${if(root.parent==null) null else root.parent.key} => ${inorderSuccessor(root)}")
      // if (root.key == 7) {
      printInorderSuccessors(root.right)
      //    }
    }
    def inorderSuccessor(root: Node): Node =
      if (root == null) null
      else if (root.right != null) findLeftMostNodeOfTreeDownThere(root.right)
      else findForeparentGreaterThanANode(root)
    def findLeftMostNodeOfTreeDownThere(node: Node): Node =
      if (node == null) null
      else if (node.left == null) node
      else findLeftMostNodeOfTreeDownThere(node.left)
    //TODO: fix this buggy method
    def findForeparentGreaterThanANode(root: Node): Node = {
      if (root == null || root.parent == null) null
      //reached top
      //  else if (root.parent == null) null
      //found the right foreparent
      else if (root.parent.key < root.key)
        findForeparentGreaterThanANode(root.parent)
      else root.parent

    }
  }

  def areTwoTreesIdentical(a: Node, b: Node): Boolean =
    if (a == null && b == null) true
    else if (a == null || b == null) false
    else (a.key == b.key) && areTwoTreesIdentical(a.left, b.left) && areTwoTreesIdentical(a.right, b.right)


}
