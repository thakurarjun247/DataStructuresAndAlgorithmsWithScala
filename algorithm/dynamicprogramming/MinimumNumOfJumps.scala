package algorithm.dynamicprogramming
/*
Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.
Example:
Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 ->9)
First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.
 */
//It's not necessary to land on last element, you can jump over it :)
import scala.collection.mutable.Map
//fix it, blows when array has 0
object MinimumNumOfJumps extends App {
  implicit val memo = Map[Int, Int]()
  //assert(getMinJump(Array(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9))==3)
  //assert(getMinJump(Array(2, 3, 1, 1, 4))==2)
  // assert(fMemo(Array(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)) == 3)
  assert(fMemo(Array(2, 3, 1, 1, 4)) == 2)
  def fOld(a: Array[Int]): Int = fOld(a, 0, 0)
  def fOld(a: Array[Int], currentIndex: Int, count: Int): Int = {
    //stop if are you are going to jump out of bounds
    if (currentIndex > (a.length - 1))
      Integer.MAX_VALUE

    //if you can jump furuther get all the possible ways to jump and choose
    //the one that has min. jumps
    else if (currentIndex < (a.length - 1))
      (1 to a(currentIndex))
        .map(item => fOld(a, currentIndex + item, count + 1))
        .min
    //if you are exactly at the last step return the output
    else count
  }
  def fNoMemo(a: Array[Int]): Int = {
    if (a.size < 2) a.size
    else if (a.head >= a.size - 1) 1
    else {
      1 +
        (1 to a.head)
          .map(n => fNoMemo(a.slice(n, a.length - 1)))
          .min
    }
  }
  def fMemo(a: Array[Int])(implicit memo: Map[Int, Int]): Int = {
    if (a.size < 2) a.size
    else if (a.head >= a.size - 1) 1
    else {
      if (!memo.contains(a.size))
        memo += a.size -> (1 +
          (1 to a.head)
            .map(n => fMemo(a.slice(n, a.length - 1)))
            .min)
      memo(a.size)
    }
  }
}
