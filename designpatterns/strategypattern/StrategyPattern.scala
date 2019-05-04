package designpatterns.strategypattern
object StrategyPattern extends App {
  def mul(a: Int, b: Int) = a * b
  def add(a: Int, b: Int) = a + b
  def strategy(f: (Int, Int) => Int, a: Int, b: Int) = f(a, b)
  val addResult = strategy(add, 2, 3)
  val mulResult = strategy(mul, 2, 3)
  println(s"Scala $addResult $mulResult")
}

