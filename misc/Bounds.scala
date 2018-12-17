package misc
//
class X

class Y

class Z

object Bounds extends App {
  val a = new X
  val b = new Y
  val c = new Z

  def upper[T <: Y](t: T) = println(t)

  def lower[T >: Y](t: T) = println(t)

  //upper(a)
  //upper(a)
  // upper(c)
  lower(a)
  lower(c)
}
