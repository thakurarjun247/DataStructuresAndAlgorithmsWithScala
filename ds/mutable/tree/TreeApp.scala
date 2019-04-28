package ds.mutable.tree

object TreeApp extends App{
  val a=TreeUtil.createBinarySearchTree(1 to 10 toArray)
  val b=TreeUtil.createBinarySearchTree(1 to 10 toArray)
  val c=TreeUtil.createBinaryTree(1 to 11 toArray)
  val d=null
  println(TreeUtil.areTwoTreesIdentical(a,b))
  println(TreeUtil.areTwoTreesIdentical(b,c))
  println(TreeUtil.areTwoTreesIdentical(c,d))
}
