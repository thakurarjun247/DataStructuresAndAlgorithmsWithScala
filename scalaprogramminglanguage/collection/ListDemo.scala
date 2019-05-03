package scalaprogramminglanguage.collection
object ListDemo extends App {
  val list = List(1, 2, 3)
  val flattened = extract[Int](list)
  val listBuffer = new scala.collection.mutable.ListBuffer[Int]()
  flattened.foreach(println)
  println(flattened)
  //ADD items to list
  val newList = 4 :: list
  listBuffer += 1
  listBuffer += 2000
  listBuffer.foreach(println)
  listBuffer.toArray
  val words = List("one", "two")
  list.foreach(println)
  println("list size: " + (list ::: newList).size)
  val nums = List(1, 2)
  val zipped = nums zip words
  val unzipped = zipped.unzip
  print(zipped)
  def extract[T](list: List[Any]) = list.flatMap {
    case element: T => Some(element)
    case _ => None
  }
}
