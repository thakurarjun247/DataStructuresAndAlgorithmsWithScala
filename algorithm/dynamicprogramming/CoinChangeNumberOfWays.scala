package algorithm.dynamicprogramming
import scala.collection.mutable.Map
/**
  * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
  * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
  */
object CoinChangeNumberOfWays extends App {
  assert(fNoMemo(3, List(2, 3, 5, 1)) == 3)
  assert(fMemo(List(2, 3, 5, 1), 3, Map()) == 3)
  def fNoMemo(money: Int, coins: List[Int]): Int = {
    //fMemo is easier to understand
    if (money == 0)
      1
    else if (money > 0 && !coins.isEmpty)
      fNoMemo(money - coins.head, coins) + fNoMemo(money, coins.tail)
    else
      0
  }
  def fMemo(coins: List[Int], amount: Int, memo: Map[(Int, Int), Int]): Int = {
    //If the amount becomes 0 i.e. we have successfully chosen some
    //coins and made the change, i.e. num of ways to make change is 1
    if (amount == 0) 1
    //no coins, can't make any change
    else if (coins.isEmpty) 0
    else {
      if (!memo.contains((coins.length, amount))) {
        val value = if (amount < coins.head) fMemo(coins.tail, amount, memo)
        else fMemo(coins, amount - coins.head, memo) + fMemo(coins.tail, amount, memo)
        memo += (coins.length, amount) -> value
      }
      memo((coins.length, amount))
    }
  }
}
