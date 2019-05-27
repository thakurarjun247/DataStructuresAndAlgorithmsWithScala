package dsalgo.algorithm.dynamicprogramming

import dsalgo.datastructure.matrix.Matrix2DArray

import scala.collection.mutable
object AllMatrixPaths extends App {
  /*
  The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell you can either move only to right or down
Examples :
Input :  m = 2, n = 2;
Output : 2
There are two paths
(0, 0) -> (0, 1) -> (1, 1)
(0, 0) -> (1, 0) -> (1, 1)

Input :  m = 2, n = 3;
Output : 3
There are three paths
(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
   */
  /*
    assert(f(Array.ofDim[Int](0,0))==0)
    assert(f(Array.ofDim[Int](1,1))==1)
    assert(f(Array.ofDim[Int](2,2))==2)
    assert(f(Array.ofDim[Int](2,3))==3)*/

  f(Array.ofDim[Int](10, 10)) == 3
  //TODO: f is a delegating method which delegates to fNoMemo and fMemo
  //TODO: get rid off this delegator
  def f(m: Array[Array[Int]]): Int = {
    println("\ninput matrix: ")
    Matrix2DArray.traverseMatrix(m, print)
    if (m.isEmpty) return 0
    val rows = m.length
    val columns = if (rows == 0) 0 else m(0).length
    fNoMemo(m, rows, columns)
    fMemo(m, rows, columns, mutable.Map[Location, Int]())
  }
  def fNoMemo(m: Array[Array[Int]], rows: Int, columns: Int): Int = {
    //if the matrix has only one row or column there is only 1 way to reach from start to end
    if (rows == 1 || columns == 1) 1
    else fNoMemo(m, rows, columns - 1) + fNoMemo(m, rows - 1, columns)
  }
  def fMemo(m: Array[Array[Int]], rows: Int, columns: Int, memo: mutable.Map[Location, Int]): Int = {
    //if the matrix has only one row or column there is only 1 way to reach from start to end
    if (rows == 1 || columns == 1) return 1
    if (!memo.contains(Location(rows, columns)))
      memo += Location(rows, columns) -> (fMemo(m, rows, columns - 1, memo) + fMemo(m, rows - 1, columns, memo))
    memo(Location(rows, columns))
  }
  case class Location(rows: Int, columns: Int)
  //val map=mutable.Map[Location, Int]
}
