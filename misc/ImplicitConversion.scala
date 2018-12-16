package misc;

object ImplicitConversion extends App{
        val x=0

//println(x.printme)
class Printable(x:Int){
        def printme=println(x)
        }

        implicit def IntToPrintable(x:Int)=new Printable(x)
        }
