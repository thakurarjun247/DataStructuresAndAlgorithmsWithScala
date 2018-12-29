package recursion.dp

object FactorialRecursion extends App{
        25 to 30 map(i=>print(fact(i)))
        print(fact(20))

        def fact(n:Int):Int=if(n==0||n==1)1 else n*fact(n-1)
        }
