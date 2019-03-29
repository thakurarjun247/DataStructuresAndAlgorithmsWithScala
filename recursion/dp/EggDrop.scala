package recursion.dp
/**
  * There are n number of eggs and building
  * which has k floors. Write an algorithm to find the
  * minimum number of drops is required to know
  * the floor from which if egg is dropped, it will break.
  */

//Video: https://www.youtube.com/watch?v=o_AJ3VWQMzA
//Code: https://github.com/gkcs/Competitive-Programming/blob/master/src/main/java/main/java/videos/EggSolver.java
object EggDrop extends App {
  //n floor, e num of eggs
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
        for (eggThrownFloor <- 1 to floor - 1) {
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
  }
}
