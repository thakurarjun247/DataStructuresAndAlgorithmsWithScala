package dsalgo.algorithm.dynamicprogramming

object LongestIncreasingSubsequenceNonContiguous extends App {
  //assert(fMemo(List(11, 500, 6, 2, 5, 8)) == 3)
  println(fMemo(List(11, 500, 6, 2, 5, 8)))
  println(fWithoutMemo(List(11, 500, 6, 2, 5, 8)))
  /*  assert(fMemo(List(2, 5, 1, 8, 3)) == 3)
    assert(fMemo(List(2, 5, 1, 8, 3, -4, -3, -2, 0, -1)) == 4)
    assert(fMemo(List()) == 0)
    assert(fMemo(List(3, 4, -1, 0, 6, 2, 3)) == 4)*/

  def fMemo(list: List[Int]): (Int, List[Int]) = fMemo(list, Integer.MIN_VALUE, 0, List())
  def fMemo(list: List[Int], last: Int, length: Int, lis: List[Int]): (Int, List[Int]) = {
    if (list.isEmpty) (length, lis)
    else {
      if (list.head >= last) fMemo(list.tail, list.head, length + 1, list.head :: lis)
      else {
        val takeIt = fMemo(list.tail, list.head, 1, List(list.head))
        val leaveIt = fMemo(list.tail, last, length, lis)
        if (takeIt._1 > leaveIt._1) takeIt else leaveIt
      }
    }
  }
  def fWithoutMemo(list: List[Int]): Int = fWithoutMemo(list, Integer.MIN_VALUE, 0)
  def fWithoutMemo(list: List[Int], last: Int, length: Int): Int = {
    if (list.isEmpty) length
    else {
      //consider the current item i.e. head of list
      // LIS (with current item)
      // while including LIS in our LIS, we have two cases
      //if currentItem > lastItem we have will add 1 to length of existing LIS
      //if currentItem< lastItem we will create a new LIS so it's length will be reset to 1
      //use existing LIS and add current item to it
      (if (list.head >= last) fWithoutMemo(list.tail, list.head, length + 1)
      else
      //new LIS with first item as current item in it, i.e. drop old lis and startOver
        fWithoutMemo(list.tail, list.head, 1)) max
        //LIS(without current item), continue with old lis and ignore current item
        fWithoutMemo(list.tail, last, length)
      //return max of above two
    }
  }
}

