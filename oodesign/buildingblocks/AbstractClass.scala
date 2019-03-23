package oodesign.buildingblocks

abstract class Base {
  def foo = 1

  def bar: Int

  var x: Int
}
//the val and var are evaluated when defined,
//while def is evaluated on call.

//https://alvinalexander.com/scala/fp-book-diffs-val-def-scala-functions
class Sub extends Base {
  override def foo = 11

  def bar = 2

  var x = 9

}

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(other: IntSet): IntSet
}

