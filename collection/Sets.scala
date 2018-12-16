package collection

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Sets extends App {
  val dupNums=List(0,1,2,3,3,3)
  println(dupNums)
  dupNums
    .groupBy(item=>item)
    .foreach(tuple=>println(s"${tuple._1} -> ${tuple._2.size}"))

  val numSet = mutable.Set.empty[Int]
  for (num <- dupNums) numSet += num

  println(numSet)
  //remove 0 and add 5

  numSet -0
  //- is internally -=
  numSet -=1
  numSet+5
  //or
  numSet add 100
  numSet remove 5
  println(numSet)

  //to add remove multi ple item use ++ and --
  numSet++List(4,5)
  numSet--Set(2,3,4,5)

  //contains and add return boolean
  println("numSet.contains(11) "+numSet.contains(11))
  println(s"numSet.add(12) ${numSet.add(12)}")
  println(numSet)


  val set = Set(1, 2, 3)
  println(set.tail)
  println(set.head)
  val set4 = set + 4
  println(s"set4 $set4")

  // empty method provided on the Set companion objects
  val emptySet = Set.empty[Int]
  //same as
  val anotherEmptySet = Set[Int]()


  print(emptySet)
  //println("set with emtpy set added"+set4+emptySet)


  val list = new ListBuffer[Set[Int]]()
  list += Set.empty[Int]
  list += Set(1)
  list += Set(2)
  val added = list.map(item => item + 3)
  println(added)
  // list=list::added
  println()

}
