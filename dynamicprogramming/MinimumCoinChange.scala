package dynamicprogramming
/*
* Given a amount ‘A’ and n coins,   v1<v2<v3<………..<vn .
 * Write a program to find out minimum numbers
* of coins required to make the change for the amount ‘A’.*/
object MinimumCoinChange extends App {
  //println(minCoins(List(1,2,3), 5))
  println(minCoins(List(1, 75, 40), 80))
  def minCoins(coins: List[Int], change: Int): Int = {
    if (coins.isEmpty) 0
    else if (change == 0) 0
    //check if we can even take this coin?
    //else if (change < coins.head) minCoins(coins.tail, change)
    // else (1 + minCoins(coins, change - coins.head)) min minCoins(coins.tail, change)
    else {
      val all=coins
        .filter(_ > change)
        .map(coin => 1+minCoins(coins, change - coin))
      if(all.isEmpty) 1 else all.min

    }
  }
}
