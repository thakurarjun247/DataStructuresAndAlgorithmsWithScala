package datastructure.number
object Number {
  def main(args: Array[String]): Unit = {
    println(isMultipleOfThree(9))
    println(isMultipleOfThree(-3))
    println(isMultipleOfThree(1))
  }
  /*
  There is a pattern in binary representation of the number that can be used to find if number is a multiple of 3. If difference between count of odd set bits (Bits set at odd positions) and even set bits is multiple of 3 then is the number.
Example : 23 (00..10111)
1) Get count of all set bits at odd positions (For 23 it’s 3).
2) Get count of all set bits at even positions (For 23 it’s 1).
3) If difference of above two counts is a multiple of 3 then number is also a multiple of 3.
*/
  def isMultipleOfThree(n: Int) = {
    val a = n.toBinaryString.toArray
    var numberOfOnesAtOddPosition = 0
    var numberOfOnesAtEvenPosition = 0
    for (i <- a.indices) {
      val even = i % 2 == 0
      if (a(i) == '1')
        (if (!even) numberOfOnesAtOddPosition += 1 else numberOfOnesAtEvenPosition += 1)
    }
    if (scala.math.abs(numberOfOnesAtEvenPosition - numberOfOnesAtOddPosition) % 3 == 0) true else false
  }
}
