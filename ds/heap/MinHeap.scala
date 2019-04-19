package ds.heap
import scala.collection.mutable
object MinHeap extends App{

/* PriorityQueue implements priority queues using a heap.
  *  To prioritize elements of type A there must be an implicit
  *  Ordering[A] available at creation.*/
  val intPQ=mutable.PriorityQueue(1,2,3)
  case class User(name:String, age:Int)
  def higherTheAgeHigherThePriority(user:User)=user.age
  def higherTheAgeLowerThePriority(user:User)= -user.age
  val u1= User("one", 1)
  val u2= User("two", 2)
  val u3= User("three", 3)
  val pq=mutable.PriorityQueue(u1,u3,u2)(Ordering.by(higherTheAgeHigherThePriority))
  while(pq.nonEmpty) print(pq.dequeue.age)
  //or
  val pqLambda=mutable.PriorityQueue(u1,u3,u2)(Ordering.by(_.age))
  while(pqLambda.nonEmpty) print(pqLambda.dequeue.age)

  val pqReverse=mutable.PriorityQueue(u1,u3,u2)(Ordering.by(higherTheAgeLowerThePriority))
  while(pqReverse.nonEmpty) print(pqReverse.dequeue.age)
//or
  val pqLambdaReverse=mutable.PriorityQueue(u1,u3,u2)(Ordering.by(_.age*(-1)))
  while(pqLambdaReverse.nonEmpty) print(pqLambdaReverse.dequeue.age)

  //Is ordering preserved after deletion?
  //Can it be used as a max heap??
  //It will only allow to delete from front, random deletes not available
}
