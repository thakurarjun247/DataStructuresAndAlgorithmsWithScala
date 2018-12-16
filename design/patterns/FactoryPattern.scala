package design.patterns

trait Animal {
  def speak: String
}

object AnimalFactory {

  private class Cat extends Animal {
    override def speak = "meow"
  }

  private class Dog extends Animal {
    override def speak = "bho bho"
  }

  def apply(s: String) = s match {
    case "cat" => new Cat
    case "dog" => new Dog
    case _ => throw new IllegalArgumentException(s"invalid animal name")

  }
}

object Application extends App {
  val dog = AnimalFactory("dog")
  println(dog.speak)
  println(AnimalFactory("cat").speak)
  //println(AnimalFactory("invalid").speak)
}
