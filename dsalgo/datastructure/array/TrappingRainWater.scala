package dsalgo.datastructure.array
/*
Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Examples:
Input: arr[]   = {2, 0, 2}
Output: 2
Structure is like below
| |
|_|
We can trap 2 units of water in the middle gap.

Input: arr[]   = {3, 0, 0, 2, 0, 4}
Output: 10
Structure is like below
     |
|    |
|  | |
|__|_|
We can trap "3*2 units" of water between 3 an 2,
"1 unit" on top of bar 2 and "3 units" between 2
and 4.
 */
//tags Amazon Microsoft
object TrappingRainWater {
  def main(args: Array[String]): Unit = {
    assert(f(Array(3, 0, 0, 2, 0, 4))== 10)
   assert(f(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))== 6)

  }

  def f(a: Array[Int]): Int = {
    val maxRightItems = Array.fill(a.size)(0)
    val maxLeftItems = Array.fill(a.size)(0)
    var maxLeft = 0
    var maxRight = 0
    for (i <- 1 to a.size - 1) {
      maxLeft = a(i - 1) max maxLeft
      maxLeftItems(i) = maxLeft
      val j = a.size - 1 - i
      maxRight = a(j + 1) max maxRight
      maxRightItems(j) = maxRight
    }
    for (i <- 0 to a.size-1) {
      a(i) = ( (maxLeftItems(i) min maxRightItems(i)) - a(i)) max 0
    }
    a.sum
  }
}
