package dsalgo.algorithm.recursion

import scala.collection.mutable.ListBuffer
object PermutationsWithDups extends App {
  //println( permutation("ab"))
  "".head
  val buffer = new ListBuffer[String]()
  /*
    def insertAtAllPositions(s: String, c: Char): List[String] = {
      val buffer = new ListBuffer[String]()
      buffer += c + s
      for (i <- 0 to s.length - 1) {
        buffer += s.substring(0, i) + c + s.substring(i)
      }
      buffer.toList
    }

    def perm(s: String): List[String] = {
      val buffer = new ListBuffer[String]()
      if (s.size == 1) {
        buffer += s
        return buffer.toList
      }
      else {
        val c = s.charAt(0)
        val remainder = s.substring(1)
        val remainderPerms = perm(remainder)
        remainderPerms
            .foreach(perm=>)
        remainder.foreach {
          item => insertAtAllPositions(item, c)
        }

      }
      buffer.toList
    }*/
  /*  def permutation(s: String): List[String] = {

      if (s.length() == 1) List(s)
      else
        permutation(s.substring(0, s.length - 1))
          .flatMap { fisrtPartOfString =>
          insertCharInSubstring(fisrtPartOfString, s.charAt(s.length - 1))
        }
    }
    def insertCharInSubstring(s: String, c: Char): Seq[String] =
      for (i <- 0 to s.length) yield
        s.substring(0, i) + c + s.substring(i, s.length)*/
}
