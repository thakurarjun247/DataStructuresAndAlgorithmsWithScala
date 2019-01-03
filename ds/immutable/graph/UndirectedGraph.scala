package ds.immutable.graph

class UndirectedGraph[V](adjList: Map[V,List[V]]) extends DirectedGraph[V](adjList) {
override def addEdge(a: V, b: V): Graph[V] = {
 /* super.addEdge(b,a)
  super.addEdge(a,b)*/
  //prepend to list
  val aNeighbours= b +: neighbours(a)
  val bNeighbours = a +: neighbours(b)
  //dont update create new
  new DirectedGraph(adjList + (a -> aNeighbours, b-> bNeighbours))
}
}
