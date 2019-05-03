package datastructure.mutable.tree.create
class Node(var key: Int,
           var left: Node = null,
           var right: Node = null,
           var hd: Int = 0,
           var level: Int = 0,
           var parent: Node = null) {
  override def toString = getTabs(level) + s"($key)"
  def getTabs(level: Int): String =
    level match {
      case 0 => "\t\t  "
      case 1 => "\t  "
      case 2 => "  "
      case _ => " "
    }
}

