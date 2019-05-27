package dsalgo.datastructure.arraystring
object ArrayItemsWithGivenSum {
  val a = Array(2, 5, -1, 4, 9)
  val b = Array(6, 2, -8, -3, 4)
  def main(args: Array[String]): Unit = {
    for(x <- a.indices)
      println(x, a(x), x+1)
  //  println(fUsingSorting(a, 14))
  //    println(fUsingSorting(a, 99))
    println("done")
  }
  def fUsingSorting(unsorted: Array[Int], sum: Int): (Int, Int) = {
    val a = unsorted.sortWith(_ < _)
    var l = 0
    var r = a.size - 1
    while (l < r) {
      val x = a(l)
      val y = a(r)
      if (x + y == sum) return (x, y)
      if (x + y > sum) r = r - 1
      if (x + y < sum) l = l + 1
    }
    println("not found")
    (-1, -1)
  }
}
