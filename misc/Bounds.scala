package misc

class W {
  override def toString = "W"
}

class X extends W{
  override def toString = "X"
}

class Y extends X{
  override def toString = "Y"
}


object Bounds extends App {
  val w = new W
  val x = new X
  val y = new Y

class MyClass[T <: X] {
  def acceptXAndSubTypes(t: T) = println(t)
}

  val myClass=new MyClass[X]()
  myClass.acceptXAndSubTypes(x)
  myClass.acceptXAndSubTypes(y)
  //myClass.tAndSubTypes(w)

  class AnotherClass[A>:X]{
    def acceptXAndSuperTypes(t:A)=println(t)
  }

  val cx=new AnotherClass[X]
  val cw=new AnotherClass[W]
  //runtime error below
 // val cy=new AnotherClass[Y]
}
