package collection

object Map3 extends App {
  //task play with m1 and m2 and get m3
  val m1:Map[String, Int]=Map("a"->1, "b"->2)
  val m2:Map[String, Int]=Map("b"->3, "c"->3)

  //solution
  val mutMap=scala.collection.mutable.Map[String, Int]()

  val list=List(m1,m2)
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
  //val toImmut=mutMap.toMap
  Thread.sleep(10000)
println(mutMap)
}
