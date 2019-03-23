package collection

object Map2 extends App {
  val m1 = Map("name" -> "Arjun", "surname" -> "Thakur")
//m1.foreach(pair=>println(${pair._1}->${pair._2}))
  //m1.map(pair =>pair._1+"appended"->)
  //traditional way, looks ugly as there is for loop
  for ((k, v) <- m1) println(s"  $k -> $v")

  //get k v as tuples, see below for a quick tuple example
  m1 foreach (tuple => println(s" ${tuple._1} -> ${tuple._2}"))

  //here is how tuples are accessed
  println("a tuple can have any number of elements")
  val tuple = (0, 1, 2)
  println(s"printing tuple.. (${tuple._1} , ${tuple._2}, ${tuple._3})")
  val wordsTuple=List("one","two")
  wordsTuple.map(_.toList)
  //foreach case
  m1 foreach { case (k, v) => println(s"  $k -> $v") }

  /*If you’re working with a Java Map,
   you’ll need to use an import like this
    before you can use those techniques to work with the Java Map:
  import scala.collection.JavaConversions._
*/

  //get elements from immutable map
  val map = Map(true -> "one")
  map.get(true) // get methods gives option of value
  //println(map(false)) throws exception
  println(map(true))
  val list = 1 to 20 toList

  var groupBy: Map[Boolean, List[Int]] = list.groupBy(_ > 10)
  println(groupBy(true))

  //tuple created by partition, splitAt and span methods

  val (list1, list2): (List[Int], List[Int]) = list.partition(_ > 10)

  //var span = list.span(_ < 20)

  val (first, second): (List[Int], List[Int]) = list.splitAt(2)
  //the splitAt method works on array and string too

  val nums = (1 to 5).toArray

  //create sliding window of given size
  // size = 2
  nums
    .sliding(2)
    .toList

  // size = 2, step = 2
  nums
    .sliding(2, 2)
    .toList
  //res1: List[Array[Int]] = List(Array(1, 2), Array(3, 4), Array(5))

  // size = 2, step = 3
  nums
    .sliding(2, 3)
    .toList
  //res2: List[Array[Int]] = List(Array(1, 2), Array(4, 5))

  val s = "count list elements and put in map, map key is list elements and value is freq"
  println(s)

  val groupBySameElem = s
    .split(" ")
    .toList
    .groupBy(l => l) //groupby elements themselves creates list
  println(groupBySameElem)

  val counter = s
    .split(" ")
    .toList
    .groupBy(l => l) //groupby elements themselves creates list
    .map(t => (t._1, t._2.length))
  val counterTuple: Map[String, Int] = s
    .split(" ")
    .toList
    .groupBy(l => l) //groupby elements themselves creates list
    .map(t => (t._1 -> t._2.length))
  println(counter)
  println(counterTuple)

}
