package dsalgo.datastructure.tree.pathsum
import dsalgo.datastructure.tree.create.Node
import scala.collection.mutable.ListBuffer
object PathSum extends App {
  var paths = ListBuffer[ListBuffer[Node]]()
  val root=dsalgo.datastructure.tree.create.CreateTree.createBinaryTree()
  print("SGN")
  kSumPaths(root, 5, ListBuffer[Node]())
/*  paths
    .foreach(list=> {
      println()
      list.foreach(item => print(item.key+" "))
    })*/
  def kSumPaths(node: Node, sum: Int, path: ListBuffer[Node]): Unit = {

    if (node == null) {
      if (sum == 0){
        println()
        path.foreach(item=> print(item+" -> "))
        paths += path}
    }
    else {
      kSumPaths(node.left, sum - node.key, path += node)
      kSumPaths(node.right, sum - node.key, path += node)
      kSumPaths(node.left, sum, ListBuffer[Node]())
      kSumPaths(node.right, sum, ListBuffer[Node]())
      if (node.key == sum) {
        path += node
        println()
       // path.foreach(item=> print(item+" -> "))
        paths += path
      }
    }
  }
}
