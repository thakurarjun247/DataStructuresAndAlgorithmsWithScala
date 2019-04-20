package matrix
object Matrix2DArray extends App{

  //Matrix
  //https://alvinalexander.com/source-code/scala/how-create-and-use-multi-dimensional-arrays-2d-3d-etc-scala

  //note Int is mandatory in below syntax or no need for compiler
  //to know the type
  val rows=2
  val columns=4
  val m:Array[Array[Int]]=Array.ofDim[Int](rows,columns)

  for(i <- 0 to m.length-1)
    for(j <- 0 to m(0).length-1)
      m(i)(j)=scala.util.Random.nextInt(75)


def traverseMatrix(m:Array[Array[Int]], f: Any=>Unit): Unit = {
  if (m.nonEmpty)
    for (i <- 0 to m.length - 1) {
      println()
      for (j <- 0 to m(0).length - 1)
        print(m(i)(j) + " ")
    }
}

  println("\nprint with for compre...")
  for{
    i <- 0 to rows-1
    j <- 0 to columns-1
  } print(m(i)(j)+" ")

  val matrixMyStyle:Array[Array[Int]]=Array(Array(0,1), Array(2,3))
}
