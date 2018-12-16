package recursion.dp

import scala.collection.mutable.ListBuffer
object PermutationsUniqueChars extends App {
  val list=new ListBuffer[String]()
  println(perm("123").groupBy(_.charAt(0)))

  def perm(s:String/*, list: ListBuffer[String]*/):List[String]={
    val list=new ListBuffer[String]()
    if(s.isEmpty) list.toList
    else  if (s.length() == 1)  List(s)
    else {


      val remainderPerms:List[String]=perm(s.substring(1))
      remainderPerms
          .foreach{
            string=>val putatAll=putAtAllFunctional(s.charAt(0), string)
              putatAll.foreach(put=>list+=put)
          }
      list.toList
    }
  }

  def putAtAllImperative(c:Char, s:String):List[String]={
    val list=new ListBuffer[String]()
    for(i <- 0 to s.length){//notice we iterate till s.length so that we
      //don't have to manually  do the list+=s+c
      list+=s.substring(0,i)+c+s.substring(i)
     }

    list.toList
  }

  def putAtAllFunctional(c: Char, s:String):Seq[String]=
    for(i <- 0 to s.length)
      yield
        s.substring(0,i)+c+s.substring(i)

  }
