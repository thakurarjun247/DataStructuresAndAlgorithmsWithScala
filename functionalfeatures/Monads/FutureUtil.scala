package functionalfeatures.Monads

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


object FutureUtil {
  implicit val futureMonad = new Monad[Future] {

    //a method that takes  Future[A] and a mapper aToB and returns Future[B]
    def map[A, B](value: Future[A])(f: (A) => B) = value.map(f)


    def flatMap[A, B](value: Future[A])(f: (A) => Future[B]) = value.flatMap(f)


    def pure[A](x: A): Future[A] = Future(x)

  }

  def print[T](future: Future[T]) = future.onComplete {
    case scala.util.Success(value) => println(value)
    case scala.util.Failure(exception) => println("error")
  }

  /*  def print[T](future: Future[Option[T]]) = future.onComplete {
      case scala.util.Success(value) => println(value.getOrElse("None"))
      case scala.util.Failure(exception) => println("error")
    }*/
}
