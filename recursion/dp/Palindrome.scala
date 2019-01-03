package recursion.dp

object Palindrome extends App{
val list=List("01210", "0110" , "", "qwer")
 isPalin(null)
  list.foreach(item=>println(item+" "+isPalin(item)))
  println(isPalin("0110"))
  println(isPalin(""))
  def isPalin(s:String):Boolean={
   if(s==null) false
   else if (s.length<=1 ) true
   else if(s.last!=s.head) false
    else isPalin(s.substring(1,s.length-1))


  }

}
