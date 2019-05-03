package datastructure.heap
import scala.collection.mutable.PriorityQueue
object MedianInRunningStream extends App {
  def minHeapOrder(i: Int) = -i
  // implicit val ordering= Ordering.by(ascendingOrder)
  //contains bigger half of the numbers
  val minHeap = PriorityQueue[Int]()(Ordering.by(minHeapOrder))
  //Max heap doesn't need ordering as by default pq is descending order
  //contains smaller numbers
  val maxHeap = PriorityQueue[Int]()
  //details of algo
  /*
  Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
For example,
[2,3,4], the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5
Design a data structure that supports the following two operations:
void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 Two Heaps
Intuition
The above two approaches gave us some valuable insights on how to tackle this problem. Concretely, one can infer two things:
If we could maintain direct access to median elements at all times, then finding the median would take a constant amount of time.
If we could find a reasonably fast way of adding numbers to our containers, additional penalties incurred could be lessened.
But perhaps the most important insight, which is not readily observable, is the fact that we only need a consistent way to access the median elements. Keeping the entire input sorted is not a requirement.
Well, if only there were a data structure which could handle our needs.
As it turns out there are two data structures for the job:
Heaps (or Priority Queues [1])
Self-balancing Binary Search Trees (we'll talk more about them in Approach 4)
Heaps are a natural ingredient for this dish! Adding elements to them take logarithmic order of time. They also give direct access to the maximal/minimal elements in a group.
If we could maintain two heaps in the following way:
A max-heap to store the smaller half of the input numbers
A min-heap to store the larger half of the input numbers
This gives access to median values in the input: they comprise the top of the heaps!
Wait, what? How?
If the following conditions are met:
Both the heaps are balanced (or nearly balanced)
The max-heap contains all the smaller numbers while the min-heap contains all the larger numbers
then we can say that:
All the numbers in the max-heap are smaller or equal to the top element of the max-heap (let's call it
xx
x)
All the numbers in the min-heap are larger or equal to the top element of the min-heap (let's call it
yy
y)
Then
xx
x and/or
yy
y are smaller than (or equal to) almost half of the elements and larger than (or equal to) the other half. That is the definition of median elements.
This leads us to a huge point of pain in this approach: balancing the two heaps!
Algorithm
Two priority queues:
A max-heap lo to store the smaller half of the numbers
A min-heap hi to store the larger half of the numbers
The max-heap lo is allowed to store, at worst, one more element more than the min-heap hi. Hence if we have processed
kk
k elements:
If
k=2∗n+1(∀ n∈Z)k = 2*n + 1 \quad (\forall \, n \in \mathbb{Z})
k=2∗n+1(∀n∈Z), then lo is allowed to hold
n+1n+1
n+1 elements, while hi can hold
nn
n elements.
If
k=2∗n(∀ n∈Z)k = 2*n \quad (\forall \, n \in \mathbb{Z})
k=2∗n(∀n∈Z), then both heaps are balanced and hold
nn
n elements each.
This gives us the nice property that when the heaps are perfectly balanced, the median can be derived from the tops of both heaps. Otherwise, the top of the max-heap lo holds the legitimate median.
Adding a number num:
As it turns out there are two data structures for the job:
Heaps (or Priority Queues [1])
Self-balancing Binary Search Trees (we'll talk more about them in Approach 4)
Heaps are a natural ingredient for this dish! Adding elements to them take logarithmic order of time. They also give direct access to the maximal/minimal elements in a group.
If we could maintain two heaps in the following way:
A max-heap to store the smaller half of the input numbers
A min-heap to store the larger half of the input numbers
This gives access to median values in the input: they comprise the top of the heaps!
Wait, what? How?
If the following conditions are met:
Both the heaps are balanced (or nearly balanced)
The max-heap contains all the smaller numbers while the min-heap contains all the larger numbers
then we can say that:
All the numbers in the max-heap are smaller or equal to the top element of the max-heap (let's call it
xx
x)
All the numbers in the min-heap are larger or equal to the top element of the min-heap (let's call it
yy
y)
Then
xx
x and/or
yy
y are smaller than (or equal to) almost half of the elements and larger than (or equal to) the other half. That is the definition of median elements.
This leads us to a huge point of pain in this approach: balancing the two heaps!
Algorithm
Two priority queues:
A max-heap lo to store the smaller half of the numbers
A min-heap hi to store the larger half of the numbers
The max-heap lo is allowed to store, at worst, one more element more than the min-heap hi. Hence if we have processed
kk
k elements:
If
k=2∗n+1(∀ n∈Z)k = 2*n + 1 \quad (\forall \, n \in \mathbb{Z})
k=2∗n+1(∀n∈Z), then lo is allowed to hold
n+1n+1
n+1 elements, while hi can hold
nn
n elements.
If
k=2∗n(∀ n∈Z)k = 2*n \quad (\forall \, n \in \mathbb{Z})
k=2∗n(∀n∈Z), then both heaps are balanced and hold
nn
n elements each.
This gives us the nice property that when the heaps are perfectly balanced, the median can be derived from the tops of both heaps. Otherwise, the top of the max-heap lo holds the legitimate median.
Adding a number num:
   */
  def getMedian(n: Int): Double = {
    print("inserting " + n)
    //always add new element to maxHeap
    maxHeap.enqueue(n)
    //We need to make sure that at anypoint of time none of the item in maxHeap is greater than
    //any item in minHeap
    //bcs minHeap contains the bigger half of numbers
    //so lets remove the biggest element of maxHeap and add it to minHeap
    minHeap.enqueue(maxHeap.dequeue)
    //make sure that the size of minHeap never exceeds maxHeap
    if (maxHeap.size < minHeap.size) maxHeap.enqueue(minHeap.dequeue())
    val median = if (maxHeap.size == minHeap.size) (maxHeap.head + minHeap.head) / 2
    else maxHeap.head
    println(", median= "+median)
    median
  }
  val medians = Seq(41, 35, 62, 4, 97, 108)
    .map(getMedian)
}
