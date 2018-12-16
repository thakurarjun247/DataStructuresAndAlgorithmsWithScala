package test
import scala.collection.immutable.ListMap
object Two
  extends App {
  val list=Array("Alice",
  "Allison",
  "Alice",
  "Allison",
  "Ashley",
  "Ashley")
  val a=Array("a","cd","cd", "de","de")
  println(electionWinner(list))
  def electionWinner(votes: Array[String]): String = {
    val map=votes
      .toList
      .groupBy(l=>l)
    val map2=map.map((item)=> (item._1, item._2.size))
    val map3=ListMap(map2.toSeq.sortWith(_._2 > _._2):_*)
    val x=map3.keySet
    val topVote=map3(x.head)
    map3.filter(tup=>tup._2==topVote).keysIterator.max
   /* val firstKey=map3.firstKey

    map3.find({case (a,b) => a  == value})
    println(map3)

    //println(map2)
    ""*/
/*
val keySet=map.keySet
    val max=keySet.max
    val maxVotes=map.keySet.max
    val x=map(maxVotes)
    val y=x.max
    map(maxVotes).max


*/
  }
}
