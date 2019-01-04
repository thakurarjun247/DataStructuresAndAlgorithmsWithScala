package oodesign.buildingblocks

case class Citizen(name: String, age: Int)
abstract class People(gender: String)
case class Male() extends People(gender = "male")
case class Female() extends People(gender = "female")

object FirstClass extends App {
  val list = List(1, 2, 3, 4, 5, 6)
  list.filter(_ > 2).foreach(println)
  val m = new Male
  val f = new Female
  //val people=new People("Arjun",30)
  val p = Citizen("Arjun", 31)
  val p1 = Citizen("Arjun", 31)
  println("SGN")
  val p31 = p.copy(age = 31)
  def foo(p: People) = p match {
    case _: Male => "male"
    case _: Female => "female"
  }
  println(foo(m))
  println(foo(f))
  println(p.age)
  println(p31.age)
  println(p31)
  println(p == p1)
}
