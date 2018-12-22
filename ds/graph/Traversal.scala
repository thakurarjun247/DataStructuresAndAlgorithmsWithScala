package ds.graph
import scala.collection.immutable.Queue
object Traversal extends App{
 /* def bfs[V](start:V, graph: Graph[V],f:V=>Unit):Unit={

  }
*/
  val adjList:Map[Int, List[Int]]=Map(1 ->List(2,3))
  traversalBFS[Int](1,Graph(adjList), n=>println(n) )
 def traversalBFS[V](start: V, graph: Graph[V], f: V => Unit): Unit = {
//Queue has all the nodes, Set has visited nodes
   Stream.iterate((Queue(start), Set[V](start))) { case (q, visited) =>

     val (vertex, rest) = q.dequeue

     val newQueue = rest.enqueue(graph.neighbours(vertex).filterNot(visited.contains))

     val newVisited = graph.neighbours(vertex).toSet ++ visited

     (newQueue, newVisited)

   }

     .takeWhile(t => t._1.nonEmpty).foreach(t => f(t._1.head))

 }
}
