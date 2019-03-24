package functionalfeatures.Monads

trait Monad[T[_]] {

  def map[A, B](value: T[A])(f: A => B): T[B]
  def flatMap[A, B](value: T[A])(f: A => T[B]): T[B]
  def pure[A](x: A): T[A]

}


case class OptionTransformer[T[_], A](value: T[Option[A]])(implicit m: Monad[T]) {


  def map[B](f: A => B): OptionTransformer[T, B] = {

    OptionTransformer[T, B](m.map(value)(_.map(f)))

  }


  def flatMap[B](f: A => OptionTransformer[T, B]): OptionTransformer[T, B] = {

    val result: T[Option[B]] = m.flatMap(value)(a => a.map(b => f(b).value)

      .getOrElse(m.pure(None)))

    OptionTransformer[T, B](result)

  }

}
