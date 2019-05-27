package dsalgo.datastructure.arraystring
object IsStringUniqueChar extends App {
  println(check("abcde"))
  println(check("abb"))
  def check(s: String): Boolean = {
    //dont use below, it create array of len 1 with 256 converted to char as the
    //only element
    //val a=Array[Char](256)
    //use new keyword
    // val a=new Array[Char](256)
    //or just fill
    val a = Array.fill(256)(false)
    if (s.length > a.length) return false
    else {
      s
        .map(_.toInt)
        .foreach { i =>
          if (a(i)) return false
          else a(i) = true
        }
    }
    true
  }
}
