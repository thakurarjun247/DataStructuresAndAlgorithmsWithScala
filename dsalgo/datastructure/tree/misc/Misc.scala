package dsalgo.datastructure.tree.misc
import dsalgo.datastructure.tree.create.Node
object Misc extends App {
  def printInorderSuccessors(root: Node): Unit = {
    if (root != null) {
      printInorderSuccessors(root.left)
      println(s"${root.key} parent ${if (root.parent == null) null else root.parent.key} => ${inorderSuccessor(root)}")
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
  def getLCA(root: Node, a: Node, b: Node): Node = {
    //assume a and b exist in the tree
    if (root == null) {
      println("root is null")
      null
    }
    else if (a == null) b
    else if (b == null) a
    else {
      val leftHasA = contains(root.left, a)
      val leftHasB = contains(root.left, b)
      if (leftHasA != leftHasB) root
      else {
        if (leftHasA) getLCA(root.left, a, b)
        else getLCA(root.right, a, b)
      }
    }
  }
  private def contains(root: Node, node: Node): Boolean =
    if (node == null) true
    else if (root == null) false
    else if (root.key == node.key) true
    else (contains(root.left, node) || contains(root.right, node))
  /////////////////isHeightBalanced Without Memo///////////////
  def isBalanced(root: Node): Boolean =
    if (root == null) true
    else math.abs(getHeight(root.left) - getHeight(root.right)) < 2
  def getHeight(root: Node): Int =
    if (root == null) 0
    else
      1 + getHeight(root.left) max getHeight(root.right)
  ///////////////////////////////////With Memo//////////////////////////////////
  def isBalancedMemo(root: Node): Boolean =
    if (root == null) true
    else math.abs(getHeightMemo(root.left, Map()) - getHeightMemo(root.right, Map())) < 2
  def getHeightMemo(root: Node, map: Map[Node, Int]): Int =
    if (root == null) 0
    else {
      if (map.get(root).isEmpty) {
        println("calculating height of " + root.key + "...")
        val rootHeight = 1 + getHeight(root.left) max getHeight(root.right)
        map + (root -> rootHeight)
        rootHeight
      }
      else {
        println("From cache, height of " + root.key + "...")
        map.get(root).get
      }
    }
}


