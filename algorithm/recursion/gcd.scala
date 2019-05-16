package algorithm.recursion

object gcd extends App{
  assert(gcd(34,85)==17)
  assert(gcd(0,1)==1)
  def gcd(a:Int, b:Int):Int= if(b==0) a else gcd(b, a%b)

}
