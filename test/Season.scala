package test

import scala.collection.mutable.ListBuffer

object Season extends App {
  val a = Array(-3, -14, -5, 7, 8, 42, 8, 3000);
  val seasonNames = Array("WINTER", "SPRING", "SUMMER", "AUTUMN")
  println(solution(a, seasonNames))

  case class Season(name: String, amp: Int) {
    override def toString = s"$name $amp"
  }

  def solution(t: Array[Int], seasonNames: Array[String]): String = {
    val buffer: ListBuffer[Array[Int]] = ListBuffer[Array[Int]]()
    //length of a season i.e. number of data points in array for a season
    val len = (t.length) / seasonNames.length
    val seasons = (0 to (seasonNames.length - 1)) map (i => Season(seasonNames(i), getAmplitude(t.slice(i * len, (i + 1) * len))))
    seasons
      .maxBy(_.amp)
      .name
  }

  def getAmplitude(a: Array[Int]): Int = {
    val (min, max) = a.foldLeft((a(0), a(0))) { case ((min, max), e) => (math.min(min, e), math.max(max, e)) }
    math.abs(max - min)
  }
}

