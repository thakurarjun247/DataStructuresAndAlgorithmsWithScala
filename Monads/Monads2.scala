package Monads
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Monads2 extends App{
  //https://medium.com/coding-with-clarity/practical-monads-dealing-with-futures-of-options-8260800712f8
  val futOpt1:Future[Option[Int]]=Future{Option(1)}
  val futOpt2:Future[Option[Int]]=Future{Option(2)}

  val futOpt3:Future[Option[Int]]=futOpt1
    .map(_.map(_+2))
  //if there are multiple such things
  val futOpt4:Future[Option[Int]]=for{
    optOne<-futOpt1
    optTwo<-futOpt2
    } yield for{
    one <- optOne
    two <- optTwo
  } yield one+two
  implicit val futureMonad = new Monad[Future] {

    def map[A, B](value: Future[A])(f: (A) => B) = value.map(f)


    def flatMap[A, B](value: Future[A])(f: (A) => Future[B]) = value.flatMap(f)


    def pure[A](x: A): Future[A] = Future(x)

  }
/*  val futOpt5=for{
    optOne<-OptionTransformer(futOpt1)
    optTwo<-OptionTransformer(futOpt2)
  } yield for{
    one <- optOne
    two <- optTwo
  } yield one+two*/

  FutureUtil.print(futOpt4)
  println(1)
}
