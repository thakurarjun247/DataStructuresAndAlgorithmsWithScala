package ds.graph
import scala.collection.immutable.Queue
import scala.collection.mutable
object Traversal extends App{
  val adjList:Map[Int, List[Int]]=Map(1 ->List(2,3))
  bfs[Int](1,Graph(adjList), n=>println(n) )
 def bfs[V](vertex: V, graph: Graph[V], f: V => Unit): Unit = {
//Queue has all the nodes, Set has visited nodes
   Stream.iterate((Queue(vertex), Set[V](vertex))) { case (q, visited) =>

     val (vertex, rest) = q.dequeue

     val newQueue = rest.enqueue(graph.neighbours(vertex).filterNot(visited.contains))

     val newVisited = graph.neighbours(vertex).toSet ++ visited

     (newQueue, newVisited)

   }
     .takeWhile(t => t._1.nonEmpty).foreach(t => f(t._1.head))
 }


}
