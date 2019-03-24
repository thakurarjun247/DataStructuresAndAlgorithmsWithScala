package functionalfeatures.Implicits

class A
class B

object ImplicitMethod2 extends App{
  def acceptA(a:A):Unit={}

  implicit def bToA(b:B)={
    println("bToA called.")
    new A
  }
  acceptA(new B)

  //here make sure that implicit method declaration
  //precedes call of acceptA method

}
