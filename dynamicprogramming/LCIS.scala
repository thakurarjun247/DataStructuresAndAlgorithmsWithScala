package dynamicprogramming
object LCIS extends App {
  //LCIS=LongestContinuousIncreasingSubsequence
  assert(f(Array(5, -9, 6, -2, 3, 4)) == 3)
  assert(f(Array(0, 2, 3, -1, 0, 1, 2, 3, 4, 5, -4, -3, -2)) == 7)
  def f(a: Array[Int]) = f(a.toList, Integer.MIN_VALUE, 0)
  def f(list: List[Int], last: Int, len: Int): Int = {
    list match {
      case Nil => len
      case head :: tail =>
        //if last element is smaller than current element
        //yay we are on a CIS
        // pass the remaining list to recursion call
        //make current item the last/pre item for next rec call
        //add one to len
        if (last <= head)
          f(tail, head, len + 1)
        else {
          //else The last CIS is over
          //We need to do two things
          //1. start finding the next CIS
          //2. choose the max (length of current CIS i.e. len, result of step 1)
          len max
            f(tail, head, 1)
        }
    }
  }
}
