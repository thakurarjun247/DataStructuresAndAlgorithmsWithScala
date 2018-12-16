package collection
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object MapVsFlatMap extends App{
        def getFileNameFromDB(id:Int):Future[String]={Thread.sleep(5000)
        Future{"gotFileNameFromDB "+id}
        }
        def downloadFile(fileName:String):Future[String]={Thread.sleep(5000)
        Future{"downloadedFile "+fileName}
        }
        def processFile(file:String):Future[Option[String]]={Thread.sleep(5000)
        Future{Some("processed "+file)}
        }

        val futProcessed:Future[Option[String]]=
        getFileNameFromDB(1)
        .flatMap(name=>downloadFile(name))
        .flatMap(downloaded=>processFile(downloaded))

        futProcessed.onComplete{
        case scala.util.Success(value)=>println(value)
        case _=>println("failed")
        }

        val futResult:Future[Option[String]]=
        for{
        name<-getFileNameFromDB(1)
        file<-downloadFile(name)
        result<-processFile(file)
        }yield result

        //Await.result(futResult, Duration(15))
        println("done")
        }
