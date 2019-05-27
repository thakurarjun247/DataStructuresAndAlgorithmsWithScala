package scala.oodesign.buildingblocks
class BankAccount {
  private var balance: Int = 0 //intialize
  //by default the var above will be public so make it private
  def deposit(amount: Int) = {
    balance += amount
    balance
  }
  def withdraw(amount: Int): Int = {
    require(balance > 0, "insufficient balance")
    balance -= amount
    balance
  }
  def getBalance = balance
}
object GetterSetterDemo extends App {
  val account = new BankAccount
  println(account.deposit(100))
  println(account.withdraw(100))
  println(account.withdraw(51))
}
