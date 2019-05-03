package datastructure.mutable.heap
import scala.collection.mutable.ListBuffer
object BinaryMinHeap extends App {
  val list = ListBuffer[Int]()
  def add(item: Int) = {
    list.append(item)
    if (list.size > 1)
      upshift
  }
  def remove = {
    if (list.nonEmpty) {
      // val deleted=list(0)
      val last = list.remove(list.last)
      list(0) = last
      downshift
      // deleted
    }
  }
  def upshift = print()
  def downshift = {

  }
  def swap(a:Int, b:Int)={
    val temp=list(a)
    list(a)=list(b)
    list(b)=temp
  }
  def parent(i:Int)=(i-1)/2
  def leftChild(i:Int)=2*i+1
  def rightChild(i:Int)=2*i+2
}
