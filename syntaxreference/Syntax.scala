package syntaxreference
object Syntax extends App {
  val s = "1.23"
  assert(s.toDouble == 1.23)
  val ten = "10"
  assert(ten.toInt == 10)
  //Positive diff between 2 numbers, beware it's abs not mod
  assert(math.abs(10 - 5) == math.abs(5 - 10))
  val a = Array(0, 1, 2, 3, 4, 5)
  assert(a.slice(0, 2).toList == Array(0, 1).toList)
  assert(a.slice(1, 1).toList == Array().toList)
  //Below are unequal becuase array is mutable and hence point to two
  //diff instances
  assert(!(a.slice(0, 2) == Array(0, 1)))
  assert(!(a.slice(1, 1) == Array()))
}
