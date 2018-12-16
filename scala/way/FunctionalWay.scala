package scala.way

object FunctionalWay extends App{
//adding all list elements

  val list = List(1,1,2,3,4, 3)

  var total:Int = 0
  list.foreach { item=> total=total+item }

  val totalFun=list.foldLeft(0)(_+_)
  //syntax (identity i.e. initial value) (placeholder operator placeholder)

  //or just use identity instead of using 0 in this case in 1 in case of multiplication
  //one less thing to worry about
  //val totalIdentity=list.foldLeft(identity[Integer])(_+_)


  val totalFunReduce=list.reduce(_+_)
  val totalSumFun=list.sum
  println(s"totalFun $totalFun reduce $totalFunReduce listsum $totalSumFun")

  val mulFun=list.foldLeft(1)(_*_)
  val mulFun2=list.foldRight(1)(_*_)
  println(mulFun==mulFun2) //true because * is symmetric operation

  //find min max in a collection
  //min and max functions work in both list and array
  println(s"min ${list.min}")
  println(s"max in array ${list.toArray.max}")

  //create a map out of a list with key as list item and value as frequency
  val map=list
    .groupBy(identity)
    .mapValues(_.size)
  println(map)

  println(list
    .map(doubleIt))

  def doubleIt(i:Int)=2*i

  //more here
  //https://www.ybrikman.com/writing/2013/05/31/10-recipes-for-turning-imperative-java/

}
