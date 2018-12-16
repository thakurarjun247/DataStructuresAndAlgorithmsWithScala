package recursion.dp

object Knapsack01 extends App{
  val weights=Array(10,20,30)
  val values=Array(60,100,120)
  val maxWeight=50
  val answer=220
  def knap(weights:Array[Int], values:Array[Int], maxWeight: Int, n:Int):Int={
    if(maxWeight==0 || n==0) 0
   // else if(weights.length<=0)  0
    else if(weights(n)>maxWeight) knap(weights,values,maxWeight,n-1)
      //TODO: complete below
    else Integer.max(1,2)
  }

}
