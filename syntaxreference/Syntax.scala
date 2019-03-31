package syntaxreference

class Syntax {
  //I don't know about a  mode operator in scala
  def mod(a:Int, b:Int):Int={
    val x = b-a
    if(x>0) x else x * -1
  }
  //Positive diff between 2 numbers, beware it's abs not mod
  println(math.abs(10-5)+"  "+ math.abs(5-10))
}
