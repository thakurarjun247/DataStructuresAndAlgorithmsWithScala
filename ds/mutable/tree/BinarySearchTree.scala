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
  printMirror(null)
  printLevelByLevel(root)
  printInorderSuccessors(root)
 /*
  println("\nInorder traversal...")
  inorder(root)
  levelOrder(root)
  bottomView(root)
  bottomViewWithManualSorting(root)
  topView(root)
  printMirror(root)*/
  val a=BSTFromSortedArray.createTreeFromArray(1 to 10 toArray)
  val b=BSTFromSortedArray.createTreeFromArray(1 to 10 toArray)
  val c=BSTFromSortedArray.createTreeFromArray(1 to 11 toArray)
  val d=null
  println(areTwoTreesIdentical(a,b))
  println(areTwoTreesIdentical(b,c))
  println(areTwoTreesIdentical(c,d))
  //println(areTwoTreesIdentical())

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
      root.left.parent=root}
      else {
        root.right = insert(root.right, key)
      root.right.parent=root}
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
 /* def findLowestCommonAncestor(root:Node, a:Node, b:Node):Node={
    if(a==null || b==root) b
    else if (b==null || a==root) a
    else if(b.contains(a)) b
    else if(a.contains(b)) a
    else{
     val leftContainsA=root.left.contains(a)
      val rightContainsA=root.right.contains(a)
      val leftContainsB=root.left.contains(b)
      val rightContainsB=root.right.contains(b)
      if((leftContainsA && !leftContainsB)  || (rightContainsA && !rightContainsB))
        root
      else findLowestCommonAncestor(root.left, a, b)
    }
  }
*/
  def contains(node:Node):Boolean=true


  def areTwoTreesIdentical(a: Node, b: Node): Boolean =
    if (a == null && b == null) true
    else if (a == null || b == null) false
    else (a.key == b.key) && areTwoTreesIdentical(a.left, b.left) && areTwoTreesIdentical(a.right, b.right)




  }
