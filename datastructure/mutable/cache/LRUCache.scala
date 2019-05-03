package datastructure.mutable.cache
import datastructure.mutable.linkedlist.DoublyLinkedList.{DoublyLinkedList, Node}
//TODO: replace LRU item if it's a miss
class LRUCache(maxCacheSize: Int) {
  /*  override def toString:String={
      map.toString + " " + q.toString
    }*/
  var currentCacheSize = 0
  //A doubly LL to maintain LRU order
  //LRU item will be on the tail of LL so that it can be found and
  //deleted in O(1)
  //Each LL node is a tuple which stores(key, value)
  //if cache seek is a hit still we will be able to move the item to head
  //in O(1) i.e. 1 time
  val q = new DoublyLinkedList
  //put k,v pairs in map as well for O(1) lookup
  val map = scala.collection.mutable.Map[String, Node]()
  def seek(key: String): String = {
    //miss
    if (!map.contains(key)) {
      println(s"key= $key, that's a miss")
      val value = dbLookup(key)
      val node = Node((key, value))
      clearLRU
      currentCacheSize = currentCacheSize + 1
      map += (key -> node)
      q.insertNodeAtHead(node)
    }
    val node = map(key)
    q.moveNodeToFront(node)
    val value = node.key._2
    println(key + " -> " + value)
    value
  }
  def clear = {
    q.clear
    map.clear
  }
  def dbLookup(key: String) = "valueOfKey" + key
  def clearLRU() = {
    if (currentCacheSize >= maxCacheSize) {
      //TODO: fix null returned from deleteTail
      val tail = q.tail
      println(s"cache is full, deleting ${q.tail} ...")
      q.deleteTail
      currentCacheSize -= 1
      map.remove(tail.key._1)
    }
  }
}
