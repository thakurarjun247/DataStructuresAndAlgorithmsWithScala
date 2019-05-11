package algorithm.sorting
//find kth largest item
object RandomizedQuicksortFindNLargestItems extends App {
  val list: List[Int] = List(2, 1, 6, 3, 4, 7, 5, 8)
  println(f(list, 63, Nil))
  def f(list: List[Int], k: Int, suffix: List[Int]): List[Int] = {
    require(list.size >= k, s"list should have at list $k items")
    if (list.size == k) return list:::suffix
    val (l1, l2) = list.tail.partition(_ < list.head)
    if (l2.size == k - 1) list.head :: l2 ::: suffix
    else if (l2.size > k - 1) f(l2, k, Nil)
    else f(l1, k - l2.size - 1, list.head :: l2)
  }
}

