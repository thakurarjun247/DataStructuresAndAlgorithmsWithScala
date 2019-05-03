package algorithm.sorting
object InsertionSort extends App {
  val a = Array(5, 2, 4, 6, 1, 3)
  inSort(a).foreach(print)
  def inSort(a: Array[Int]) = {
    for (j <- 1 to a.length - 1) {
      var i = j
      while (i > 0 && a(i) < a(i - 1)) {
        val key = a(i)
        a(i) = a(i - 1)
        a(i - 1) = key
        i = i - 1
      }
    }
    a
  }
  //not working.
  def insertionSort(a: Array[Int]) = {
    val n = a.size
    for (j <- 1 to n - 1) {
      for (i <- j to 1) {
        if (a(i) < a(i - 1)) {
          //swap
          val key = a(i)
          a(i) = a(i - 1)
          a(i - 1) = key
        }
      }
    }
    a
  }
}
