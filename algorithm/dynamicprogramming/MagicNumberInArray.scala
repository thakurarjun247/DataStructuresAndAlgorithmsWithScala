package algorithm.dynamicprogramming
import scala.annotation.tailrec
;
object MagicNumberInArray extends App {
  //assumption: all elements are distinct
  val a = Array(-10, -5, 0, 1, 4, 5, 6, 7, 99, 100)
  val b = Array(1, 2, 3)
  val indexOpt = magic(b, 0, b.length - 1)
  val x = indexOpt match {
    case Some(idx) => s"found at $idx"
    case None => "not found"
  }
  //val y = indexOpt.map(x=>s"found at $x")
  println(x)
  @tailrec
  def magic(a: Array[Int], low: Int, high: Int): Option[Int] = {
    val mid = (low + high) / 2
    if (low > high) None
    else if (a(mid) == mid) Some(mid)
    else if (mid < a(mid)) magic(a, low, mid - 1)
    else magic(a, mid + 1, high)
  }
}
