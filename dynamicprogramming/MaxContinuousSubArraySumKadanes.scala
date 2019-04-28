package dynamicprogramming
object MaxContinuousSubArraySumKadanes extends App {
  assert(f(Array(-2, -3, 4, -1, -2, 1, 5, -3)) == 7)
  assert(f(Array(-2, -3, 1, -1, -2, 1, 5, -3)) == 6)
  assert(f1(Array(-2, -3, 4, -1, -2, 1, 5, -3), Integer.MIN_VALUE, Integer.MIN_VALUE) == 7)
  def f(a: Array[Int]): Int = {
    var currentMax = Integer.MIN_VALUE
    var totalMax = Integer.MIN_VALUE
    for (i <- 0 to a.length - 1) {
      currentMax = (0 max currentMax) + a(i)
      totalMax = currentMax max totalMax
    }
    totalMax
  }
  def f1(a: Array[Int], localMax: Int, globalMax: Int): Int = {
    if (a.isEmpty) globalMax
    else {
      val temp = (0 max localMax) + a.head
      f1(a.tail, temp, temp max globalMax)
    }
  }
}
