package dsalgo.algorithm.dynamicprogramming

import scala.collection.mutable.Map
object Knapsack01 extends App {
/*  assert(fNoMemo(Array(2, 2, 4, 5), Array(2, 4, 6, 9), 3, 0, 0) == 4)
  assert(fNoMemo(Array(2, 2, 4, 5), Array(2, 4, 6, 9), 8, 0, 0) == 13)
  assert(fMemo(Array(2, 2, 4, 5), Array(2, 4, 6, 9), 8, Map()) == 13)
  assert(fMemo(Array(2, 2, 4, 5), Array(2, 4, 6, 9), 3, Map()) == 4)*/
  assert(fMemo(Array(1,3,4,5), Array(1,4,5,7), 7, Map()) == 9)
  def fNoMemo(weights: Array[Int], values: Array[Int], maxWeight: Int, currentWeight: Int, currentValue: Int): Int = {
    // if item list is empty return 0,
    // if max weight is 0 return 0
    if (weights.isEmpty || values.isEmpty) currentValue
    else {
      //if current item weight + existing weight > maxWt  ,
      // don't pick current item,
      if (weights.head + currentWeight > maxWeight) {
        // go to next item, don't terminate the program yet
        fNoMemo(weights.tail, values.tail, maxWeight, currentWeight, currentValue)
      }
      else { //else compare if choosing current item gives more profit or leaving it gives more
        //pick current item
        fNoMemo(weights.tail, values.tail, maxWeight /*-weights.head*/ , currentWeight + weights.head, currentValue + values.head) max
          // go to next item, don't terminate the program yet
          fNoMemo(weights.tail, values.tail, maxWeight, currentWeight, currentValue)
      }
    }
  }
  def fMemo(w: Array[Int], p: Array[Int], wt: Int, memo: Map[(Int, Int), Int]): Int = {
    if (w.isEmpty) 0
    else if (wt == 0) 0
    else {
      if (memo.contains((w.length, wt))) {
        println(s"yay found in Memo ${w.length}, $wt")
      }
      else {
        println(s"calculating ${w.length}, $wt")
        //leave it
        val value = if (wt < w.head) fMemo(w.tail, p.tail, wt, memo)
        else p.head + fMemo(w.tail, p.tail, wt - w.head, memo) max fMemo(w.tail, p.tail, wt, memo)
        memo += (w.length, wt) -> value
      }
      memo((w.length, wt))
    }
  }
}

