package scalaprogramminglanguage.oodesign.buildingblocks
case class Citizen(name: String, age: Int)
abstract class People(gender: String)
case class Male() extends People(gender = "male")
case class Female() extends People(gender = "female")
object FirstClass extends App {
  val list = List(1, 2, 3, 4, 5, 6)
  list.filter(_ > 2).foreach(println)
  val maleObject = new Male
  val femaleObject = new Female
  //val people=new People("Arjun",30)
  val citizenArjun31 = Citizen("Arjun", 31)
  val anotherCitizenArjun31 = Citizen("Arjun", 31)
  println("SGN")
  val citizenArjun31Copy = citizenArjun31.copy(age = 31)
  def foo(p: People) = p match {
    case _: Male => "male"
    case _: Female => "female"
  }
  println(foo(maleObject))
  println(foo(femaleObject))
  println(citizenArjun31.age)
  println(citizenArjun31Copy.age)
  println(citizenArjun31Copy)
  println(citizenArjun31 == anotherCitizenArjun31)
}
