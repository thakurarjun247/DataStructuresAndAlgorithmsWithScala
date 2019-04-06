package dynamicprogramming

import scala.io.StdIn
object NthFibo extends App {
  //Print nth fibo number

  fibo()

  def fibo(): Unit = {
    println("enter i")
    val i = StdIn.readInt

    val a = Array.fill[Int](i + 1)(0)
    a(0) = 1
    a(1) = 1
    val ans = fibo(i, a)
    println(s"$i th fibo element = $ans")
  }

  def fibo(i: Int, a: Array[Int]): Int = {
    println(s"finding $i th element")
    // if (i == 0 || i == 1) return 1
    if (a(i) == 0) a(i) = fibo(i - 1, a) + fibo(i - 2, a)
    a(i)
  }
}
