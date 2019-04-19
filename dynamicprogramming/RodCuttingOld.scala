package dynamicprogramming
//TODO: refer to 'RodCuttingNew' the following program, this one seems obsolete

/*
Given a rod of length n inches and an array of prices that contains
prices of all pieces of size smaller than n.
 Determine the maximum value obtainable by cutting up the rod and
  selling the pieces. For example, if length of the rod is 8 and the
  values of different pieces are given as following, then the maximum obtainable value
   is 22 (by cutting in two pieces of lengths 2 and 6)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

And if the prices are as following, then the maximum obtainable value
 is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
 */
object RodCuttingOld extends App {
  //Note: LCS=longestCommonSubsequence
  println(rodCut(4, Array(0, 1, 5, 8, 9)))
  println(rodCutWithMemo(4, Array(0, 1, 5, 8, 9)))
  // TODO: make memo work
  def rodCutWithMemo(length: Int, prices: Array[Int]): Int = {
    //while filling the memo make sure that you don't fill
    //memo(0) with -1 or
    //meaning cut size 0 will have revenue -1
    //which is wrong
    val memo = Array.fill(prices.length)(-1)
    // memo(0)=0
    rodCutWithMemo(length, prices, memo)
  }
  def rodCutWithMemo(length: Int, prices: Array[Int], memo: Array[Int]): Int = {
    if (length == 0) 0
    else
      (1 to length)
        .map(cutSize => {
          if (memo(cutSize) == -1)
            memo(cutSize) = prices(cutSize) + rodCutWithMemo(length - cutSize, prices, memo)
          memo(cutSize)
        })
        .max
  }
  def rodCut(length: Int, prices: Array[Int]): Int = {
    if (length == 0) 0
    else
      (1 to length)
        .map(cutSize => prices(cutSize) + rodCut(length - cutSize, prices))
        .max
  }
}
