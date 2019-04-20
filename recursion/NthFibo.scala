package recursion
object NthFibo extends App {
  //Print nth fibo number
  print(fibo(10))
  def fibo(n: Int): Unit = {
    val a = Array.fill[Int](n + 1)(0)
    a(0) = 1
    a(1) = 1
    val ans = fibo(n, a)
    println(s"$n th fibo element = $ans")
  }
  def fibo(i: Int, a: Array[Int]): Int = {
    println(s"finding $i th element")
    // if (i == 0 || i == 1) return 1
    if (a(i) == 0) a(i) = fibo(i - 1, a) + fibo(i - 2, a)
    a(i)
  }
}
