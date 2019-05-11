package datastructure.matrix
/*
https://www.geeksforgeeks.org/find-number-of-islands/
Find the number of islands | Set 1 (Using DFS)

Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
Example:
Input : mat()() = (Array(1, 1, 0, 0, 0),
                   Array(0, 1, 0, 0, 1),
                   Array(1, 0, 0, 1, 1),
                   Array(0, 0, 0, 0, 0),
                   Array(1, 0, 1, 0, 1) )
Output : 5
This is a variation of the standard problem: “Counting the number of connected components in an undirected graph”.

 */
object NumberOfIsalnds {
  def main(args: Array[String]): Unit = {
    val a = Array(
      Array(1, 1, 0, 0, 0),
      Array(0, 1, 0, 0, 1),
      Array(1, 0, 0, 1, 1),
      Array(0, 0, 0, 0, 0),
      Array(0, 0, 0, 0, 0))
    println(f(a))
  }
  def f(a: Array[Array[Int]]): Int = {
    val maxRowIndex = a.size - 1
    val maxColumnIndex = if (a.size == 0) -1 else a(0).size - 1
    val v = Array.ofDim[Boolean](maxRowIndex + 1, maxColumnIndex + 1)
    f(a, v, maxRowIndex, maxColumnIndex)
  }
  private def f(a: Array[Array[Int]], v: Array[Array[Boolean]], maxRowIndex: Int, maxColumnIndex: Int): Int = {
    var ans = 0
    val x = Array(-1, -1, -1, 0, 1, 1, 1, 0)
    val y = Array(-1, 0, 1, 1, 1, 0, -1, -1)
    for (row <- 0 to maxRowIndex)
      for (col <- 0 to maxColumnIndex) {
        if (a(row)(col) == 1 && !v(row)(col)) {
          ans += 1
          (0 to 7)
            .toList
            .foreach(
              index => if (isEligibleToVisit(a, v, x(index), y(index), maxRowIndex, maxColumnIndex))
                v(x(index))(y(index)) = true
            )
        }
        //ans += 1
      }
    ans
  }
  private def isEligibleToVisit(a: Array[Array[Int]], v: Array[Array[Boolean]], currentRow: Int, currentColumn: Int, maxRowIndex: Int, maxColumnIndex: Int) = {
    val bool = currentRow > -1 && currentRow <= maxRowIndex && currentColumn > -1 && currentColumn <= maxColumnIndex && a(currentRow)(currentColumn) == 1
    if (bool) !v(currentRow)(currentColumn) else false
  }
}
