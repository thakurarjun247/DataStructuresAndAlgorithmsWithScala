package recursion.dp

import scala.io.StdIn

/*
* : A child is running up a staircase with n steps and can hop either
 * 1 step, 2 steps, or 3 steps at a time. Implement a method to count
 * how many possible ways the child can run up the stairs.
 */
object NthStep extends App {
  println("enter number of steps")
  val n = StdIn.readInt
  hop(n)

  //1 to 5 foreach(num=> hop(num))

  def hop(n: Int): Unit = {
    val a = Array.fill[Int](n + 1)(-1)
    a(0) = 1
    val ans = hop(n, a)
    println(s" n=$n ans=$ans")

  }

  def hop(n: Int, a: Array[Int]): Int = {
    // println(s"computing $n th step...")
    if (n < 0) return 0
    if (a(n) < 0) a(n) = hop(n - 1, a) + hop(n - 2, a) + hop(n - 3, a)
    a(n)
  }


}
