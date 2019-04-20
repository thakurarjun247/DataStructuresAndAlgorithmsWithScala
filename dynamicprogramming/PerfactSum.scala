package dynamicprogramming
import scala.collection.mutable.Map
object PerfactSum extends App {
  //Perfect Sum Problem aka sum of subset(Print all subsets with given sum)
  //Given an array of integers and a sum, the t
  // ask is to
  // print all subsets of given array with sum equal to given sum.
  //Don't move the implicit beneath the test cases, it won't work
  implicit var memo: Map[(Int, Int), Boolean] = Map()
  testSuite(fNoMemo)
  testSuite(fMemo)
  def testSuite(f: (List[Int], Int) => Boolean) = {
    assert(f(List(8, 1, 3, 4, 9), 7) == true)
    assert(f(List(1, 3, 4, 9), 18) == false)
    assert(f(List(), 18) == false)
    assert(f(List(2, 3), 0) == true)
  }
  def fNoMemo(list: List[Int], sum: Int): Boolean = {
    if (sum == 0) true
    else if (list.isEmpty) false
    else (fNoMemo(list.tail, sum - list.head) ||
      fNoMemo(list.tail, sum)
      )
  }
  def fMemo(list: List[Int], sum: Int)(implicit memo: Map[(Int, Int), Boolean]): Boolean = {
    if (sum == 0) true
    else if (list.isEmpty) false
    else {
      if (!memo.contains(list.size, sum))
        memo += (list.size, sum) -> (
          fMemo(list.tail, sum - list.head) || fMemo(list.tail, sum)
          )
      memo(list.size, sum)
    }
  }
}
