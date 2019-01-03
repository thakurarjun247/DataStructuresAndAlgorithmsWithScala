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
  def tAndSubTypes(t: T) = println(t)
}

  val myClass=new MyClass[X]()
  myClass.tAndSubTypes(x)
  myClass.tAndSubTypes(y)
  //myClass.tAndSubTypes(w)

  class AnotherClass[A>:X]{
    def tAndSuperTypes(t:A)=println(t)
  }

  val cx=new AnotherClass[X]
  //runtime error below
  //val cy=new AnotherClass[Y]
  val cw=new AnotherClass[W]
/*  anotherClass.tAndSuperTypes(w)
  anotherClass.tAndSuperTypes(x)
  anotherClass.tAndSuperTypes(y)*/


}
