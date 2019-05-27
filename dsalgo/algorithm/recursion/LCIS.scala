package dsalgo.algorithm.recursion

object LCIS extends App {
  //LCIS=LongestContinuousIncreasingSubsequence
  assert(fOld(Array(5, -9, 6, -2, 3, 4)) == 3)
  assert(fOld(Array(0, 2, 3, -1, 0, 1, 2, 3, 4, 5, -4, -3, -2)) == 7)
  assert(fNew(Array(5, -9, 6, -2, 3, 4).toList) == 3)
  assert(fNew(Array(0, 2, 3, -1, 0, 1, 2, 3, 4, 5, -4, -3, -2).toList) == 7)
  def fNew(list: List[Int]): Int = fNew(list, Integer.MIN_VALUE, 0, 0)
  def fNew(list: List[Int], last: Int, currentLen: Int, prevLen: Int): Int = {
    if (list.isEmpty) currentLen max prevLen
    else if (last < list.head) fNew(list.tail, list.head, currentLen + 1, prevLen)
    else fNew(list.tail, list.head, 1, currentLen max prevLen)
  }
  def fOld(a: Array[Int]): Int = fOld(a.toList, Integer.MIN_VALUE, 0)
  def fOld(list: List[Int], last: Int, len: Int): Int = {
    list match {
      case Nil => len
      case head :: tail =>
        //if last element is smaller than current element
        //yay we are on a CIS
        // pass the remaining list to recursion call
        //make current item the last/pre item for next rec call
        //add one to len
        if (last <= head)
          fOld(tail, head, len + 1)
        else {
          //else The last CIS is over
          //We need to do two things
          //1. start finding the next CIS
          //2. choose the max (length of current CIS i.e. len, result of step 1)
          len max
            fOld(tail, head, 1)
        }
    }
  }
}
