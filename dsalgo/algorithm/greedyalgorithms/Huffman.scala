package dsalgo.algorithm.greedyalgorithms

import scala.collection.mutable.PriorityQueue
object Huffman extends App {
  app()
  def app(): Unit = {
    val node = createHuffmanTree(List("a", "b", "c", "d", "e", "f"), List(45, 13, 12, 16, 9, 5))
    generateHuffmanCodes(node, "")

  }
  case class Node(word: String = null, freq: Int, left: Node = null, right: Node = null, level:Int=0){
    override def toString=(word, freq).toString

  }
  def createHuffmanTree(words: List[String], freq: List[Int]) = {
    //def increasingOrder(i: Int) = -1 * i
    //minheap
    val q = PriorityQueue[Node]()(Ordering.by(_.freq * (-1)))
    val nodes = 0 to words.length - 1 map (index => Node(word = words(index), freq = freq(index)))
    nodes.foreach(n => q.enqueue(n))
    while (q.size > 1) {
      val first = q.dequeue()
      val second = q.dequeue()
      val third = Node(freq = first.freq + second.freq, left = first, right = second)
      q.enqueue(third)
    }
    q.dequeue()
  }
  def generateHuffmanCodes(root: Node, code: String): Unit = {
    if (root.left == null && root.right == null)
      println(root.word + " -> " + code)
    else {
      generateHuffmanCodes(root.left, code+"0" )
      generateHuffmanCodes(root.right, code+"1" )
    }
  }
}
