package datastructure.arraystring
//Find pivot in the sequence which is increasing & then decreasing.
object FindPivot extends App {
  println(iterative(Array(0, 1, 2, 3, 4, 3, 2, 1)).getOrElse(-1))
  println(iterative(Array(0, 1, 2, 3, 4, 4, 3, 2, 1)).getOrElse(-1))
  println(iterative(Array(0, 1, 2, 3, 4)).getOrElse(-1))
  println(rec(List(0, 1, 2, 3, 4, 3, 2, 1), 0).getOrElse(-1))
  println(rec(List(0, 1, 2, 3, 4, 4, 3, 2, 1), 0).getOrElse(-1))
  println(rec(List(0, 1, 2, 3, 4), 0).getOrElse(-1))
  def rec(list: List[Int], index: Int): Option[Int] = list match {
    case Nil => None
    case _ :: Nil => None
    case e1 :: e2 :: tail => if (e1 > e2) Some(index) else rec(list.tail, index + 1)
  }
  def iterative(a: Array[Int]): Option[Int] = {
    for (i <- 0 to a.length - 2) {
      if (a(i) > a(i + 1)) return Some(i)
    }
    None
  }
}
