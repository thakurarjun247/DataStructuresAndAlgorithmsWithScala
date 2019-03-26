package misc

import scala.collection.immutable.ListMap
//find the winner of election, the number of votes is the
//number of times a name appears in the seq,
//if there is a tie, the name that is alphabetically greater wins
//i.e. Zeba beats Alice
object Two
  extends App {
  val list=Array("Alice",
  "Allison",
  "Alice",
  "Allison",
  "Ashley",
  "Ashley",
  "Arjun",
  "Zeba")
  val a=Array("a","cd","cd", "de","de")
  println(electionWinner(list))
  def electionWinner(votes: Array[String]): String = {
    val map = votes
      .toList
      .groupBy(l => l)
    val map2=map.map((item)=> (item._1, item._2.size))

    case class NameVotes(name: String, votes: Int)
    val nameVotesList: Seq[NameVotes] = votes
      .toList
      .groupBy(item => item)
      .map(item => NameVotes(item._1, item._2.size))
      .toSeq
    println("List is: " + nameVotesList.foreach(println))

    //if sortWith is used twice the later one overrides the previous one
    println("Ashley=" + nameVotesList
      .sortWith(_.votes > _.votes)
      .sortWith(_.name > _.name)
      .head.name)

    println("Alice=" + nameVotesList
      .sortWith(_.votes > _.votes)
      .sortWith(_.name < _.name)
      .head.name)

    println("Zeba=" + nameVotesList
      .sortWith(_.votes < _.votes)
      .sortWith(_.name > _.name)
      .head.name) //Allison

    println("Allison=" + nameVotesList
      .sortWith(_.votes < _.votes)
      .sortWith(_.name > _.name)
      .head.name)

    val name:String = nameVotesList
      .groupBy(_.votes) //get vote to Names map
      .toSeq
      .sortWith(_._1 > _._1) //highest votes first
      .head //first entry i.e. map highest vote count => List of candidates which has ties for highest votes
      ._2 // drop the key i.e. List of case classes
      .sortWith(_.name > _.name)
        .head.name

    val expectedName: String = "Ashley"
    println(expectedName+"is expected actual one is "+name)
    ///println(name)


        val map3=ListMap(map2.toSeq.sortWith(_._2 > _._2):_*)
    val x=map3.keySet
    val topVote=map3(x.head)
    map3.filter(tup=>tup._2==topVote).keysIterator.max
   // val firstKey=map3.firstKey

  ///  map3.find({case (a,b) => a  == value})
    println(map3)

    //println(map2)
    ""
    /*
val keySet=map.keySet
    val max=keySet.max
    val maxVotes=map.keySet.max
    val x=map(maxVotes)
    val y=x.max
    map(maxVotes).max


*/
    ""
  }
}
