package datastructure.immutabledatastructure.graph
class DirectedGraph[V](adjList: Map[V, List[V]]) extends Graph[V] {
  override def vertices: List[V] = adjList.keys.toList
  override def edges: List[(V, V)] =
    adjList
      .toList
      .flatMap { case (v, neighbours) =>
        neighbours.map(n => (v, n))
      }
  override def addEdge(a: V, b: V): Graph[V] = {
    //prepend to list
    val aNeighbours = b +: neighbours(a)
    //dont update create new
    new DirectedGraph(adjList + (a -> aNeighbours))
    //optimize
    /*
    Had it been mut map just do something like
    mutMap += a -> aNeighbours
    */
  }
  override def neighbours(v: V): List[V] = adjList.getOrElse(v, Nil)
}
