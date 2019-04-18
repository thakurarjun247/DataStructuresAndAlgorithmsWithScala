package collection
import scala.collection.mutable
object PostFixEval extends App {
  println(evaluatePostfix("2 3 1 * + 10 -").getOrElse("empty expression"))
  def evaluatePostfix(s: String): Option[Int] = {
    if (s.isEmpty) None
    else {
      val stack = mutable.Stack[Int]()
      s.split(" ").foreach {
        c =>
          c match {
            //if you encounter an operator, pop two operands from stack and apply
            //this operator on them
            case "+" => stack.push(stack.pop() + stack.pop())
            case "-" => stack.push(stack.pop() - stack.pop())
            case "*" => stack.push(stack.pop() * stack.pop())
            case "/" => stack.push(stack.pop() / stack.pop())
            //can't use _ here
            //else if you find an operand push it to stack
            case n => stack.push(n.toInt)
          }
      }
      Some(stack.top)
    }
  }
}
