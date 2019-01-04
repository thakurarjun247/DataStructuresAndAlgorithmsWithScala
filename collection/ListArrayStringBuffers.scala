package collection

import scala.collection.mutable.{ArrayBuffer, ListBuffer, Map}

object ListArrayStringBuffers extends App{

        //creating
        val string="123"
        val list=List(1,2,3)
        val array=Array(1,2,3)
        val arrayBuffer= ArrayBuffer[Int]()
        val arrayBuffer1:ArrayBuffer[Int]=ArrayBuffer(1,2,3)
        val listBuffer= ListBuffer[Int]()
        val listBuffer1=ListBuffer(1,2,3)

        //size and length both are supported by all of them
        println(string.length)
        println(string.size)
        println(list.size)
        println(list.length)
        println(array.length)
        println(array.size)
        println(arrayBuffer.length)
        println(arrayBuffer.size)
        println(listBuffer.length)
        println(listBuffer.size)

        //traverse => always use foreach method
        //foreach method is member of iterableLike trait
        //def foreach(A => Unit):Unit
        //it's applicable to both mutable and immutbale structures
        //applicable to all the 5 types above

        //Reading value of a given index
        //all of them can be read with (indexNumber) method
        //string can also be read with charAt method
        //all java string methods are applicable here because under the hood
        //they are one and the same
        /*
         * package scala
         * object Predef extends scala.LowPriorityImplicits {
         * type String = java.lang.String
         * }
         */

        var v=0
        v=array(2)
        v=list(1)
        v=arrayBuffer1(2)
        println("string"(2))
        println("01234"(2))
        println("string".charAt(2))
        println("01234".charAt(2))
        v=listBuffer1(2)

        //accessing in more functional way, head tail work everywhere
        println(list.head)
        println(list.tail)
        println(array.head)
        println(string.tail)

        //append
        //string immutable hence can't append
        //List same as string can't append will get a new list if tried to
        //list+=5 wont work
        //list is internally an LL
        // it can be prepended though
        0::list
        println(list)


        //Buffers have special method += for adding elemnts
        listBuffer+=2

        arrayBuffer+=(4,5,6)
        println(arrayBuffer)

        //printing: println works on all of them except array, works on buffer as well
        array foreach println

        //replace/update a value
        //string is immut so use substrings
        //unlike java list doesn't have replace method


        array(2)=10 //careful about indexoutofbounds
        array foreach println

        //delete at an index
        val index=1
//        listBuffer.remove(index)
   //     arrayBuffer.remove(index)
        //array, list, string doesn't have remove method

        // list.drop(2) //drops first 2 elements
        //list.take(1)

        val m=Map(1->1,2->2)
        //concatenate buffers use ++
  val firstLB=new ListBuffer[Int]()
  val secondLB=new ListBuffer[Int]()
  firstLB+=1
  secondLB+=2
  //++ can concatenate all the iterable collections
  //::: specific to lists
  val t=firstLB++secondLB
  println(t==firstLB)
  println(t)
//:: operator
  //

  def examineList[T](list:List[T])=list match{
    case head::tail=>println(s"$head $tail")
    case Nil => println("empty list")
  }
  val emptyList=List.empty
  examineList(emptyList)
  examineList(list)

        }
