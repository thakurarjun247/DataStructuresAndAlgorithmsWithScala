package misc

object SearchRotatedArray extends App {
  println(search(Array(7, 8, 9, 0, 1, 2, 3, 4), 8).getOrElse("not found"))

  def search(a: Array[Int], key: Int): Option[Int] = {
    search(a, key, 0, a.length - 1)
  }

  def isPOR(a: Array[Int], index: Int) = {
    if (index == 0 || index == a.length - 1) false
    else (a(index) > a(index + 1) && a(index - 1) > a(index))
  }

  def search(a: Array[Int], key: Int, low: Int, high: Int): Option[Int] = {
    println(s"between ${a(low)} and ${a(high)}")
    if (high < low) return None
    val mid = (low + high) / 2
    println(s"mid is ${a(mid)}")
    //val isPOR=
    if (a(mid) == key) Some(mid)
    else {
      if (isPOR(a, mid)) {
        if ((a(mid) > key)) search(a, key, mid + 1, high)
        else search(a, key, low, mid - 1)
      }
      else {

        if ((a(mid) > key)) search(a, key, low, mid - 1) else search(a, key, mid + 1, high)
        // else search(a, key, low, mid-1)

      }
    }

    //else if((a(mid)>key && isPOR(a, mid)) ) search(a, key, mid+1, high)
    // else search(a, key, low, mid-1)

  }
}
