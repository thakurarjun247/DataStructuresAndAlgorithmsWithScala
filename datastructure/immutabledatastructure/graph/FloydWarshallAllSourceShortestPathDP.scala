package datastructure.immutabledatastructure.graph
object FloydWarshallAllSourceShortestPathDP {
  def main(args: Array[String]): Unit = {
    val graph = Array(Array(1, 3, -2), Array(2, 1, 4), Array(2, 3, 3))
    val dist = f(graph)
    println(dist)
  }
  def f(graph: Array[Array[Int]]) = {
    // val dist=Array.ofDim(graph.length, graph(0).length)
    var dist = graph
    val v = graph.size
    for (k <- 0 until v)
      for (i <-0 until v)
        for (j <- 0 until v)
          if (dist(i)(k) + dist(k)(j) < dist(i)(j))
            dist(i)(j) = dist(i)(k) + dist(k)(j)
    dist
  }
}
