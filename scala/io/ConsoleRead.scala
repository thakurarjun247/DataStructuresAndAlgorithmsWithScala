package scala.io
import scala.io.StdIn._
object ConsoleRead extends App {
  val line = readLine()
  val num = readInt()
  println(line, num)
}
