package scalaprogramminglanguage.collection
object ArrayDemo extends App {
  //create array when size is known
  val arr = new Array[Int](5)
  //notice squre bracket
  //internally java and scala array are one and the same
  //default value of array elems is 0
  arr
    .foreach(print)
  val a = Array(1, 2, 3)
  val arrayWithoutSize = Array[Int]()
  //print all
  a.foreach(println)
  val item = 2
  //linear search
  for (i <- 0 to a.length - 1) {
    println("i = " + i)
    if (a(i) == item) {
      println("found at" + i)
    }
  }
  binarySearch(a, 22)
  binarySearch(a, 2)
  //binary search
  def binarySearch(a: Array[Int], item: Int): Unit = {
    val index: Option[Int] = binarySearch(a, item, 0, a.length - 1)
    println(s"binary searching item $item")
    val result = "found at " + index.getOrElse("not found")
    println(result)
  }
  def binarySearch(a: Array[Int], item: Int, first: Int, last: Int): Option[Int] = {
    if (first > last) return None
    val mid = (first + last) / 2
    if (a(mid) == item)
      Some(mid)
    else {
      if (item < a(mid))
        binarySearch(a, item, first, mid - 1)
      else
        binarySearch(a, item, mid + 1, last)
    }
  }
}
