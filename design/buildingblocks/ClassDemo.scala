package design.buildingblocks
//we can use a case class here
//don't remove val from here
class Person(val name:String, val age:Int){
  override def toString= s"name: $name age: $age"
}
object ClassDemo extends App{
  //if perons is a case class new keyword is optional
val p1=new Person("adult", 32)
  val p2=new Person("teen", 14)
 val people=List(p1, p2)
  val (minor, adult)=people.partition(_.age<18)
  println(s"$minor $adult")
}
