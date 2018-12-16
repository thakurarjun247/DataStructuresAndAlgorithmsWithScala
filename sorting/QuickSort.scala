package sorting

object QuickSort extends App {
  val list: List[Double] = List.fill(5)(math.random())
println(list)
  println(qsort(list))

  def qsort(list: List[Double]): List[Double] = {
    list match {
      case Nil => list
      case _:: Nil => list
      case pivot :: tail => {
        val (less, greater) = tail.partition(_ < pivot)
        qsort(less) ::: (pivot :: greater)
      }
    }
  }
}

