package algorithm.sorting
import scala.util.Random
object QuickSort extends App {
  val list: List[Int] = List.fill(5)(Random.nextInt(20))
  println(list)
  println(qsort(list))
  def qsort(list: List[Int]): List[Int] = {
    list match {
      case Nil => list
      case _ :: Nil => list
      case pivot :: tail => {
        val (less, greater) = tail.partition(_ < pivot)
        qsort(less) ::: (pivot :: qsort(greater))
      }
    }
  }
}

