package dynamicprogramming
object Knapsack01 extends App {
  assert(f(Array(2, 2, 4, 5), Array(2, 4, 6, 9), 3, 0, 0) == 4)
  assert(f(Array(2, 2, 4, 5), Array(2, 4, 6, 9), 8, 0, 0) == 13)
  def f(weights: Array[Int], values: Array[Int], maxWeight: Int, currentWeight: Int, currentValue: Int): Int = {
    // if item list is empty return 0,
    // if max weight is 0 return 0
    if (weights.isEmpty || values.isEmpty) currentValue
    else {
      //if current item weight + existing weight > maxWt  ,
      // don't pick current item,
      if (weights.head + currentWeight > maxWeight) {
        // go to next item, don't terminate the program yet
        f(weights.tail, values.tail, maxWeight, currentWeight, currentValue)
      }
      else { //else compare if choosing current item gives more profit or leaving it gives more
        //pick current item
        f(weights.tail, values.tail, maxWeight /*-weights.head*/ , currentWeight + weights.head, currentValue + values.head) max
          // go to next item, don't terminate the program yet
          f(weights.tail, values.tail, maxWeight, currentWeight, currentValue)
      }
    }
  }
}
