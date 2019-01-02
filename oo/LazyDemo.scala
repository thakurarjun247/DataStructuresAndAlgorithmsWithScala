package oo
/*
 “Lazy Evaluation is an evaluation strategy which delays the evaluation
 of an expression until its value is needed.” And today most of the
 modern programming languages support Lazy Evaluation. In contrast
 with strict or eager evaluation, which computes values as soon as
 possible, lazy evaluation can certainly deliver a few benefits, such as:
Lazy evaluation can help to resolve circular dependencies
It can provide performance enhancement by not doing calculations until
needed — and they may not be done at all if the calculation is not used.
It can increase the response time of applications by postponing the heavy
 operations until required.
However, lazy evaluation has the drawback that performance may not be
 predictable — because you cannot say exactly when the value is going
 to be evaluated.
Scala has the following features to support lazy evaluation.
 */
object LazyDemo extends App {
  /*
  A val  can be declared as lazy by using the lazy keyword.
  The value of val not be initialized until it is called.


   */
  println("https://www.youtube.com/watch?v=iromVyC0mDs")
  lazy val x = 5 + 2
  lazy val y = x + 1
  val z = y
  println(z)
}
