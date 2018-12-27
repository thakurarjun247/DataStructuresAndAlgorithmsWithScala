package covariancecontravariance

object CovarianceDemo extends App{
  trait TodoList[+A]
  class X(x:Int)
  class Y(y:Int) extends X(y)

  class ConcreteTodoList[M] extends TodoList[M]
  val xList=new ConcreteTodoList[X]
  val yList=new ConcreteTodoList[Y]

  def f(list: TodoList[X])=println("works")

  f(xList)
  //this line won't compile if you remove + from trait
  //declaration in i.e. at trait TodoList[+A]
  // f(yList)

}
