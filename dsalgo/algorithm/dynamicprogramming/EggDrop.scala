package dsalgo.algorithm.dynamicprogramming

/**
  * There are e number of eggs and building
  * which has n floors. Write an algorithm to find the
  * minimum number of drops/tries is required to know
  * the floor from which if egg is dropped, it will break.
  * Problem statement: You are given N floor and K eggs.
  * You have to minimize the number of times you have to drop the eggs to find the critical floor
  * where critical floor means the floor beyond which eggs start to break
  */
//https://www.includehelp.com/algorithms/egg-dropping-problem-using-dynamic-programming.aspx
//Video: https://www.youtube.com/watch?v=o_AJ3VWQMzA
//Code: https://github.com/gkcs/Competitive-Programming/blob/master/src/main/java/main/java/videos/EggSolver.java
object EggDrop extends App {
  def f(n: Int, e: Int): Int = {
    require(n > 0 && e > 0)
    if (n == 1) 1
    else if (e == 1) n
    else {
      val broken = f(n - 1, e - 1)
      val survived = f(n - 0, e)
    }
    0
  }
}
