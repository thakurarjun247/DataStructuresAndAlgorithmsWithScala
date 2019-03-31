package ds.mutable.tree
import util.DateTimeUtil
object BSTFromSortedArray extends App {
  val root = createTreeFromArray(1 to 15 toArray)
  // val root2= f(1 to 100 toArray)
  // BinarySearchTree.inorder(root)
  //BinarySearchTree.printLevelByLevel(root)
  println(IsBinaryTreeHeightBalanced.isBalanced(root))
/*  DateTimeUtil.timeIt({
    IsBinaryTreeHeightBalanced.isBalanced(root)
  })*/

  def createTreeFromArray(a: Array[Int]): Node = {
    if (a.isEmpty) null
    else {
      val (a1, a2) = a.splitAt(a.size / 2)
      val root = new Node(a2.head)
      root.left = (createTreeFromArray(a1))
      root.right = createTreeFromArray(a2.tail)
      root
    }
  }
}
