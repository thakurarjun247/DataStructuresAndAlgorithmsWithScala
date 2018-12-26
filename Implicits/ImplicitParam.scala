package Implicits
abstract class Monoid[A] {
  //TODO: do we need to mention return type
  def add(a: A, b: A): A
  def unit: A
}
object ImplicitParam extends App {
  implicit val stringMonoid = new Monoid[String] {
    def add(a: String, b: String) = a concat b
    //TODO: find what is unit for? object of abs class won't be created without defining
    def unit = ""
  }

  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    def add(a: Int, b: Int) = a + b
    def unit = 0
  }
  def sumFun[A](xs: List[A])(implicit m: Monoid[A]): A = {
    printType(xs)
    xs match {
      case Nil => m.unit
      case _ => m.add(xs.head, sumFun(xs.tail))
    }
  }
  val list=List("a", "b")

  def printType[T](v: List[T]) = {
    val ans = v match {
      case _: List[Int] => "List[Int]"
      case _: List[String] => "List[String]"
      case _ => "Unknown"
    }
    println(s"$v is $ans")
  }

  //println(sumFun(List(1, 2, 3)))
  printType(list)
  println(sumFun(list))

}
