package scala.collection
import scala.collection.mutable
object MutableToFromImmutable extends App {
  //just use ++ operator
  val immmut = Set(1, 2, 3)
  val mut: mutable.Set[Int] = mutable.Set[Int]() ++ immmut
  mut += 4
  println(mut)
  mut.toSet
  //or
  val newImmut: Set[Int] = Set() ++ mut
}
