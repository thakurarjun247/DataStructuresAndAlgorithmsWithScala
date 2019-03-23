package searching

object BinarySearch extends App {
  println(recursive((0 to 5).toArray, 5).getOrElse(-1))
  println(recursive((0 to 5).toArray, 3).getOrElse(-1))
  println(recursive((0 to 5).toArray, 500).getOrElse(-1))

  def recursive(a: Array[Int], key: Int):Option[Int] =
    recursive(a, key, 0, a.length - 1)
  def recursive(a: Array[Int], key: Int, low: Int, high: Int): Option[Int] = {
    if (high < low) None
    else {
      val mid = (high + low) / 2
      if (a(mid) == key) Some(mid)
      else if (key < a(mid)) recursive(a, key, 0, mid - 1)
      else recursive(a, key, mid + 1, high)
    }
  }
}
