package recursion.dp;

object PerfactSum extends App {
  assert(isPerfactSum(List(1,3,4,9), 7)==true)
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
