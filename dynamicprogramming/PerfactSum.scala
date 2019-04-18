package dynamicprogramming
object PerfactSum extends App {
  //Perfect Sum Problem aka sum of subset(Print all subsets with given sum)
  //Given an array of integers and a sum, the task is to
  // print all subsets of given array with sum equal to given sum.
  assert(isPerfactSum(List(8,1,3,4,9), 7)==true)
  assert(isPerfactSum(List(1,3,4,9), 18)==false)
  assert(isPerfactSum(List(), 18)==false)
  assert(isPerfactSum(List(2,3), 0)==true)



  def isPerfactSum(list:List[Int], sum:Int):Boolean={
    if(sum==0) true
    else if(list.isEmpty) false
    else (isPerfactSum(list.tail, sum-list.head) ||
      isPerfactSum(list.tail, sum)
      )
  }
}
