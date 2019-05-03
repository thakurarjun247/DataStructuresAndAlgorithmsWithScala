package scalaprogramminglanguage.collection
object StringOps extends App {
  //Predef has implicit conversation from String -> StringOps
  "abcd"
    .exists(_.isUpper)
  //since string doesn't have exists method it's converted to StrOps
}
