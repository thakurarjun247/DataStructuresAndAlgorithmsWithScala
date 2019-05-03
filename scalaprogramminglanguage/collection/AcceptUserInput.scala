package scalaprogramminglanguage.collection
object AcceptUserInput extends App {
  //println(io.Source.stdin.getLines().take(2).map(_.toInt).sum)
  import scala.io.StdIn
  println("your name?")
  val name = StdIn.readLine
  println("enter your age? ")
  val age = StdIn.readInt
  println(s"name $name age $age")
}
