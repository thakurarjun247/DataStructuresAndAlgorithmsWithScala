package scalaprogramminglanguage.misc
trait Buffer {
  type T
  val element: T
}
abstract class SeqBuffer extends Buffer {
  type U
  type T <: Seq[U]
  def length = element.length
}
abstract class IntSeqBuffer extends SeqBuffer {
  type U = Int
}
object TypeParams extends App {
  //readme https://docs.scala-lang.org/tour/abstract-types.html
  def getIntSeqBuffer(e1: Int, e2: Int) = new IntSeqBuffer {
    override type T = List[U]
    override val element = List(e1, e2)
  }
  /*
  *Type parameterization allows you to write generic classes and traits. For example, sets are generic and
  take a type parameter: they are defined as Set[T]. As a result, any particular set instance might be
  a Set[String], a Set[Int], etc., but it must be a set of something. Unlike Java, which allows raw
  types, Scala requires that you specify type parameters. Variance defines inheritance relationships of
  parameterized types, such as whether a Set[String], for example, is a subtype of Set[AnyRef].
  *
  * */
}
