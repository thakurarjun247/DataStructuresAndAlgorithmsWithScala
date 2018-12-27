package covariancecontravariance

object CovarianceDemo extends App {

  trait TodoList[+A]

  class W

  class X extends W

  class Y extends X

  class ConcreteTodoList[M] extends TodoList[M]

  val wList = new ConcreteTodoList[W]
  val xList = new ConcreteTodoList[X]
  val yList = new ConcreteTodoList[Y]

  def f(list: TodoList[X]) = println("works")

  f(xList)
  f(yList)
  //below won't compile since f only takes
  //ToDoList of type X or TodoList of subtype of X i.e. Y
  //f(wList)

  /*
  If we make the trait def contravariant as below
  trait TodoList[+A]
  then
  f(xList)
  f(zList)
  will compile but, f(yList) won't because
  in case of contravariant f can accept ToDoList of type X
  or TodoList of superType of X i.e. TodoList[W]
  but can't accept TodoList of subtype of X i.e. TodoList[Y]
  isn't acceptable
  */

  /*
  If we make trait invariant i.e. neither +A nor -A
  then only f(xList) will compile all other will fail
   */
  //f(xList)
  //f(yList)
  //f(zList)
}
