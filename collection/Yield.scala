package collection

object Yield extends App {
val list=List(1,2,3,4)
  println(list.map(item=>item*2))
  println(
    for{
      item<-list
    } yield item*2
  )
  /*The interesting thing to see here is this:
  The type of the result of each of the for loops is the same as
  the type of the original collection that the loop is iterating over. */

  //if you iterate over a Range, you get back an IndexedSeq with Vector as the concrete type
  val onRange:IndexedSeq[Int]=for(x <- 0 to 4) yield x
  println(onRange==Vector(0,1,2,3,4)) //true

  //alter values of a map, while not touching the keys
  val map = Map(1 -> "one", 2 -> "two", 3 -> "three")
  val upMap=for((k,v)<-map) yield (k,v.toUpperCase())
 val listOfKeys=for((k,v)<-map) yield k
  println()
  println()
  println()
  println()
  println()
  println()
  println()
  println()
}
