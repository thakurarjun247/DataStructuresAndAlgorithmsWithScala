package dynamicprogramming
object LongestIncreasingSubsequenceNonContiguous extends App {
  assert(f(List(2, 5, 1, 8, 3)) == 3)
  assert(f(List()) == 0)
  assert(f(List(3, 4, -1, 0, 6, 2, 3)) == 4)
  def f(list: List[Int]): Int = f(list, Integer.MIN_VALUE, 0)
  def f(list: List[Int], last: Int, length: Int): Int = {
    if (list.isEmpty) length
    else {
      //consider the current item i.e. head of list
      // LIS (with current item)
      // while including LIS in our LIS, we have two cases
      //if currentItem > lastItem we have will add 1 to length of existing LIS
      //if currentItem< lastItem we will create a new LIS so it's length will be reset to 1
      (if (list.head >= last) f(list.tail, list.head, length + 1) else f(list.tail, list.head, 1)) max
        //LIS(without current item)
        f(list.tail, last, length)
      ////return max of above two
    }
  }
}

