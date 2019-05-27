package dsalgo.algorithm.recursion

import scala.collection.mutable.Map
object Factorial extends App {
  assert(fNoMemo(5) == 120)
  assert(fMemo(5, Map()) == 120)
  def fNoMemo(n: Int): Int = if (n == 0 || n == 1) 1 else n * fNoMemo(n - 1)
  def fMemo(n: Int, memo: Map[Int, Int]): Int =
    if (n == 0 || n == 1) 1
    else {
      if (memo.contains(n)) {
        println(s"Yay found fact($n) in memo")
        memo(n)
        //
      }
      memo += n -> n * fMemo(n - 1, memo)
      memo(n)
    }
}
