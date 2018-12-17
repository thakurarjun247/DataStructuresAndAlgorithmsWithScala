package sorting

import scala.util.Random


object HighLowAlternating { // Utility function to swap two elements A[i] and A[j] in the array
  private def swap(A: Array[Int], i: Int, j: Int): Unit = {
    val temp = A(i)
    A(i) = A(j)
    A(j) = temp
  }

  // Function to rearrange the array such that every second element
  // of the array is greater than its left and right elements
  def rearrangeArray(a: Array[Int]): Unit = { // start from second element and increment index
    // by 2 for each iteration of loop
    var i = 1
    while ( {
      i < a.length
    }) { // If the prev element is greater than current element,
      // swap the elements
      if (a(i - 1) > a(i)) swap(a, i - 1, i)
      // if next element is greater than current element,
      if (i + 1 < a.length && a(i + 1) > a(i)) swap(a, i + 1, i)

      i += 2
    }
  }

  // main function
  def main(args: Array[String]): Unit = {
    val a = Array(1,2,3,4)
    a.foreach(i=> println(" "+i))
    rearrangeArray(a)
    // print output array
    a.foreach(i=> print(" "+i))
  }
}
