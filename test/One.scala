package test

object One extends App {
  println(compress("daaabcc"))
  def compress(message: String): String = {
    if (message.isEmpty) message
    else {
      val (leftPart,rightPart) = message.span(_ == message.head)
      (if (leftPart.size == 1) leftPart else leftPart.head + leftPart.size.toString) + compress(rightPart)
    }
  }
}
