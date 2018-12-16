package collection

object String extends App{
  val text="Hi! Arjun. here, you go"
  val wordsArray = text.split("[ !,.]+")
  //It indicates the string should be split at each place that one or
  // more space and/or punctuation i.e. ! or , or . characters exist
  println(wordsArray.foreach(println))
  val s="01234"
  println(s"${s.head} ${s.tail} ${s(3)}")
  //split at gives tuple
  val (x,y)=s.splitAt(2)
  println(s"$x $y")

s.toCharArray foreach println
  val a=s.toList.toArray
  print(a)
  println()
  println("even array has head and tail "+s"head is ${a.head} and tail is:")
  val aHead:Char=a.head
  val aTail:Array[Char]=a.tail
  aTail foreach(print)


}
