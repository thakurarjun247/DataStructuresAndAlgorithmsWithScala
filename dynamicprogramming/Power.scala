package dynamicprogramming
import scala.collection.mutable.Map
object Power extends App {
  //hold x -> ans
    implicit val memo: Map[Int, Int] = Map()

  assert(f(2,5)==32)
  assert(f(2,6)==64)

  def f(e: Int, x: Int)(implicit memo: Map[Int, Int]): Int = {
    if (e < 2 || x == 1) e
    else if (x == 0) 1
    else {
      if (!memo.contains(x)) {
        val temp = f(e, x / 2)
        val ans = if (x % 2 == 0) temp * temp else e * temp * temp
        memo += x -> ans
      }
      memo(x)
    }
  }
}
