package misc

class W {
  override def toString = "W"
}

class X {
  override def toString = "X"
}

class Y extends X{
  override def toString = "Y"
}


object Bounds extends App {
  val w = new W
  val x = new X
  val y = new Y

class MyClass[T <: Y] {
  def tAndSubTypes(t: T) = println(t)
}
/*
  val myClass=new MyClass[X]()
  myClass.tAndSubTypes(x)
  myClass.tAndSubTypes(y)*/
  //myClass.tAndSubTypes(w)


}
