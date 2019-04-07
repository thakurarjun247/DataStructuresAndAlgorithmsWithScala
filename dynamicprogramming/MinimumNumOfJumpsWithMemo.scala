package dynamicprogramming
/**
  * Given an array of integers where each element represents the
  * max number of steps that can be made forward from that element.
  * Write a function to return the minimum number of jumps to reach
  * the end of the array (starting from the first element).
  * If an element is 0, then cannot move through that element.
  */

object MinimumNumOfJumpsWithMemo extends App {
  println(getMinJump(Array(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)))
  println(getMinJump(Array(2, 3, 1, 1, 4)))
  //val arr=Array.fill(a.length)(-1)
  //arr.foreach(print)

  def getMinJump(a: Array[Int]): Int = getMinJump(a, 0, 0, Array.fill(a.length)(-1))

  def getMinJump(a: Array[Int], currentIndex: Int, count: Int, memo: Array[Int]): Int = {
    if(memo(currentIndex)!=(-1)) memo(currentIndex)
    else memo(currentIndex)=
    //stop if are you are going to jump out of bounds
    if (currentIndex > (a.length - 1))
      Integer.MAX_VALUE

      //if you can jump furuther get all the possible ways to jump and choose
    //the one that has min. jumps
    else if (currentIndex < (a.length - 1))
      (1 to a(currentIndex))
        .map(item => getMinJump(a, currentIndex + item, count + 1, memo))
        .min
    //if you are exactly at the last step return the output
    else count
   memo(currentIndex)

  }
}
