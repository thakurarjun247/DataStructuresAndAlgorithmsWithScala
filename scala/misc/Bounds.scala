package scala.misc
class W {
  override def toString = "W"
}
class X extends W {
  override def toString = "X"
}
class Y extends X {
  override def toString = "Y"
}
object Bounds extends App {
  val w = new W
  val x = new X
  val y = new Y
  /*
  An upper type bound T <: A declares
  that type variable T refers to a subtype of type A.
  T can be A at max not upper than that hence called upper bound
  */
  class MyClass[T <: X] {
    def acceptXAndSubTypes(t: T) = println(t)
  }
  val myClass = new MyClass[X]()
  myClass.acceptXAndSubTypes(x)
  myClass.acceptXAndSubTypes(y)
  //this won't compile
  //myClass.acceptXAndSubTypes(w)
  //myClass.tAndSubTypes(w)
  class AnotherClass[A >: X] {
    def acceptXAndSuperTypes(t: A) = println(t)
  }
  val cx = new AnotherClass[X]
  val cw = new AnotherClass[W]
  //runtime error below
  // val cy=new AnotherClass[Y]
}
