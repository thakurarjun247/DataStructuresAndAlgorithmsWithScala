package dynamicprogramming

import scala.collection.mutable.ListBuffer
object PermutationsUniqueChars extends App {
  val list = new ListBuffer[String]()
  println(perm("123").groupBy(_.charAt(0)))
  def perm(s: String /*, list: ListBuffer[String]*/): List[String] = {
    val list = new ListBuffer[String]()
    if (s.isEmpty) list.toList
    else if (s.length() == 1) List(s)
    else {
      perm(s.tail)
        .foreach {
          tailPerm =>
            putAtAllFunctional(s.head, tailPerm)
              .foreach(put => list += put)
        }
      list.toList
    }
  }
  def putAtAllFunctional(c: Char, s: String): Seq[String] =
    for (i <- 0 to s.length)
      yield
        s.substring(0, i) + c + s.substring(i)
}
