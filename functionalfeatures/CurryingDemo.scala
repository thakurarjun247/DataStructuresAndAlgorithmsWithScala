package functionalfeatures

object CurryingDemo extends App
{
  println(add(1,2))
  println(curAdd(1)(2))
  val paf=curAdd(1)(_:Int)
  print(paf(2))
  def add(x:Int, y:Int) = x + y
  def curAdd(x:Int)(y:Int)=x+y

}
