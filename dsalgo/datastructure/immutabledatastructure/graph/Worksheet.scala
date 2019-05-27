package dsalgo.datastructure.immutabledatastructure.graph
object Worksheet extends App {
  val graph = new DirectedGraph[Int](Map(
    0 -> Nil,
    1 -> List(2, 3),
    2 -> List(3)
  ))
  println("edges")
  graph.edges.foreach(println)
  val adjList = Map(
    0 -> Nil,
    1 -> List(2, 3),
    2 -> List(3)
  )
  val adjListToList: List[(Int, List[Int])] = adjList
    .toList
  adjListToList
    .flatMap {
      case (v, neighs) => neighs.map(n => (v, n))
    }
}
