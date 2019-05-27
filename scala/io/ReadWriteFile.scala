package scala.io
object ReadWriteFile extends App {
  import java.io.{File, PrintWriter}

  import scala.io.Source
  /*
  * Scala standard library doesn’t contain any classes to write files,
   * so we will use Java IO classes for scala write to file.
   * Below is a simple program showing how to write files in scala.*/
  val printWriter = new PrintWriter(new File("D:\\filereadwrite.scala"))
  printWriter.write("Hello \n Developer \n Welcome to Scala Programming.")
  printWriter.close()
  //writing to file is a sideeffect as write return void
  //reading is supereasy though
  val x = Source
    .fromFile("D:\\filereadwrite.scala")
    .foreach(println)
}
