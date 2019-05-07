package datastructure.mutable.graph
import scala.collection.mutable.ListBuffer
case class Node(label: String, adjList: ListBuffer[Node], isVisited: Boolean = false)
case class Edge(dest: Node, weight: Int=0)
class Graph(val nodes : ListBuffer[Node]){

  def addEdge(source:Node, dest:Node, weight:Int=0, isDirected:Boolean=true)={
    if(!nodes.contains(source)) nodes+=source
    if(!nodes.contains(dest)) nodes+=dest
    val edge=Edge(dest, weight)
    nodes.foreach(node => if(node==source) node.adjList+=dest)


  }
}
