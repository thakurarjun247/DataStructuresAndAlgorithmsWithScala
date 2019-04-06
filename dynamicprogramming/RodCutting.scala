package dynamicprogramming
object RodCutting extends App {
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
