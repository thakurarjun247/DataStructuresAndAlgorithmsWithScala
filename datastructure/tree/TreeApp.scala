package datastructure.tree
import datastructure.tree.create.CreateTree._
import datastructure.tree.misc.Misc._
object TreeApp extends App {
  val a = createBinarySearchTree(1 to 10 toArray)
  val b = createBinarySearchTree(1 to 10 toArray)
  val c = createBinaryTree(1 to 11 toArray)
  val d = null
  println(areTwoTreesIdentical(a, b))
  println(areTwoTreesIdentical(b, c))
  println(areTwoTreesIdentical(c, d))
}