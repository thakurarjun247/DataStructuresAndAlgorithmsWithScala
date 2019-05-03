package onlinecodingtest
object Sequence extends App {
  println(solution(2, 5))
  print(solution(5, 3))
  def solution(countA: Int, countB: Int) = {
    var (longCount, shortCount, longSeq, shortSeq) = if (countA > countB) (countA, countB, "a", "b")
    else (countB, countA, "b", "a")
    val output = new StringBuilder
    do if (longCount == shortCount + 1) {
      output.append(longSeq)
      longCount -= 1
    }
    else if (longCount == shortCount) {
      output.append(longSeq)
      longCount -= 1
      output.append(shortSeq)
      shortCount -= 1
    }
    else {
      output.append(longSeq)
      output.append(longSeq)
      longCount -= 2
      if (shortCount > 0) {
        output.append(shortSeq)
        shortCount -= 1
      }
    } while ( {
      longCount > 0
    })
    output.toString
  }
}
