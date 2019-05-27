package scala.collection
object Looping extends App {
  1 to 5 foreach print
  //or add ()
  (1 to 5) foreach print
  val list: Range.Inclusive = 1 to 5
  for (i <- 1 to 5) print(i)
  for (i <- 1 to 5) {
    print(i)
    print(i * i)
  }
}
