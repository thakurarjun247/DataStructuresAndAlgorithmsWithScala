package matrix
import scala.annotation.tailrec
object RoboticMove extends App {
  /*
  https://www.geeksforgeeks.org/check-if-a-given-sequence-of-moves-for-a-robot-is-circular-or-not/

Check if a given sequence of moves for a robot is circular or not
  Given a sequence of moves for a robot, check if the sequence is circular or not. A sequence of moves is circular if first and last positions of robot are same. A move can be on of the following.
  G - Go one unit
  L - Turn left
  R - Turn right
Examples:
Input: path[] = "GLGLGLG"
Output: Given sequence of moves is circular

Input: path[] = "GLLG"
Output: Given sequence of moves is circular
The idea is to consider the starting position as (0, 0) and direction as East (We can pick any values for these). If after the given sequence of moves, we come back to (0, 0), then given sequence is circular, otherwise not.
           N
           |
           |
   W -------------- E
           |
           |
           S
The move ‘G’ changes either x or y according to following rules.
a) If current direction is North, then ‘G’ increments y and doesn’t change x.
b) If current direction is East, then ‘G’ increments x and doesn’t change y.
c) If current direction is South, then ‘G’ decrements y and doesn’t change x.
d) If current direction is West, then ‘G’ decrements x and doesn’t change y.
The moves ‘L’ and ‘R’, do not change x and y coordinates, they only change direction
according to following rule.
a) If current direction is North, then ‘L’ changes direction to West and ‘R’ changes to East
b) If current direction is East, then ‘L’ changes direction to North and ‘R’ changes to South
c) If current direction is South, then ‘L’ changes direction to East and ‘R’ changes to West
d) If current direction is West, then ‘L’ changes direction to South and ‘R’ changes to North.
Below is the implementation of above idea :

  */

  assert(!isCircular("GL"))
  assert(isCircular("GLGLGLG"))
  assert(isCircular("GLLG"))
  assert(calculateNewDirection('L', 3) == 0)
  assert(calculateNewDirection('L', 0) == 1)
  assert(calculateNewDirection('R', 3) == 2)
  assert(calculateNewDirection('R', 0) == 3)
  assert(calculateNextPoint((0, 0), 3) == (1, 0))
  assert(calculateNextPoint((0, 0), 2) == (0, -1))
  def isCircular(s: String): Boolean = isCircular(s, 0, (0, 0))
  @tailrec
  def isCircular(s: String, currentDir: Int, currentPoint: (Int, Int)): Boolean = {
    if (s.isEmpty) false
    else {
      val cmd = s.head
      val newDirection = if (cmd == 'G') currentDir else calculateNewDirection(cmd, currentDir)
      val newPoint = if (cmd == 'G') calculateNextPoint(currentPoint, newDirection) else currentPoint
      if (newPoint._1 == 0 && newPoint._2 == 0) true else isCircular(s.tail, newDirection, newPoint)
    }
  }
  def calculateNextPoint(currentPoint: (Int, Int), dir: Int): (Int, Int) =
    dir match {
      case 3 => (currentPoint._1 + 1, currentPoint._2)
      case 1 => (currentPoint._1 - 1, currentPoint._2)
      case 0 => (currentPoint._1, currentPoint._2 + 1)
      case 2 => (currentPoint._1, currentPoint._2 - 1)
    }
  //Directions : N W S E represeted by 0 1 2 3
  def calculateNewDirection(cmd: Char, currentDir: Int): Int =
    cmd match {
      case 'L' => (currentDir + 1) % 4
      case 'R' => math.abs(currentDir - 1 + 4) % 4
      case 'G' => currentDir
    }
}
