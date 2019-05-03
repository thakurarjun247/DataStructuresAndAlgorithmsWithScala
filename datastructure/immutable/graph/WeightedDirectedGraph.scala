package datastructure.immutable.graph
case class WeigthedEdge[V](destination: V, weight: Int)
class WeightedUndirectedGraph[V](adjList: Map[V, List[V]]) extends Graph[V] {
  override def vertices: List[V] = adjList.keys.toList
  override def edges: List[(V, V)] = adjList
    .toList
    .flatMap {
      case (v, neighbours) => neighbours.map(n => (v, n))
    }
  override def addEdge(a: V, b: V): Graph[V] = ???
  override def neighbours(v: V): List[V] = ???
}
