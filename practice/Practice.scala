package practice

object Practice extends App{
  val a=Array(23171, 21011, 21123,21366,21013,21367)
  println(solution(a))
  def solution(a: Array[Int]): Int = {
    //var diff=0
    if(a.size<=1) return 0
    var diffVar=0
    val tail=a.tail
    val head=a.head
    tail.foreach{item=>
      if((item-head)>diffVar) diffVar = item-head
    }
    Integer.max(0,Integer.max(diffVar,solution(a.tail)))
  }
}