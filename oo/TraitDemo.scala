package oo
trait Drivable{
  def drive:String
  def controlledBy:String="Drivable: controlledBy"
}
trait Streerable{
  def streer: String
  def controlledBy:String="Steerable: controlledBy"
}
trait Vehicle{
  def drive:String
}
trait Engine {
  def drive :String
}
//if methods are abstract no dimond problem e.g. drive method
 class Car extends Vehicle with Engine {
  override def drive="car driven\n"
}

class Truck extends Drivable with Streerable{
  override def drive="Truck driven\n"
  override def streer="Truck steered!\n"
  //will be error at runtime due to dimond problem in concrete method
  //controlledBy hence need to overried it here to avoid ambiguity
  override def controlledBy: String = "Truck: controlledBy Trucker"
}
object TraitDemo extends App{
val car=new Car
  println(car.drive)
  //run time error ahead
  println((new Truck).controlledBy)


}
