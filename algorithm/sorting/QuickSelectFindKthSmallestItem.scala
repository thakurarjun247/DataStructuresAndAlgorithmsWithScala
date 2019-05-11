package algorithm.sorting
import scala.collection.mutable.ListBuffer
import scala.util.Random
//find kth largest item
object QuickSelectFindKthSmallestItem extends App {
  val list: List[Int] = List(2, 1, 6, 3, 4, 7, 5, 8)
  (1 to 8).map(quickSelect(list, _)).foreach(println)
  def quickSelect(list: List[Int], k: Int): Int = {
    require(list.size >= k)
    val (l1, l2) = list.tail.partition(_ < list.head)
    if (l1.size == k - 1) list.head
    else if (l1.size < k - 1) quickSelect(l2, k - l1.size - 1)
    else quickSelect(l1, k)
  }
}

