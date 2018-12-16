package misc


//contains some of the important type/alias/implicit
//definitions of scala.Predef
object Predef {
  type Set[A] = scala.collection.immutable.Set[A]
  val Set=scala.collection.immutable.Set
  /*
  The "type" keyword is used in Predef to define
  Set and Map as aliases for the longer fully qualified names of
   the immutable set and map traits
   The vals named Set and Map are initialized to refer to the
   singleton objects for the immutable Set and Map.


  */
}
