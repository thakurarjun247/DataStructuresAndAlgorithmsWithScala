package scala.concurrency
class BankAccount(var balance: Int) {
  //see https://medium.freecodecamp.org/still-using-synchronized-try-akka-actor-instead-ac2f2b22a9ed
  //refer https://www.chrisstucchio.com/blog/2013/actors_vs_futures.html
  def withdraw(deduct: Int) = {
    synchronized {
      if (deduct <= balance) {
        balance -= deduct
        deduct
      }
      else 0
    }
  }
  /*
  We have a SlaveActor that does the work and BossActor
  that orders the slave around. First, notice the ! sign or
  tell. This is one of two methods (the other is ask) for
  an actor to asynchronously send a message to another actor.
  tell in particular does so without waiting for a reply.
  So the boss tells the slave to do two withdraw orders
  and immediately leaves. These messages arrive in the
  slave’s receive where each one is popped and matched with
  the corresponding handler. In this case, Withdraw
  executes the withdraw method from the previous example
  and deducts the requested amount from state x. After it
  is done, the actor proceeds to the next message in the
  queue.
  */
  /*  class BossActor extends Actor {
      var slave = context.actorOf(Props[SlaveActor])
      //Hey slave withdraw 6
      slave ! Withdraw(6)
      slave ! Withdraw(9)
    }
    case class Withdraw(deduct: Int)
    class SlaveActor extends Actor {
      var x = 10;
      def receive: Receive = {
        case Withdraw(deduct) => val r = withdraw(deduct)
      }
    }*/
}


