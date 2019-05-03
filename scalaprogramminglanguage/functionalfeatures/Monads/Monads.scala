package scalaprogramminglanguage.functionalfeatures.Monads
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
object Monads extends App {
  // Imports Future and ExecutionContext
  val list = List.fill(3)(5)
  def doubleIt(x: Int) = 2 * x
  //val doubleMe (y: Int)=>2*x
  //foreach is all about sideEffects
  //so it won't return a list
  val l1: Unit = list.foreach(item => doubleIt(item))
  ///while map does return one
  val doubledList: List[Int] = list.map(doubleIt)
  val listListInt = List(list, doubledList)
  //map vs flatMap
  //map doubles items of inner lists
  println(listListInt.map(_.map(doubleIt)))
  //flat flattens it
  println(listListInt.flatMap(item => item.map(doubleIt)))
  //flatMap is basically flatten andThen map
  println(
    listListInt
      .flatten
      .map(doubleIt)
  )
  println(
    //listListInt.map(item=>doubleIt(item))
  )
  //If you are getting Future[Future[Int]] it's a good indication to use
  //flatMap instead of Map
  val futFutInt: Future[Future[Int]] = Future {
    42
  }.map(fut => Future(fut))
  val futInt: Future[Int] = Future {
    42
  }.flatMap(fut => Future(fut))
  //practical use of flatMap: avoid future of future
  case class Address(city: String)
  case class User(name: String)
  val u = User("Arjun")
  def getUser(name: String): Future[User] = Future {
    User(name)
  }
  def getAddress(user: User) = Future {
    Address("Dewas")
  }
  def getCityFlatMap(name: String) = getUser(name)
    .flatMap(user => getAddress(user))
    .map(address => address.city)
  //for comprehension is syntax sugar for flatmap
  //remember in forComp the last arrow is a map so
  //above is equivalent to
  def getCityForComp(name: String) = for {
    user <- getUser(name)
    address <- getAddress(user)
  } yield address.city
  //warning: below will give future of Nothing so don't use it, won't compile
  /*  def getCityByUserNameWithForComp2(name: String) = for {
      user <- getUser(name)
      address <- getAddress(user)
      city <- address.city
    } yield city*/

  FutureUtil.print(getCityFlatMap("Arjun"))
  FutureUtil.print(getCityForComp("Arjun"))
  //monads can do F[F[A]] => F[A]
  val futSeqInt: Future[Seq[Int]] = Future {
    Seq(1, 2, 3)
  }
  println(futSeqInt
    .map(list =>
      list.map(doubleIt)))
  //monad way
  /*  def getUserOpt(name: String): Future[Option[User]] = Future {
      Some(User(name))
    }

    def getAddressOpt(user: User) = Future {
      Some(Address("Dewas"))
    }*/
  /*
    def getCity(name:String):Future[String]=for{
      user <- OptionT(getUser(name))
      address <- OptionT(getUser(name))
    }*/
}
