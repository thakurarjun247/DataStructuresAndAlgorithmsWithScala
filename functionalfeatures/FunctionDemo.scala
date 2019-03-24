package functionalfeatures

object FunctionDemo extends App{
        val sum=(a:Int,b:Int,c:Int)=>a+b+c
        val paf=sum(1,2,_:Int)
        val result=paf(3)
        println(result)
        val pafNoArgs=sum
        val added=pafNoArgs(1,2,3)
        print(added)

        val list=List(1,10)
        list.foreach(println)
        val more=list.foreach(paf)
        println(s"more $more")


        }
