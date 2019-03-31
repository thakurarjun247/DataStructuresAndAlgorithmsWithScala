package recursion.dp

;
object LongestIncreasingSubsequenceContiguousKadanesAlgo extends App {
  println(f(Array(5, -9, 6 - 2, 3)))
  def f(a: Array[Int]): Int = {
    f1(a, 0, 0)
  }
  def f1(a: Array[Int], maxSum: Int, sum: Int): Int = {
    if (a.isEmpty) 0
    else {
      val newSum = sum + a.head
      if (newSum > maxSum) f1(a.tail, sum + newSum, newSum)
      else if (sum < 0) f1(a.tail, maxSum, 0)
      else f1(a.tail, maxSum, sum)
    }
  }
  //print("expected 7 actual is ")
 // println(maxSumInNonContinuousSubarray(Array(-2, -3, 4, -1, -2, 1, 5, -3)))
  /*
  Just sums the positive numbers, worthless  */
  def maxSumInNonContinuousSubarray(a: Array[Int]): Int = {
    if (a.length == 0) return 0
    var sum = a(0)
    var tempSum = a(0)
    for (i <- 1 to a.length - 1) {
      tempSum = Integer.max(sum + a(i), a(i))
      if (tempSum > sum) sum = tempSum
    }
    sum
  }
}
