package scalaprogramminglanguage.oodesign.buildingblocks
object ParkingLot extends App {
  val car1 = PessangerCar("2345")
  //All pessanger cars have default spots needed as 2 however we can always
  //override the defaults
  val car2 = PessangerCar("1234", 4)
  val bus1 = TouristBus
}
//the val and var are evaluated when defined,
//while def is evaluated on call.
//https://alvinalexander.com/scala/fp-book-diffs-val-def-scala-functions
trait Automobile {
  //common to all automobiles
  val registrationNumber: String
  val spotsNeeded: Int = 2
}
case class PessangerCar(override val registrationNumber: String, override val spotsNeeded: Int = 4)
  extends Automobile
case class TouristBus(registrationNumber: String) extends Automobile {
  override val this.registrationNumber = registrationNumber
}
/*abstract class PessangerCar(registrationNumber: String,var  spotsNeeded: Int=2)
  extends Automobile {

}*/
/*abstract class TouristBus(registrationNumber: String, spotsNeeded: Int=4) extends Automobile {

}*/
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

