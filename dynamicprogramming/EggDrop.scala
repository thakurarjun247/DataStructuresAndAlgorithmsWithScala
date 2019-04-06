package dynamicprogramming
/**
  * There are n number of eggs and building
  * which has k floors. Write an algorithm to find the
  * minimum number of drops is required to know
  * the floor from which if egg is dropped, it will break.
  * Problem statement: You are given N floor and K eggs.
  * You have to minimize the number of times you have to drop the eggs to find the critical floor
  * where critical floor means the floor beyond which eggs start to break
  */
//https://www.includehelp.com/algorithms/egg-dropping-problem-using-dynamic-programming.aspx
//Video: https://www.youtube.com/watch?v=o_AJ3VWQMzA
//Code: https://github.com/gkcs/Competitive-Programming/blob/master/src/main/java/main/java/videos/EggSolver.java
object EggDrop extends App {
  print((1 to 5).toList.map(x=>x*x).min)
  //n floor, e num of eggs
 // f(8,4)
  print(s"fun(8,4) ${fun(8,4)}")
  def f(floors: Int, eggs: Int): Unit = {
    val results = Array.ofDim[Int](floors + 1, eggs + 1)
    //if we have only 1 egg we will need to start from the ground floor
    //hence in worst case number of drops will be equal to number of floors
    for (floor <- 0 to floors) results(floor)(1) = floor
    //if there is only one floor, number of drops will be 1 irrespective of the number of
    //eggs we got.
    for (egg <- 0 to eggs) results(1)(egg) = 1
    for (floor <- 2 to floors)
      for (egg <- 2 to eggs) {
        results(floor)(egg) = Integer.MAX_VALUE
        for (eggThrownFloor <- 1 to (floor - 1)) {
          //Lets see the cases when we throw and egg off floor eggThrownFloor

          //subtract 1 from egg as we broke it, now
          //we only need to look beneath the floor #x i.e.
          val brokenEggResult = results(eggThrownFloor - 1)(egg - 1)
          val eggSurvivedResult = results(floor - eggThrownFloor)(egg);
          //add 1 as in either case we made a try/attempt
          val temp = 1 + brokenEggResult max eggSurvivedResult
          if (temp < results(floor)(egg)) {
            results(floor)(egg) = temp;
          }
        }
      }
    var x=results.toList.map(r=>r.toList)
    x.foreach(r => {
      println()
      r.foreach(c => print(" " + c))
    })
  }

  def fun(n:Int, e:Int):Int={

    if(n==1) return 1
    else if(e==1) n
    else
      (2 to n)
      .toList
        .map(x => 1 + (fun(n - x, e) max fun(x - 1, e - 1)))
        .min
  }
}
