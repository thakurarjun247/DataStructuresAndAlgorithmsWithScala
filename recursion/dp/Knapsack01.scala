package recursion.dp
object Knapsack01 extends App {
  val weights = /*Array(10, 20, 30) */ Array(0, 20, 10, 40, 30)
  val maxWeight = /*50*/ 60
  val values = /*Array(60, 100, 120)*/ Array(0, 40, 100, 50, 60)
  val answer = /*220*/ 200
  println(knap(weights, values, maxWeight, 0, 0))
  //TODO: sometime works, make it bug free
  def knap(weights: Array[Int], values: Array[Int], maxWeight: Int, currentWeight: Int, currentValue: Int): Int = {
    if (maxWeight <= currentWeight || (weights.isEmpty)) currentValue
    //else if()
    else {
      //keep it
      val rev = knap(weights.tail, values.tail, maxWeight - weights.head, currentWeight + weights.head, currentValue + values.head) max
        knap(weights.tail, values.tail, maxWeight, currentWeight, currentValue)
      //leave it
      rev
    }
  }
}
