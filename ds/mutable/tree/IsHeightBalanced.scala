package ds.mutable.tree
object IsBinaryTreeHeightBalanced extends App {
  val root=TreeUtil.createBinaryTree()
  println(isBalanced(root))
  println(isBalancedMemo(root))

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
