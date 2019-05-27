package scala.functionalfeatures
object HigherOrderFunctions extends App {
  //syntax
  //<def/val> <funName> <:> <mappingType> <=> <param List with Type> < => > <body>
  val algo1: Int => Int = (x: Int) => x * 2
  //type is optional above :Int=>Int
  //can use def as well
  def algo2 = (x: Int) => x * 3
  val list = List(1, 2, 3, 4)
  val calculateRank = (list: List[Int], fun: Int => Int) => list.map(fun)
  println(list)
  println(calculateRank(list, algo1))
  println(calculateRank(list, algo2))
  //yet another example
  val intToString: Int => String = (x: Int) => x.toString
  def f(msg: String, f: Int => String): String = {
    msg + f(5)
  }
  println(f("hi", intToString))
}
