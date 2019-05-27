package scala.oodesign.buildingblocks
object PatternMatching extends App {
  val list = List(1, 2, 3, 4)
  println(list)
  println(list.map(isEven))
  def isEven(n: Int) = {
    val i = n % 2
    i match {
      case 0 => true
      case _ => false
    }
  }
}
