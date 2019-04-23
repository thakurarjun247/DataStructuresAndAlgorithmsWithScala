package dynamicprogramming.queue
import ds.immutable.linkedlist.LinkedList
object Application extends App{
 val l=List()
 l.last

 val q=Queue.empty[Int]
  val h=q.head
  val q1= q.enQueue(5)
  val q2= q1.enQueue(10)
  val q3=q2.enQueue(15)
  val h1=q3.head

  val a= q3.deQueue()
  val b= a.deQueue()
  val c=b.deQueue()
  val d=c.deQueue()

  print()
/*
  b.foreach(print)*/
/*val l=List()
  print(l.size)
  val q=Queue.empty[Int]
  q.deQueue()*/
  /*
 val q1= q.enQueue(5)
 val q2= q1.enQueue(10)
  val q3=q2.enQueue(15)

 val a= q3.deQueue()
 val b= a.deQueue()
  val c=b.deQueue()
  val d=c.deQueue()
*/
}
