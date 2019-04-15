package dynamicprogramming
import scala.collection.mutable.Map
/*
* Given a amount ‘A’ and n coins,   v1<v2<v3<………..<vn .
 * Write a program to find out minimum numbers
* of coins required to make the change for the amount ‘A’.*/
//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java
object MinimumCoinChange extends App {
  println(f(Array(1, 75, 40), 80))
  println(fMemoReady(Array(1, 75, 40), 80))
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
  def fMemoReady(coins: Array[Int], amount: Int): Int = {
    if (amount == 0) 0
    else if (coins.isEmpty) Integer.MAX_VALUE - 10000 //adding something to max val wil overflow
    //leave it
    else if (amount < coins.head) fMemoReady(coins.tail, amount)
    //take it
    else if (amount == coins.head) 1
    //take it or leave it
    else (1 + fMemoReady(coins, amount - coins.head)) min fMemoReady(coins.tail, amount)
  }
}
