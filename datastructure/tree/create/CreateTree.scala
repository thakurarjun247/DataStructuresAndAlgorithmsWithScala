package datastructure.tree.create
import datastructure.tree.traversal.TraverseTree
object CreateTree extends App {
  val root = createTreeFromArray(1 to 15 toArray)
  def createBinarySearchTree(a: Array[Int] = Array(4, 2, 6, 1, 3, 5, 7)) = createTreeFromArray(a)
  def createBinaryTree(a: Array[Int] = (1 to 10).toArray) = createTreeFromArray(a)
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
  private def createMirrorImage(originalNode: Node, mirroredNode: Node): Node = {
    if (originalNode == null) return null
    mirroredNode.key = (originalNode.key)
    if (originalNode.left != null) mirroredNode.left = (createMirrorImage(originalNode.right, new Node(0)))
    if (originalNode.right != null) mirroredNode.right = (createMirrorImage(originalNode.left, new Node(0)))
    mirroredNode
  }
  def printMirror(root: Node) = {
    print("\nCreating mirror image of the following tree")
    //original tree
    TraverseTree.printLevelByLevel(root)
    val mirrorRootInitial = new Node(0)
    print("\nmirror tree...")
    val mirrorRootFinal = createMirrorImage(root, mirrorRootInitial)
    TraverseTree.printLevelByLevel(mirrorRootFinal)
    print("\nnew mirror tree...")
  }
}
