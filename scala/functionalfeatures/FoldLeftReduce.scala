package scala.functionalfeatures
import scala.util.Random
object FoldLeftReduce extends App {
  //https://oldfashionedsoftware.com/2009/07/30/lots-and-lots-of-foldleft-examples/
  //adding all list elements
  val list = 0 to 5 toList
  val totalFun = list.foldLeft(0)(_ + _)
  //syntax (identity i.e. initial value) (placeholder operator placeholder)
  //or just use identity instead of using 0 in this case in 1 in case
  // of multiplication
  //one less thing to worry about
  //val totalIdentity=list.foldLeft(identity[Integer])(_+_)
  val totalFun2 = list.foldLeft(0)((left, right) => left + right)
  //val counter=list.foldLeft(0)((left,right)=>left+right)
  // val count=list.foldLeft(0){(cnt,0)=>cnt+1)}
  println(s"$totalFun $totalFun2")
  case class Foo(val name: String, val age: Int, val sex: Symbol)
  val fooList = Foo("Hugh Jass", 25, 'male) ::
    Foo("Biggus Dickus", 43, 'male) ::
    Foo("Incontinentia Buttocks", 37, 'female) ::
    Nil
  //get a string with format Salutation Name age
  val tNA = fooList
    .foldLeft("") {
      (a, current) => {
        val title = current.sex match {
          case 'female => "Ms"
          case 'male => "Mr"
        }
        s"$a $title ${current.name} ${current.age} \n"
      }
    }
  // reduceLeft is just a convenience method. It is equivalent to
  //   list.tail.foldLeft(list.head)(_)
  //list.reduceLeft(())
  //string compress
  /*
  list.foldLeft(count){
  (count, curr)=> count+1
  }
  }
   */
  val totalFunReduce = list.reduce(_ + _)
  val totalSumFun = list.sum
  println(tNA)
  println(s"totalFun $totalFun reduce $totalFunReduce listsum $totalSumFun")
  println(s"count is" + list.foldLeft(0)((count, b) => count + 1))
  println(s"sum is" + list.foldLeft(0)((sum, currentItem) => sum + currentItem))
  println("last of list items " +
    list
      .foldLeft(list.head) { (prev, curr) => {
        curr
      }
      })
  //Write a function called ‘penultimate’ that takes a List[A] and returns the penultimate item (i.e. the next to last item) in the list. Hint: Use a tuple.
  def penultimate[A](list: List[A]): A =
    list.foldLeft((list.head, list.tail.head))((r, c) => (r._2, c))._1
  val mulFun = list.foldLeft(1)(_ * _)
  val mulFun2 = list.foldRight(1)(_ * _)
  println(mulFun == mulFun2) //true because * is symmetric operation
  //find min max in a collection
  //min and max functions work in both list and array
  println(s"min ${list.min}")
  println(s"max in array ${list.toArray.max}")
  //create a map out of a list with key as list item and value as frequency
  val listWithDups = List.fill(10)(Random.nextInt(5))
  val map = listWithDups
    .groupBy(identity)
    .mapValues(_.size)
  println(map)
  //more here
  //https://www.ybrikman.com/writing/2013/05/31/10-recipes-for-turning-imperative-java/
}
