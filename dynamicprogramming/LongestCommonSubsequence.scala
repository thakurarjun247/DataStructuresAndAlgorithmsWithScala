package dynamicprogramming
import scala.collection._
import scala.collection.mutable._;
/*
the method doesn't care if the subsequence is continuous or not
for val s1="02345"
val s2="093454"
ans will be 4
*/
//TODO: Important always do null check on input string, good place to do is delegator method
//TODO: e.g.   def getLCSWithMemo(s1: String, s2: String): Int
object LongestCommonSubsequence extends App {
  val s1 = "02345"
  val s2 = "093454"
  val s3: String = null
  val s4 = ""
  val s5 = "abcd"
  //println(getLen(s1,s2))
  assert((fMemo(s5, s3) == 0))
  assert((fMemo(s5, s4) == 0))
  assert((fMemo(s3, s3) == 0))
  assert(fMemo(s1, s2) == 4)
  assert(fNoMemo(s1, s2) == 4)
  //Yay Working :)  functions getLCSWithMemo and getLCSWithoutMemo are working
  import scala.collection.mutable._
  def fMemo(s1: String, s2: String): Int = if (s1 == null || s2 == null) 0 else fMemo(s1, s2, mutable.Map[(String, String), Int]())
  def fMemo(s1: String, s2: String, memo: mutable.Map[(String, String), Int]): Int = {
    if (s1.isEmpty || s2.isEmpty) 0
    else {
      if (memo.get(s1, s2).isEmpty) {
        val s1s2LCSLength =
          if (s1.head == s2.head) 1 + fMemo(s1.tail, s2.tail, memo)
          else {
            fMemo(s1.tail, s2, memo) max fMemo(s1, s2.tail, memo)
          }
        memo += ((s1, s2) -> s1s2LCSLength)
      }
      memo.get(s1, s2).get
    }
  }
   def fNoMemo(s1: String, s2: String): Int = {
    if (s1.isEmpty || s2.isEmpty) 0
    else {
      if (s1.head == s2.head)
        1 + fNoMemo(s1.tail, s2.tail)
      else
        fNoMemo(s1.tail, s2) max fNoMemo(s1, s2.tail)
    }
  }
  /*
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
*/
}
