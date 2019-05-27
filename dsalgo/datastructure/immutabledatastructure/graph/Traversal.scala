package dsalgo.datastructure.immutabledatastructure.graph
import scala.collection.immutable.Queue
import scala.collection.mutable
object Traversal {
  def main(args: Array[String]): Unit = {
    val start = 0
    val adjList: Map[Int, List[Int]] = Map(0 -> List(2, 3, 4), 2 -> List(22, 44), 4 -> List(44, 55), 44 -> List(555, 666))
    // bfs(start, adjList)
    dfs(start, adjList)
    // bfsFunctionalStyle[Int](0, Graph(adjList), n => println(n))
  }
  /*
    void topologicalSort()
      {
          Stack stack = new Stack();

          // Mark all the vertices as not visited
          boolean visited[] = new boolean[V];
          for (int i = 0; i < V; i++)
              visited[i] = false;

          // Call the recursive helper function to store
          // Topological Sort starting from all vertices
          // one by one
          for (int i = 0; i < V; i++)
              if (visited[i] == false)
                  topologicalSortUtil(i, visited, stack);

          // Print contents of stack
          while (stack.empty()==false)
              System.out.print(stack.pop() + " ");
      }
   */
  def topologicalSort(adjList: Map[Int, List[Int]]) = {
    val visitedNodes = mutable.Set[Int]()
    val stack = mutable.Stack[Int]()
    adjList
      .keySet
      .filterNot(visitedNodes contains (_))
      .foreach(topoSortUtil(stack, _))
  }
  def topoSortUtil(stack: mutable.Stack[Int], i: Int) = ""
  def bfs[Int](vertex: Int, adjList: Map[Int, List[Int]]) = {
    //Elements are not ordered.
    //The add, remove, and contains methods has constant time complexity O(1).
    val visitedNodes = mutable.Set[Int]()
    if (vertex != null) {
      val q = mutable.Queue[Int]()
      q.enqueue(vertex)
      while (q.nonEmpty) {
        val v = q.dequeue
        if (!visitedNodes.contains(v)) {
          println(v)
          val list = adjList.getOrElse(v, Nil)
          list.foreach(item => q.enqueue(item))
          visitedNodes += v
        }
      }
    }
  }
  def bfsFunctionalStyle[V](vertex: V, graph: Graph[V], f: V => Unit): Unit = {
    //Queue has all the nodes, Set has visited nodes
    Stream.iterate((Queue(vertex), Set[V](vertex))) { case (q, visited) =>

      val (vertex, rest) = q.dequeue
      val newQueue = rest.enqueue(graph.neighbours(vertex).filterNot(visited.contains))
      val newVisited = graph.neighbours(vertex).toSet ++ visited
      (newQueue, newVisited)
    }
      .takeWhile(t => t._1.nonEmpty).foreach(t => f(t._1.head))
  }
  def dfs(start: Int, adjList: Map[Int, List[Int]]) = {
    val visitedNodes = mutable.Set[Int]()
    val stack = mutable.Stack[Int]()
    stack.push(start)
    while (stack.nonEmpty) {
      val v = stack.pop
      if (!visitedNodes.contains(v)) {
        adjList
          .getOrElse(v, Nil)
          .foreach(item => stack.push(item))
        println(v)
        visitedNodes += v
      }
    }
  }
}
