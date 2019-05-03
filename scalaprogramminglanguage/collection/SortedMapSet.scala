package scalaprogramminglanguage.collection
import scala.collection.immutable.{TreeMap, TreeSet}
import scala.util.Random
object SortedMapSet extends App {
  /*
  *  Scala collections library provides traits SortedSet and SortedMap.
   *  These traits are implemented by classes TreeSet and TreeMap,
    * which use a red-black tree to keep elements (in the case of TreeSet) or keys (in the case of TreeMap) in order.
  The order is determined by the Ordered trait,
  which the element type of the set, or key type of the map,
    must either mix in or be implicitly */
  val seq = Seq.fill(10)(Random.nextInt(5))
  val treeSet = TreeSet(2, 1, 4, 7, 3)
  val treeSet2 = treeSet ++ seq
  print(treeSet2)
  println(s" $treeSet")
  val treeMap = TreeMap(2 -> "two", 1 -> "one", 0 -> "zzz")
  println(treeMap)
  val unsortedMap = Map("01" -> List(34, 12, 14, 23), "11" -> List(22, 11, 34), "00" -> List(10, 9, 8))
  println(TreeMap[String, List[Int]]() ++ unsortedMap)
  println("sort based on key" +
    unsortedMap
      .toSeq
      .sortWith(_._1 < _._1))
  println("sort based on values size" +
    unsortedMap
      .toSeq
      .sortWith(_._2.size < _._2.size))
  val seqSortedBasedOnKey = Seq
    .fill(10)(Random.nextInt(4))
    .groupBy(identity)
    .toSeq
    .sortWith(_._1 < _._1)
  println(seqSortedBasedOnKey)
  val keyToSum = seqSortedBasedOnKey
    .map(item => (item._1, item._2.sum))
  println(keyToSum)
  val keyToSumSortedOnValues = keyToSum
    .sortWith(_._2 < _._2)
  println(keyToSumSortedOnValues)
  // += method isn't supported in immutable map
  // however if you change the map to var it does
  //because a new map will be created and value assigned to the var again
  val map = Map(1 -> 1)
  //won't compile
  //map+=(2->2)
  var varMap = Map(1 -> 1)
  varMap += (2 -> 2)
  val colors = List("r", "g", "b")
  //create map from other collecgtion
  // you'll need to create an empty TreeSet[String]
  // and add to it the elements of the list with the TreeSet's ++ operator:
  val sortedColors = TreeSet[String]() ++ colors
}
