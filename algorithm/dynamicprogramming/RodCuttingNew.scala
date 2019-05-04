package algorithm.dynamicprogramming
import scala.collection.mutable.Map
/*
Given a rod of length n inches and an array of prices that contains
prices of all pieces of size smaller than n.
 Determine the maximum value obtainable by cutting up the rod and
  selling the pieces. For example, if length of the rod is 8 and the
  values of different pieces are given as following, then the maximum obtainable value
   is 22 (by cutting in two pieces of lengths 2 and 6)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

And if the prices are as following, then the maximum obtainable value
 is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
 */
object RodCuttingNew extends App {
  val l = Array(1, 2, 3, 4, 5, 6, 7, 8)
  val p1 = Array(1, 5, 8, 9, 10, 17, 17, 20)
  val p2 = Array(3, 5, 8, 9, 10, 17, 17, 20)
  val len = 8
  val len3 = 4
  val l3 = Array(1, 2, 3, 4)
  val p3 = Array(1, 5, 8, 9)
  assert(fMemo(l, p2, len, Map()) == 24)
  assert(fMemo(l, p1, len, Map()) == 22) //22
  assert(fMemo(l3, p3, len3, Map()) == 10) //10
  assert(fMemoNew(l, p2, len) == 24)
  assert(fMemoNew(l, p1, len) == 22) //22
  assert(fMemoNew(l3, p3, len3) == 10) //10
  def fNoMemo(l: Array[Int], p: Array[Int], len: Int): Int = {
    if (len == 0 || l.isEmpty || p.isEmpty) 0
    else {
      //leave it
      if (l.head > len) fNoMemo(l.tail, p.tail, len)
      //max of takeIt, leaveIt
      else fNoMemo(l.tail, p.tail, len) max p.head + fNoMemo(l, p, len - l.head)
    }
  }
  /*optimize: Just use an array for memo, where array length = len+1
 optimize:  a(0)=0 intialize the array with MIN_VALUE*/
  def fMemo(l: Array[Int], p: Array[Int], len: Int, memo: Map[(Int, Int), Int]): Int = {
    if (len == 0 || l.isEmpty || p.isEmpty) 0
    else if (memo.contains(l.length, len)) {
      println(s"Yay found in memo: ${l.length}, $len  ${memo(l.length, len)}")
      memo(l.length, len)
    }
    else {
      //leave it
      val value = if (l.head > len) fMemo(l.tail, p.tail, len, memo)
      //max of takeIt, leaveIt
      else fMemo(l.tail, p.tail, len, memo) max p.head + fMemo(l, p, len - l.head, memo)
      memo += (l.length, len) -> value
      memo(l.length, len)
    }
  }
  def fMemoNew(l: Array[Int], p: Array[Int], len: Int): Int = {
    val memo = Array.fill(len + 1)(Integer.MIN_VALUE)
    fMemoNew(l, p, len, memo)
  }
  def fMemoNew(l: Array[Int], p: Array[Int], len: Int, memo: Array[Int]): Int = {
    if (len == 0 || l.isEmpty || p.isEmpty) 0
    else {
      if (memo(len) == Integer.MIN_VALUE) {
        val maxRevenue = if (l.head > len) fMemoNew(l.tail, p.tail, len, memo)
        else {
          val takeIt = p.head + fMemoNew(l, p, len - l.head, memo)
          val leaveIt = fMemoNew(l.tail, p.tail, len, memo)
          leaveIt max takeIt
        }
        memo(len) = maxRevenue
        maxRevenue
      }
      else memo(len)
    }
  }
}
