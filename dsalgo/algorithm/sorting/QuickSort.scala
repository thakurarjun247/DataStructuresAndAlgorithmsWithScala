package dsalgo.algorithm.sorting

import scala.collection.mutable.ListBuffer
import scala.util.Random
object QuickSort extends App {
  val list: List[Int] = List.fill(5)(Random.nextInt(20))
  println(list)
  println(qsort(list))
  println(qsortNew(list))
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
  def qsortNew(list: List[Int]): List[Int] = {
    list match {
      case Nil => list
      case _ :: Nil => list
      case pivot :: tail => {
        val (less, greater) = myPartition(tail, pivot)
        qsortNew(less) ::: (pivot :: qsortNew(greater))
      }
    }
  }
  private def myPartition(list: List[Int], pivot: Int) = {
    val l1 = ListBuffer[Int]()
    val l2 = ListBuffer[Int]()
    list.foreach(item => (if (item < pivot) l1 else l2) += item)
    (l1.toList, l2.toList)
  }
  //todo make this old java style qsort work
  /* def quickSort(arr: Array[Int], left: Int, right: Int): Unit = {
     if (left >= right) { // can be left>right as well
       return
     }
     val pivot = arr((left + right) / 2)
     val index = partition(arr, left, right, pivot)
     quickSort(arr, left, index - 1)
     quickSort(arr, index, right)
   }
   private def partition(arr: Array[Int], l: Int, r: Int, pivot: Int) = {
     var left = l
     var right = r
     while (left <= right) { // can be left<right as well
       while (arr(left) < pivot) left += 1
       while (arr(right) > pivot ) right -= 1
       if (left <= right) {
         swap(arr, left, right)
         left += 1
         right -= 1
       }
     }
     left
   }
   private def swap(arr: Array[Int], left: Int, right: Int): Unit = {
     val temp = arr(left)
     arr(left) = arr(right)
     arr(right) = temp
   }
 */
}

