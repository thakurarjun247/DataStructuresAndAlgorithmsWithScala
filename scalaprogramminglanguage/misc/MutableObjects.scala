package scalaprogramminglanguage.misc
object MutableObjects extends App {
  /*
  *
  Mutation and vars usually go hand in hand,
  but things are not always so clear cut.
  For instance, a class might be mutable without defining or inheriting
  any vars because it forwards method calls to other objects that have mutable state
  . The reverse is also possible: A class might contain vars and still be purely
  functional. An example would be a class that caches the result of an
  expensive operation in a field for optimization purposes
  */
}
