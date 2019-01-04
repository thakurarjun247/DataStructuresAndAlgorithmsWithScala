package collection

object Map1 extends App{

  //only while creating buffers (arraybuf and listbuf) we need to use new keyword
  //other than that there is no use of new keyword in collections/maps/sets/list
  // be it mutable or immutable

  val mutMap=scala
    .collection
    .mutable
    .Map[Int,Int](0->0,1->1,2->2)

  val map=mutMap.toMap
  //https://docs.scala-lang.org/overviews/collections/maps.html
  //popular methods apply, get, getOrElse, contains, and isDefinedAt

  //All the methods here are applicable to both the mut as well
  //as immut maps, unless stated

  //get returns Option[String]
  val valOpt=map get 1
  val valOptMut=mutMap get 1

  //apply returns value (not wrapped) exception is thrown otherwise
  println(map apply 1)
  // it is same as
  println(map(1))

  //getOrElse(k,d) return value (not wrapped in Some()) or default value d
  println(map getOrElse(10,"not present"))
  println(map getOrElse(1,"not present"))
  //headsup: exception
  //println(map apply 3)

  //add/update elements
  //+, ++, updated

  //+ returns a new map with k,v pair added in it
  //however since map is immmut it will return a new map with pair added
  //better to use mutMap here
  val map2=map+(3->"three")

  //can add multiple pairs like this
  val map3=map2+(4->"four",5->"five")
  mutMap+=(50->50)
  //mutMap+=(6,6) not working
  println(s"mutMap is $mutMap")

  // updated method is same as + hence it can be rewritten
  val map4=map2+(4->"four",5->"five")

  //true
  println(map3==map4)

  val map5=Map(4->"four",6->"six")

  //++ concatenates two maps and removes dups
  val map6=map4++map5
  println(map6)

  // map - k remove pair with key k
  val map7=map-1
  println("map7: "+map7)
  //can remove multiple keys
  val map8=map5-(1,2,3)
  //tuple can be added subtracted with a single - For adding removing
  //on collection use -- double minus
  val map99=map7--map5.keys

  //-- subtract one map from other


  //iterating, always stick to one style, tuples are good for now


  map.keys.foreach(println) //print all keys
  map.keySet.size
  //val i: Int =map.  values // print all values
  println("iterating example")
  val m=scala.collection.mutable.HashMap[Int,Int](1->1,2->2)
  println(m)
  // 1 and 2 represent k and v respectively, pair is kv pair
  //ditch this style of updating elements always use map+=(k->v) style
  //m.foreach(pair=>m(pair._1)=pair._2+1)

  println("always use map+=(k->v) style")
  m.foreach(pair=>m+=(pair._1 ->(pair._2+1)))

  println(m)

  println("changing immut map..")

  //won't compile
  //map.foreach(pair=>map(pair._1)=pair._2+1)

//to avoid confusion never use the following
  val keysIterator=map.keysIterator
  val valuesIterator=map.valuesIterator
  //recommended to use iterable and not iterator(mutable)
  val iterableInt=map.keys
  val iterableValues=map.values
  val keySet=map.keySet
  //I think gives same map
  val seq=map.seq
  print(s"seq $seq")

  println(s"map $map")
  //ms filterKeys p	=> A map view containing only those mappings in ms where the key satisfies predicate p.
  //ms mapValues f	=> A map view resulting from applying function f to each value associated with a key in ms.


}
