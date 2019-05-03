package algorithm.recursion
object NumberPower extends App {
  assert(f(-2, 5) == -32)
  assert(f(-2, 6) == 64)
  assert(f(2, 5) == 32)
  assert(f(2, 6) == 64)
  assert(f(1, 5) == 1)
  import scala.annotation.tailrec
  @tailrec
  def f(n: Int, e: Int, result: Int): Int = {
    if (n == 1 || e == 0) 1 * result
    else if (e == 1) n * result
    else f(n, e - 1, result * n)
  }
  //doesn't handle negative exponents
  def f(n: Int, e: Int): Int = f(n, e, 1)
}

