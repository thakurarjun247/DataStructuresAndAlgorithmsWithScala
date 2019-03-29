package recursion.dp
import java.util.Calendar
import scala.collection.mutable
object RodCutting extends App {
  //Note: LCS=longestCommonSubsequence
  val a = Calendar.getInstance().getTimeInMillis
  println("length = " + getLCSWithoutMemo("abcasdfsadfsdlkjweoiu098", "asdfbcuyrlkj"))
  println("length = " + getLCSWithoutMemo("ab234527766578c", "asdfc09823459802345lkjb"))
  val b = Calendar.getInstance().getTimeInMillis
  println("length = " + getLCSWithMemo("AGGTAB", "GXTXAYB"))
  println("length = " + getLCSWithMemo("ab234527766578c", "asdfc09823459802345lkjb"))
  val c = Calendar.getInstance().getTimeInMillis
  println(b - a, c - b)
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

