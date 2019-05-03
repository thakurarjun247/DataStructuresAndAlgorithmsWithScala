package datastructure.tree
import datastructure.tree.create.CreateTree
object TreeApp extends App {
  val a = CreateTree.createBinarySearchTree(1 to 10 toArray)
  val b = CreateTree.createBinarySearchTree(1 to 10 toArray)
  val c = CreateTree.createBinaryTree(1 to 11 toArray)
  val d = null
  println(CreateTree.areTwoTreesIdentical(a, b))
  println(CreateTree.areTwoTreesIdentical(b, c))
  println(CreateTree.areTwoTreesIdentical(c, d))
}
