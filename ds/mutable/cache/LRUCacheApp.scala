package ds.mutable.cache

object LRUCacheApp extends App{
  val cache=new LRUCache(2)
  cache.seek("one")
  cache.seek("two")
  cache.seek("one")
  cache.seek("four")
  cache.seek("four")
  println()
}
