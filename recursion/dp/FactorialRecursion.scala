package recursion.dp

object FactorialRecursion extends App{
        print(fact(5))

        def fact(n:Int):Int=if(n==0||n==1)1 else n*fact(n-1)
        }
