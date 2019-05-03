package algorithm.greedyalgorithms
import scala.collection.mutable
/*
* Provided n ropes with different lengths we are require to join
* them to form one rope.Joining two ropes with a and b length
* costs a*b. We are require to join all ropes with minimum
* cost possible.*/
object RopeJoinMinCost extends App {
  //fix it's incomplete
  def ascendingOrder(i: Int) = -i
  var minHeap = mutable.PriorityQueue[Int]()(Ordering.by(ascendingOrder))
  minHeap.enqueue(3)
  minHeap.enqueue(4)
  minHeap.enqueue(2)
  minHeap.enqueue(5)
  var ans = 1;
  while (minHeap.nonEmpty) ans *= minHeap.dequeue()
  print(ans)
}
