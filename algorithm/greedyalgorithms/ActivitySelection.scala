package algorithm.greedyalgorithms
/*
You are given n activities with their
start and finish times. Select the maximum number of
activities that can be performed by a single person, assuming
 that a person can only work on a single activity at a time.
      start[]  =  {1, 3, 0, 5, 8, 5};
     finish[] =  {2, 4, 6, 7, 9, 9};
     Ans: 4

 */
//note: assume that activities are sorted in order
//note: of finish time that is array f is sorted
object ActivitySelection extends App {
  //println(getActivityList(Array(1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12), Array(4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16), 0, Nil).reverse)
  //println(getActivityList(Array(1, 3, 0, 5, 8, 5), Array(2, 4, 6, 7, 9, 9), 0, Nil).reverse )

  assert(getNumberOfActivities(Array(1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12), Array(4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16), 0, 0) == 3)
  //assert(getNumberOfActivities(Array(1, 3, 0, 5, 8, 5), Array(2, 4, 6, 7, 9, 9), 0, 0) == 3)
  def getNumberOfActivities(start: Array[Int], finish: Array[Int], lastActivityFinishTime: Int, ans: Int): Int = {
    if (finish.isEmpty || start.isEmpty) ans
    else {
      val index = findValidIndex(start, lastActivityFinishTime, 0)
      getNumberOfActivities(start.slice(index + 1, start.length - 1), finish.slice(index + 1, finish.length - 1), finish(index), ans + 1)
    }
  }

  def getActivityList(start: Array[Int], finish: Array[Int], lastActivityFinishTime: Int, list: List[Int]): List[Int] = {
    if (finish.isEmpty || start.isEmpty) list
    else {
      val index = findValidIndex(start, lastActivityFinishTime, 0)
      getActivityList(start.slice(index + 1, start.length - 1), finish.slice(index + 1, finish.length - 1), finish(index), index::list)
    }
  }

  private def findValidIndex(start: Array[Int], lastActivityFinishTime: Int, currentIndex: Int): Int =
    if (start.isEmpty || (start.head >= lastActivityFinishTime)) currentIndex
    else findValidIndex(start.tail, lastActivityFinishTime, currentIndex + 1)
}
