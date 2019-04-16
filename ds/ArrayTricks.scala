package ds
object ArrayTricks extends App {
  //TODO: fails for
//  assert(search(Array(1), 2)== -1)
 /*assert(search(Array(3,1), 3)==0)
  assert(search(Array(3,1), 1)==1)
  assert(search(Array(4, 5, 6, 7, 0, 1, 2), 0)==4) //4
  assert(search(Array(9, 4, 5, 6, 7), 9)==0) //0
  assert(search(Array(), 0)== -1) // -1
  assert(search(Array(4), 0)== -1) // -1
   assert(search(Array(4, 5, 6, 7, 0, 1, 2), 1)==5) //5
*/  def search(nums: Array[Int], target: Int): Int =
    search(nums, target, 0, nums.size - 1)
  def search(a: Array[Int], target: Int, l: Int, h: Int): Int = {
    if (h < l) return -1
    else {
      val m = (l + h) / 2
      if (a(m) == target) return m
      val isLeftSorted = a(l) <= a(m)
      val isRightSorted = a(m) <= a(h)
      def keyPresentInHalf(x: Int, y: Int, key: Int) = (a(x) <= target) && (target <= a(y))
      if (isLeftSorted && keyPresentInHalf(l, m - 1, target))
        search(a, target, l, m - 1)
      else if (isLeftSorted && !keyPresentInHalf(l, m - 1, target))
        search(a, target, m + 1, h)
      else if (isRightSorted && keyPresentInHalf(m + 1, h, target))
        search(a, target, m + 1, h)
      else search(a, target, l, m - 1)
    }
  }
}