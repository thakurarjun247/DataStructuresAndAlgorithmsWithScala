package datastructure.tree
import datastructure.tree.create.CreateTree._
import datastructure.tree.misc.Misc._
import datastructure.tree.traversal.TraverseTree._
object TreeApp extends App {
  //section create
//  val a = createBinarySearchTree(1 to 10 toArray)
  //val b = createBinarySearchTree(1 to 10 toArray)
  val c = createBinaryTree(1 to 15 toArray)
  //val d = null
/*  println(areTwoTreesIdentical(a, b))
  println(areTwoTreesIdentical(b, c))
  println(areTwoTreesIdentical(c, d))*/

  /*section traversal*/
  printLevelByLevel(c)
  -1 to 5 map(printNodeAtDistanceKFromRoot(c, _, 0))

  //connectSameLevelNodes(c)


}
