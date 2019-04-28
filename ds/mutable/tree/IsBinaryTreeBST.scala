package ds.mutable.tree
object IsBinaryTreeBST extends App {
  val bstRoot = TreeUtil.createBinarySearchTree()
  val nonBSTRoot = TreeUtil.createBinaryTree()
  TreeUtil.printLevelByLevel(bstRoot)
  println(isBST(bstRoot))
  TreeUtil.printLevelByLevel(nonBSTRoot)
  println(isBST(nonBSTRoot))
  def isBST(root: Node): Boolean = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)
  def isBST(root: Node, min: Int, max: Int): Boolean =
    if (root == null) true
    else isWithinRange(root, min, max) && isBST(root.left, min, root.key) && isBST(root.right, root.key, max)
  def isWithinRange(node: Node, min: Int, max: Int) = (node.key > min) && (node.key < max)
}
