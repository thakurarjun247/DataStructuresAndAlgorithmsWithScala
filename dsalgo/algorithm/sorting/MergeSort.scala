package dsalgo.algorithm.sorting

import scala.util.Random
/*
Time O(nlogn)
Space O(n)
 */
object MergeSort extends App {
  val list = List.fill(7)(Random.nextInt(20))
  println(list)
  println(mergesort(list))
  def merge(l1: List[Int], l2: List[Int]): List[Int] = (l1, l2) match {
    case (l1, Nil) => l1
    case (Nil, l2) => l2
    case (h1 :: t1, h2 :: t2) => if (h1 < h2) h1 :: merge(t1, l2) else h2 :: merge(l1, t2)
  }
  def mergesort(list: List[Int]): List[Int] = list match {
    case Nil => list
    case h :: Nil => list
    case _ => {
      val mid = list.size / 2
      val (l1, l2) = list.splitAt(mid)
      merge(mergesort(l1), mergesort(l2))
    }
  }
}
