package design.buildingblocks

case class Person(name: String, age: Int)

object FirstClass extends App {
  val list = List(1, 2, 3, 4, 5, 6)
  list.filter(_ > 2).foreach(println)
  val m = new Male
  val f = new Female
  //val people=new People("Arjun",30)
  val p = Person("Arjun", 31)
  val p1 = Person("Arjun", 31)

  println("SGN")
  val p31 = p.copy(age = 31)

  def foo(p: People) = p match {
    case man: Male => "male"
    case man: Female => "female"
  }

  println(foo(m))
  println(foo(f))

  abstract class People(gender: String)

  case class Male() extends People(gender = "male")

  // println(people.age)


  println(p.age)

  case class Female() extends People(gender = "female")

  println(p31.age)
  println(p31)
  println(p == p1)

}

