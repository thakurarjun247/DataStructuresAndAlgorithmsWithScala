package oodesign.buildingblocks
class BareMinimum

class Point(var x:Int, var y:Int){
  def move2(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }
  override def toString=s"($x, $y)"
}

class PointWithDefaults(var x:Int=0, var y:Int=0){
  def move2(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }
  override def toString=s"($x,$y)"
}

class PointWithVals(val x:Int, val y:Int)

class PointWithoutValOrVar(x: Int, y: Int){
  def tryToChangeArgs(a:Int, b:Int)={
    println(s"x=$x y=$y")
    // wont work reassign to val
    //x=x+a
  //  y=y+a
    println(s"x=$x y=$y")
  }

}


object Class extends App{
  println("dont miss: https://docs.scala-lang.org/tour/classes.html")
  val bm=new BareMinimum

  //TODO: See error below
  //val origin=new Point
  //wont compile as constructor args not passed
  //btw the constructr args you see in the class def is the default cons.

  val origin=new PointWithDefaults
  //by default x and y = 0
  val oneZero=new PointWithDefaults(1)
  // x is 1, y is 0 by dflt
  val zeroOne=new PointWithDefaults(y=1)
  //name the arg so that compiler knows that it's y
  //by default it will assume it to be x, as x is the first arg
  println(s"bm origin zeroOne oneZero")
  println(s"$bm $origin $zeroOne $oneZero")

  val pointWithVals=new PointWithVals(1,2)
  //pointWithVals.x=1
  //won't compile, reassign to val

  //all the consturctor args that are marked var are val
  //are by default public
  //if var or val not mentioned that means they are private
  // as well as val see tryToChangeArgs method
  //new PointWithoutValOrVar(1,2).tryToChangeArgs(2,3)

  val pointWithoutValOrVar=new PointWithoutValOrVar(1,2)
  //Parameters without val or var are private values,
  // visible only within the class.
  //invisible here in another class
  //won't compile
  //val x=pointWithoutValOrVar.x

  //by default all class variable and methods are
  // public, use keywork "private" to change it
}

