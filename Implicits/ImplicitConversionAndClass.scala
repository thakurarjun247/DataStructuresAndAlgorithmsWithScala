package Implicits

object ImplicitConversion extends App {
  val x = 0

  implicit class Printable(x: Int) {
    def printme = println(x)
  }

  //the above code translates to the following
  /*
    implicit class Printable(x: Int) {
      def printme = println(x)
    }
    implicit final def Printable(x:Int)=new Printable(x)
    */
  //notice: final method is same as in Java, no override
  x.printme


}
