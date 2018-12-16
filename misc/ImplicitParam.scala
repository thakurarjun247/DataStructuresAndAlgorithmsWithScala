package misc


abstract class Monoid[A] {
  //TODO: do we need to mention return type
  def add(a: A, b: A): A

  def unit: A
}

object ImplicitParam extends App {
  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    def add(a: String, b: String) = a concat b

    //TODO: find what is unit for? object of abs class won't be created without defining
    def unit = ""
  }

  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    def add(a: Int, b: Int) = a + b

    def unit = 0
  }

  def sum[A](xs: List[A])(implicit m: Monoid[A]): A = if (xs.isEmpty) m.unit else m.add(xs.head, sum(xs.tail))

  println(sum(List(1, 2, 3)))
  println(sum(List("a", "b")))

}
