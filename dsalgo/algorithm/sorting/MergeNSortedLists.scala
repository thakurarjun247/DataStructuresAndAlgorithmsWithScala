package dsalgo.algorithm.sorting

object MergeNSortedLists extends App{
  import MergeSort.merge
  val lists=List(List(2,4,5), List(3,6,9), List(-1,0,9))
  //merge with foldLeft
  lists
    .foldLeft(List[Int]())((big, current)=> merge(big, current))
    .foreach(println)
  //merge smallest lists first
  //Use min heap to store the lists and then do something similar
  //to huffman coding
}
