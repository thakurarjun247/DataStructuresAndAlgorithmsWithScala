package wip
object BudjetShoppingHackerRank extends App {
  //TODO: working but adding memo is required
  /*
Helen has n dollars budgeted to purchase Math notebooks.
There are m stores that stock unlimited supplies of notebooks in
 bundles, but the size and price of the bundles vary from store
 to store. Helen can purchase as many bundles as she wants from
 as many stores as necessary until she depletes her budget,
  but her goal is to purchase a maximal number of notebooks.
   For example, if Helen has n = 5 dollars and there
    are m = 2 shops where one sells 4-notebook bundles for 2
    dollars a piece and the other sells 2-notebook bundles for
    1 dollar a piece, she will buy a total of 4 + 4 + 2 = 10
     notebooks (two bundles of 4 from the first shop and one
      bundle of 2 from the second shop).

   */
  def budgetShopping(n: Int, bundleQuantities: Array[Int], bundleCosts: Array[Int]): Int = {
    budgetShopping(n, bundleQuantities, bundleCosts, 0)
    // Write your code here
  }
  def budgetShopping(dollars: Int, bundleQuantities: Array[Int], bundleCosts: Array[Int], quantity: Int): Int = {
    if (dollars == 0) 0
    else if (bundleQuantities.size == 0) 0
    else {
      if (bundleCosts.head > dollars)
        budgetShopping(dollars, bundleQuantities.tail, bundleCosts.tail, quantity)
      else {
        val takeItQty = budgetShopping(dollars - bundleCosts.head, bundleQuantities, bundleCosts, quantity + bundleQuantities.head)
        val leaveItQty = budgetShopping(dollars, bundleQuantities.tail, bundleCosts.tail, quantity)
        (takeItQty max leaveItQty) + quantity
      }
    }
    // Write your code here
  }
}
