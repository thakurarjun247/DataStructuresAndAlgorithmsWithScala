package datastructure.heap
class MaxHeap /*extends Heap[Int] */ {
  /*val list = ListBuffer[Int]()
  def delete: Int = ???
  def add(item: Int): Unit = {
    list.append(item)
    upshift
  }
  def upshift = {
    var currentNode = lastIndex
    while (parent(currentNode) != null || list(currentNode) < parent(currentNode)) {
      swap(currentNode, parent(currentNode))
      currentNode = parent(currentNode)
    }
  }
  def swap(i: Int, j: Int) = {
    val temp = list(i)
    list(i) = list(j)
    list(j) = temp
  }
  def lastIndex = list.size - 1
  def head: Int = list.head
  def parent(t: Int): Int = if (t < 1) null else (t - 1) / 2
  */
}
