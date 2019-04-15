package greedyalgorithms
import java.util.PriorityQueue
/*
* Provided n ropes with different lengths we are require to join them to form one rope.Joining two ropes with a and b length costs a*b. We are require to join all ropes with minimum cost possible.*/


object RopeJoinMinCost extends App{
/*  case class IntOrder() extends Ordering[Int] {
    def compare(x:Int, y:Int) = y compare x
  }*/
  import java.util.Comparator
  class MyComparator extends Comparator[Integer] {
    override def compare(x: Integer, y: Integer): Int = y - x
  }
  var minHeap = new PriorityQueue[Int]()
 minHeap.add(3)
  minHeap.add(13)
  minHeap.add(-3)
  minHeap.add(33)
  minHeap.forEach(println)
  /*scala.collection.mutable.PriorityQueue.empty(MinOrder)

  minHeap.ord.foreach(println)*/
}
