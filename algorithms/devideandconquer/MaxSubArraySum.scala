package algorithms.devideandconquer
//CLRS page 71
// TODO: make this solution work, here is java code https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/

object MaxSubArraySum extends App {
  def findMaxCrossingSubarray(a: Array[Int], low: Int, mid: Int, high: Int) = {
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
    (maxLeft, maxRight, leftSum + rightSum)
  }

  val a=Array(-1, 2, 3, -1,3 )
  println(findMaxSubArraySum(a, 0, a.size-1))
  def findMaxSubArraySum(a: Array[Int], low: Int, high: Int): (Int, Int, Int) = {
    if (high == low) (low, high, a(low))
    else {
      var mid = (low + high) / 2
      val (leftLow, leftHigh, leftSum) = findMaxSubArraySum(a, low, mid)
      val (rightLow, rightHigh, rightSum) = findMaxSubArraySum(a, mid + 1, high)
      val (crossLow, crossHigh, crossSum) = findMaxCrossingSubarray(a, low, mid, high)
/*      (leftSum max crossSum max rightSum) match {
        case leftSum => (leftLow, leftHigh, leftSum)
        case rightSum => (rightLow, rightHigh, rightSum)
        case crossSum => (crossLow, crossHigh, crossSum)
      }*/
      if((leftSum > crossSum) && (leftSum >  rightSum)) (leftLow, leftHigh, leftSum)
      else if ((crossSum > leftSum) && (crossSum >  rightSum)) (crossLow, crossHigh, crossSum)
      else (rightLow, rightHigh, rightSum)


      }
    }

}


