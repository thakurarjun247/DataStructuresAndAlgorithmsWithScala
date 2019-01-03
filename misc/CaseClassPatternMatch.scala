package misc

class CaseClassPatternMatch extends App{
  trait Person
  case class Man() extends Person
  case class Woman() extends Person

  def find(p:Person)=p match
    {
    case _:Man=>println("male")
    case _:Woman=>println("female")
  }
}
