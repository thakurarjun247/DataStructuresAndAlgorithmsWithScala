package misc.onlinecodingtest
object AmazonSDE extends App {
  val list: List[(Int, Int)] = List((1, 2), (1, 3), (3, 4))
  list
    .groupBy(_._1)
    .foreach(println)
  //  .foreach(item => println(item._1, item._2.map(_._2)))
}
