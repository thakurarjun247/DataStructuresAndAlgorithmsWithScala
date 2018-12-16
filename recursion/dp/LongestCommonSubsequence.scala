package recursion.dp

import scala.collection.mutable.ListBuffer

object LongestCommonSubsequence extends App{
val s1="02345"
  val s2="093454"
  //println(getLen(s1,s2))
  println(getSeq(s1,s2, new ListBuffer[Char]()))
  /* the method doesn't care if the subsequence is continuous or not
  for val s1="02345"
  val s2="093454"
  ans will be 4
   */
 def getLen(s1: String, s2: String): Int = {
    if (s1.length == 0 || s2.size == 0) 0
    else if (s1.charAt(0) == s2.charAt(0))
      1 + getLen(s1.substring(1), s2.substring(1))
    else Integer
      .max(getLen(s1, s2.substring(1)), getLen(s1.substring(1), s2))

  }

  def getSeq(s1: String, s2: String, list:ListBuffer[Char]): ListBuffer[Char] = {
    if (s1.length == 0 || s2.size == 0) new ListBuffer[Char]
    else if (s1.charAt(0) == s2.charAt(0))
      list++getSeq(s1.substring(1), s2.substring(1),list)

    else getLonger(getSeq(s1, s2.substring(1),list), getSeq(s1.substring(1), s2, list))

  }

  def getLonger(b1:ListBuffer[Char], b2:ListBuffer[Char])=if(b1.length>b2.length) b1 else b2


}
