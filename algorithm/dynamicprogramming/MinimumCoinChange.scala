package algorithm.dynamicprogramming
import scala.collection.mutable.Map
/*
* Given a amount ‘A’ and n coins,   v1<v2<v3<………..<vn .
 * Write a program to find out minimum numbers
* of coins required to make the change for the amount ‘A’.*/
//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java
object MinimumCoinChange extends App {
  implicit val memo: Map[Int, Int] = Map()
  println(f(Array(1, 75, 40), 80))
  println(fMemo(Array(1, 75, 40), 80))
  //tail recursion: pass the variable into stack calls
  //in a case similar to coin change pass n i.e. num of coins to stack calls so that
  //we don't worry about doing 1+f(...) because it won't be
  //tail rec
  def f(coins: Array[Int], amount: Int): Int = {
    f(coins, amount, 0)
  }
  def f(coins: Array[Int], amount: Int, n: Int): Int = {
    if (amount == 0) n
    else if (coins.isEmpty) Integer.MAX_VALUE
    //leave it
    else if (amount < coins.head) f(coins.tail, amount, n)
    //take it
    else if (amount == coins.head) n + 1
    //take it or leave it
    else f(coins, amount - coins.head, n + 1) min f(coins.tail, amount, n)
  }
  //memoization: Do the opposite of above because we can't
  //memoize with a variable in f() argument
  def fMemo(coins: Array[Int], amount: Int)(implicit memo: Map[Int, Int]): Int = {
    if (amount == 0) return 0
    else if (coins.isEmpty) return Integer.MAX_VALUE
    if (!(memo.contains(coins.size))) {
      val value = if (coins.head > amount) fMemo(coins.tail, amount)
      else fMemo(coins.tail, amount) min (1 + fMemo(coins, amount - coins.head))
      memo += coins.length -> value
    }
    memo(coins.size)
  }
}
