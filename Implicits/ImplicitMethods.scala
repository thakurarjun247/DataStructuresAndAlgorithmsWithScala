package Implicits

object ImplicitMethods extends App{
  case class A(x:Int)
  case class B(b:Int){
    def bMethod=println("bMethod called..."+b)
  }
  val a=A(100)
  val b=B(20)

  //error:
  //a.bMethod
  implicit def aToB(a:A)=B(a.x)
  //bmethod isn't avail in class A, hence A=>B happens by an implicit method above
  a.bMethod


}
