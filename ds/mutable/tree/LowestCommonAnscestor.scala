package ds.mutable.tree
object LowestCommonAnscestor extends App {
  val root = TreeUtil.createBinaryTree(Array(4, 12, 14, 2, 6, 1, 3, 5, 7, 11, 13))

//  println(root.key ,  root.left.key, root.left.right.key)
 // TreeUtil.printLevelByLevel(root)
//  val lca =getLCA(root, root.left, root.left.right)
  //println(lca.key)
  private def contains(root: Node, node: Node): Boolean =
    if (node == null ) true
    else if (root == null) false
    else if( root.key == node.key) true
    else (contains(root.left, node) || contains(root.right, node))
  def getLCA(root: Node, a: Node, b: Node): Node = {
    //assume a and b exist in the tree
    if(root==null) {
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
}
