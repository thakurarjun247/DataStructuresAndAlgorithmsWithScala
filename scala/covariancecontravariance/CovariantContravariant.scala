package scala.covariancecontravariance
//sealed trait List[+T]
//List will take items of type T and its subtypes
/*
val list=List[Dog]()
    val p=new Puppy
    p::list
*/
class Animal[+T](val animal: T)
//Animal will take type T and it's subtypes
class Dog
class Puppy //extends Dog
//Animal carer will take type Dog and it's subtypes
class AnimalCarer[Dog](val dog: Animal[Dog])
object CovariantContravariant {
  def main(args: Array[String]) {
    //      | </person>
    val puppy = new Puppy
    val dog = new Dog
    val puppyAnimal: Animal[Puppy] = new Animal[Puppy](puppy)
    val dogAnimal: Animal[Dog] = new Animal[Dog](dog)
    //Animal carer will take type Dog and it's subtypes
    val dogCarer = new AnimalCarer(dogAnimal)
    val puppyCarer = new AnimalCarer(puppyAnimal)
    println("Done.")
  }
}
