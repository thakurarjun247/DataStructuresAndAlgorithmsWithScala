package recursion.dp

object CoinChange extends App{
  println(countChange(3,List(2,3,5,1)))
  def countChange(money: Int, coins: List[Int]): Int = {
    println(s" $money -> $coins")
    println("-------------------------------------")
    if(money == 0)
      1
    else if(money > 0 && !coins.isEmpty)
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else
      0
  }
}
