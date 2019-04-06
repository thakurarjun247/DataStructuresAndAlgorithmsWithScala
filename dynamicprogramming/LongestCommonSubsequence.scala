package dynamicprogramming

import scala.collection._
import scala.collection.mutable._;
object LongestCommonSubsequence extends App {
  val s1 = "02345"
  val s2 = "093454"
  //println(getLen(s1,s2))
  println(getSeq(s1, s2, new ListBuffer[Char]()))
  /* the method doesn't care if the subsequence is continuous or not
  for val s1="02345"
  val s2="093454"
  ans will be 4
   */
  //Yay Working :)  functions getLCSWithMemo and getLCSWithoutMemo are working
  import scala.collection.mutable._
  def getLCSWithMemo(s1: String, s2: String): Int = getLCSWithMemo(s1, s2, mutable.Map[(String, String), Int]())
  def getLCSWithMemo(s1: String, s2: String, memo: mutable.Map[(String, String), Int]): Int = {
    if (s1.isEmpty || s2.isEmpty) 0
    else {
      if (memo.get(s1, s2).isEmpty) {
        val s1s2LCSLength =
          if (s1.head == s2.head) 1 + getLCSWithMemo(s1.tail, s2.tail, memo)
          else {
            getLCSWithMemo(s1.tail, s2, memo) max getLCSWithMemo(s1, s2.tail, memo)
          }
        memo += ((s1, s2) -> s1s2LCSLength)
      }
      memo.get(s1, s2).get
    }
  }
  def getLCSWithoutMemo(s1: String, s2: String): Int = {
    if (s1.isEmpty || s2.isEmpty) 0
    else {
      if (s1.head == s2.head)
        1 + getLCSWithoutMemo(s1.tail, s2.tail)
      else
        getLCSWithoutMemo(s1.tail, s2) max getLCSWithoutMemo(s1, s2.tail)
    }
  }
  def getLen(s1: String, s2: String): Int = {
    if (s1.length == 0 || s2.size == 0) 0
    else if (s1.charAt(0) == s2.charAt(0))
      1 + getLen(s1.substring(1), s2.substring(1))
    else Integer
      .max(getLen(s1, s2.substring(1)), getLen(s1.substring(1), s2))
  }
  def getSeq(s1: String, s2: String, list: ListBuffer[Char]): ListBuffer[Char] = {
    if (s1.length == 0 || s2.size == 0) new ListBuffer[Char]
    else if (s1.charAt(0) == s2.charAt(0))
      list ++ getSeq(s1.substring(1), s2.substring(1), list)
    else getLonger(getSeq(s1, s2.substring(1), list), getSeq(s1.substring(1), s2, list))
  }
  def getLonger(b1: ListBuffer[Char], b2: ListBuffer[Char]) = if (b1.length > b2.length) b1 else b2
}
