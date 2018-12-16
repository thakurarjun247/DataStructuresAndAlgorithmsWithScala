package misc;

object Monads extends App{
// Imports Future and ExecutionContext

// Our user type
  case

class User(id:Long,name:String)

        // Reads a username from a fictitious database
     //   def getUser(id:Long):Option[User]=???
     //   def getEmail(user:User):String=???
        // This method send an email asynchronously
    //    def sendEmail(email:String):Future[Option[Boolean]]=???

        // This will not typecheck!
/*  val success: Future[Option[Int]]=for {
    user <- getUser(42)
    email = getEmail(user)
    success <- sendEmail(email)
  } yield success*/
        }
