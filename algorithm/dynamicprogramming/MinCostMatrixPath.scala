package algorithm.dynamicprogramming
import scala.collection.mutable.Map
object MinCostMatrixPath {
  def main(args: Array[String]): Unit = {
    val a = Array(Array(1, 21, 3),
      Array(4, 8, 2),
      Array(1, 5, 3))
    val b = Array(Array(1, 21, 3))
    val c = Array(Array(1), Array(2), Array(3))
    println(s" ${f(a)} ${f(b)} ${f(c)}")
  }
  def f(a: Array[Array[Int]]): Int = {
    implicit val memo: Map[(Int, Int), Int] = Map()
    val m = a.size
    val n = if (m == 0) 0 else a(0).size
    f(a, m - 1, n - 1)
  }
  def f(a: Array[Array[Int]], m: Int, n: Int)(implicit memo: Map[(Int, Int), Int]): Int = {
    if (m == 0 && n == 0) a(0)(0) // or a(m)(n)
    else {
      if (!memo.contains(m, n)) {
        val value = a(m)(n) + {
          if (m == 0) f(a, m, n - 1)
          else if (n == 0) f(a, m - 1, n)
          else (f(a, m - 1, n - 1) min f(a, m, n - 1) min f(a, m - 1, n))
        }
        memo += (m, n) -> value
      }
      memo(m, n)
    }
  }
}
