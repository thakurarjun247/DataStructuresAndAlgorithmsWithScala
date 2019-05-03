package algorithm.sorting
object BubbleSort extends App {
  bubbleSort(Array(5, 2, 6, 4)).foreach(print)
  //assert( bubbleSort(Array(5, 2, 6, 4)) == Array(2, 4, 5, 6))
  def bubbleSort(a: Array[Int]) = {
    for (i <- 0 to a.size - 2) {
      for (j <- 0 to a.size - 2 - i) {
        if (a(j + 1) < a(j)) {
          val temp = a(j + 1)
          a(j + 1) = a(j)
          a(j) = temp
        }
      }
    }
    a
  }
}