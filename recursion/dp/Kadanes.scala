package recursion.dp

object  Kadanes extends App {
  print("expected 7 actual is ")
println(kadanes(Array(-2, -3, 4, -1, -2, 1, 5, -3)))
  /*
  *  find the sum of contiguous subarray within an array
  *  of numbers which has the largest sum.  */
  def kadanes(a:Array[Int]): Int={
    if(a.length==0) return 0
    var sum=a(0)
    var tempSum=a(0)
    for(i <- 1 to a.length-1){
      tempSum=Integer.max(sum+a(i),a(i))
      if(tempSum>sum) sum=tempSum
    }
    sum
  }
}
