package amzn

object NextLargestElement extends App {

  4 max 6
  //same as
  scala.math.max(4,6)
  //is same as
  Integer.max(4,6) //internally uses java.Math.max

  Array(16, 17, 18, 3, 5, 221,220).foreach(i => print(s"$i "))
  println()
  nextLargestElement(Array(16, 17, 4, 3, 5, 2)).foreach(i => print(s"$i "))

  def nextLargestElement(a: Array[Int]): Array[Int] = {
    var arrayLastItem = a(a.length - 1) //holds last element

    var maxSoFar = -1
    //should be -1 for the last element
    a(a.length - 1) = maxSoFar
    var i = a.length - 2
    while (i >= 0) {
//the commented code also works but a bit verbose
    /*  val cur = Integer.max(last, max_so_far)
      last = a(i)
      max_so_far = cur
      a(i) = cur
      i -= 1
      */
      maxSoFar = Integer.max(arrayLastItem, maxSoFar)
      arrayLastItem = a(i)
      a(i) = maxSoFar
      i -= 1
    }
    a
  }
}
