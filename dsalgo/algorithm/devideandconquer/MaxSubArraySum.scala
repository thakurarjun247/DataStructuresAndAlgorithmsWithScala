package dsalgo.algorithm.devideandconquer

/*
//refer https://www.youtube.com/watch?v=lPUhHmgrpik for master theorem
O(nLog(n))
space not sure, should be O(n) as mergesort is O(n) space for sure
 */
object MaxSubArraySum extends App {
  val a = Array(-1, 2, 3, -1, 3)
  println(findMaxSubArraySum(a))
  println(findMaxSubArraySum(Array(-2, -5, 6, -2, -3, 1, 5, -6)))
  /*
   returns a tuple (leftIndex, rightIndex, sumOfSubarray)
   */
  def findMaxSubArraySum(a: Array[Int]): (Int, Int, Int) = findMaxSubArraySum(a: Array[Int], 0, a.size - 1)
  private def findMaxCrossingSubarray(a: Array[Int], low: Int, mid: Int, high: Int) = {
    var leftSum = Integer.MIN_VALUE
    var sum = 0
    var maxLeft = mid
    for (i <- mid to low) {
      sum = sum + a(i)
      if (sum > leftSum) {
        leftSum = sum
        maxLeft = i
      }
    }
    var rightSum = Integer.MIN_VALUE
    sum = 0
    var maxRight = mid + 1
    for (j <- (mid + 1) to high) {
      sum = sum + a(j)
      if (sum > rightSum) {
        rightSum = sum
        maxRight = j
      }
    }
    val sumTotal = leftSum + rightSum
    (maxLeft, maxRight, sumTotal)
  }
  private def findMaxSubArraySum(a: Array[Int], low: Int, high: Int): (Int, Int, Int) = {
    if (high == low) (low, high, a(low))
    else {
      val mid = (low + high) / 2
      val (leftLow, leftHigh, leftSum) = findMaxSubArraySum(a, low, mid)
      val (rightLow, rightHigh, rightSum) = findMaxSubArraySum(a, mid + 1, high)
      val (crossLow, crossHigh, crossSum) = findMaxCrossingSubarray(a, low, mid, high)
      if ((leftSum >= crossSum) && (leftSum >= rightSum)) (leftLow, leftHigh, leftSum)
      else if ((crossSum > leftSum) && (crossSum >= rightSum)) (crossLow, crossHigh, crossSum)
      else (rightLow, rightHigh, rightSum)
    }
  }
}
