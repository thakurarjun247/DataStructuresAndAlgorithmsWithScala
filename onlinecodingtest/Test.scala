package onlinecodingtest
object Test extends App {
  val a = Array(-3, -14, -5, 7, 8, 42, 8, 3);
  println(solution(a))
  case class Season(name: String, amp: Int)
  def solution(t: Array[Int]): String = {
    val len = (t.length) / 4
    val win = getMinAndMax(t.slice(0, len))
    val spr = getMinAndMax(t.slice(len, 2 * len))
    val sum = getMinAndMax(t.slice(2 * len, 3 * len))
    val aut = getMinAndMax(t.slice(3 * len, 4 * len))
    val winter = Season("WINTER", getAmplitute(win._2, win._1))
    val spring = Season("SPRING", getAmplitute(spr._2, spr._1))
    val summer = Season("SUMMER", getAmplitute(sum._2, sum._1))
    val autumn = Season("AUTUMN", getAmplitute(aut._2, aut._1))
    val list = List(winter, spring, summer, autumn).sortBy(_.amp)
    list(3).name
  }
  def getAmplitute(min: Int, max: Int): Int = math.abs(max - min)
  def getMinAndMax(a: Array[Int]): (Int, Int) = {
    a.foldLeft((a(0), a(0))) { case ((min, max), e) => (math.min(min, e), math.max(max, e)) }
  }
}
