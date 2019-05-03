package scalaprogramminglanguage.functionalfeatures.Implicits
object FindImplicitVarInScope extends App {
  def greet(implicit name: String) = println(s"Hello $name")
  /*
  The final parameter list on a method can be marked implicit,
  which means the values will be taken from the context in which they are called.
   If there is no implicit value of the right type in scope, it will not compile.
    Since the implicit value must resolve to a single value and to avoid clashes,
    it's a good idea to make the type specific to its purpose, e.g.
  don't require your methods to find an implicit String!
  */
  //greet
  //error no implicit param found
  val myName = "Arjun"
  //greet
  //same error becuase the greet method needs a string
  //variable which is implicit
  implicit val impName = "Arjun"
  greet
  //works
  //uncomment below and compiler confued
  //ambiguous implicit vals,
  //implicit val country="India"
  greet
  // probably in a library
  class Prefixer(val prefix: String)
  def addPrefix(s: String)(implicit p: Prefixer) = println(p.prefix + s)
  // then probably in your application
  implicit val myImplicitPrefixer = new Prefixer("***")
  addPrefix("abc") // returns "***abc"
}
