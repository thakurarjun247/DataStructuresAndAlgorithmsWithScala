package collection

object Map3 extends App {
 /* //task play with m1 and m2 and get m3
  val m1:Map[String, Int]=Map("a"->1, "b"->2)
  val m2:Map[String, Int]=Map("b"->3, "c"->3)
  case class DeptBal(dept:String, bal: Int)
  //solution
  val mutMap=scala.collection.mutable.Map[String, Int]()

  val list=List(m1,m2)
  //list.foreach(map=>map.foreach(pair=>))
  val x=list
      .map(map=>map.map(pair=>DeptBal(pair._1,pair._2)) )
  println("x")
  x.foreach(println)

  //list.groupBy(pair=>pair._1)
  list
    .foreach(map =>
      map
        .foreach(pair => {
          if (!mutMap.contains(pair._1)) (pair._1 -> pair._2)
          else {
            (pair._1 -> ((pair._2) + (mutMap(pair._1))))
          }
        })
    )


*/

}

