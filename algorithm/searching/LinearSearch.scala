package algorithm.searching
object LinearSearch extends App {
  println(recursive(Array(1, 3, 2, 4, 6), 5, 0).getOrElse(-1))
  println(recursive(Array(1, 3, 2, 4, 6), 3, 0).getOrElse(-1))
  println(recursive2(List(1, 3, 2, 4, 6), 5, 0).getOrElse(-1))
  println(recursive2(List(1, 3, 2, 4, 6), 3, 0).getOrElse(-1))
  println(iterative(Array(1, 3, 2, 4, 6), 5).getOrElse(-1))
  println(iterative(Array(1, 3, 2, 4, 6), 3).getOrElse(-1))
  def recursive(a: Array[Int], item: Int, index: Int): Option[Int] = {
    if (a.length == 0) None
    else if (a.head == item) Some(index)
    else recursive(a.tail, item, index + 1)
  }
  def recursive2(list: List[Int], item: Int, index: Int): Option[Int] =
    list match {
      case Nil => None
      case (h :: t) => if (h == item) Some(index) else recursive2(list.tail, item, index + 1)
    }
  def iterative(a: Array[Int], key: Int): Option[Int] = {
    for (i <- 0 to a.length - 1) {
      if (key == a(i)) return Some(i)
    }
    None
  }
}
