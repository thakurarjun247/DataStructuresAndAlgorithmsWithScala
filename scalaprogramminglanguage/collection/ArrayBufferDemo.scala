package scalaprogramminglanguage.collection
import scala.collection.mutable.ArrayBuffer
object ArrayBufferDemo extends App {
  //all the ops of scala/Java array available here.
  //don't need to mention the size beforehand
  //new Array will be created for holding elements
  //can add/remove elements
  val buf = ArrayBuffer[Int]()
  //add 1 to buffer
  buf += 1
  //replace 1 from index 0
  buf(0) = 0
  //exception
  //buf(1)=1
  print(buf)
}
