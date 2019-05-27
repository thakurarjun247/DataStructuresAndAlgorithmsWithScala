package scala.misc

;
object OptionDemo extends App {
  //val capitals= Map("France"-> "Paris", "Japan" -> "Tokyo")
  // print(capitals get "Ind")
  val x: Option[String] = Some("xl")
  val y: Option[String] = None
  def foo(input: Option[String]) = input.map(print(_))
  foo(x)
  foo(y)
}
