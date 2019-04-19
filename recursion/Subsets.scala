package recursion
import scala.collection.mutable.ListBuffer
object Subsets extends  App{
  val x= getSubsets(Set(1,2))
  val set = Set(1, 2, 3,4)
  val subsets=getSubsets(set)
  println(set)
  println(subsets.groupBy(_.size))
  println(subsets.size)

  //find all subsest of a given set
  def getSubsets(set: Set[Int]): List[Set[Int]] = {
    if (set.isEmpty) List(set)
    else {
      val list: ListBuffer[Set[Int]] = new ListBuffer[Set[Int]]()
      list += Set.empty[Int] // adding empty set
      getSubsets(set, list).toList
    }
  }

  def getSubsets(set: Set[Int], list: ListBuffer[Set[Int]]): ListBuffer[Set[Int]] = {
    if (set.isEmpty) list
    else {
      val tempList = list.map(item => item + set.head)
      //you can returnt the following list but it mutates so
     // tempList.foreach(item => list += item)
      getSubsets(set.tail, list++tempList)
    }
  }
}
