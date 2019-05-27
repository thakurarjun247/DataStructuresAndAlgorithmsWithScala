package misc.onlinecodingtest
/*
FizzBuzz
Write a program that prints the numbers in the given range. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”. Print a new line after each string or number.

Input Format First line will be the number of testcases, T. Next line will have T integers, denoted by N.

Output Format For each testcase, print the number from 1 to N. But follow the rules given in the problem statement.

Constraints

1 <= T <= 10

N is an integer.

Please read the below instructions carefully

You can choose any language from the given list to write your solution.
All input to the programming solution is to STDIN and output is to STDOUT.
You don't have to manually give the input to your program, just take the input from STDIN and the code evaluation engine will provide the input to your program.
For example if you are coding in C, and the first input is an integer then simply do scanf('%d', &i) assuming you are reading that integer to a variable named i. Similarly if you are using C++ simply do cin >> i
There are two different type of test cases. First type is the sample input and output for which you know both the input and output. You can look at them under the problem statement.
When you click Compile and Test the code will be compiled and tested only on the sample input that is shown to you. Compile and Test is for you to understand if you solution is compiling and running against the sample input. 5 When you click submit, your code will be judged on multiple test cases which are hidden. These tests are not available for you to see them so you will not know the input on which your code will be tested. But it is assured that all inputs will be in the given constraint limit and in the given format as stated in the problem statement.
In order for your code to get accepted, it must clear all the judge test cases. In cases where partial marking is allowed, you will awarded partial marks for the number of test cases your solution passes.
Please note that getting green mark when you hit 'Compile and Test' does not indicate anything on the correctness of your program. It just indicates that your code correctly compiled and ran successfully against the sample input. It can still fail for other test inputs that visible to you.
Do not output anything, except what it is asked for in the output section. Note that you have to output only in the way that is mentioned. Any extra strings in the output will be treated as wrong answer. Even an extra space can lead to the answer not being accepted.
Don't assume any constraints on the input based on the sample input that you see, the actual test cases will be much larger in size. But they will always be within the constraints mentioned in the problem.
To understand how the code is evaluated visit the judge page. There is also a sample code in each language there.
To further understand how the judge works, look at one of the actual test input file and the corresponding expected output for this problem

Input File

Expected Output

You can also look at the solution that passes all test cases for this problem.

View C Solution

View C++ Solution

Sample Input
2
3 15
Sample Output
1
2
Fizz
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
Time Limit: 2.0 sec(s) for each input file
Memory Limit: 256 MB
Source Limit: 1024 KB
Marking Scheme: Marks are awarded if any testcase passes
Allowed Languages: Bash, C, C++, C++14, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java, Java 8, JavaScript(Rhino), JavaScript(Node.js), TypeScript, Julia, Kotlin, Lisp, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, R(RScript), Racket, Ruby, Rust, Scala, Swift, Swift-4.1, Visual Basic
*/
/*
// Sample code to perform I/O:

val name = scala.io.StdIn.readLine()        // Reading input from STDIN
println("Hi, " + name + ".")                // Writing output to STDOUT

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
*/
// Write your code here
import scala.io.StdIn._
object HackerEarthSample extends App {
  // 123 456 789 456 120
  val n = readInt
  val line = readLine
  import scala.util.Random.nextInt
  nextInt()
  /*Sample Input
  2
  3 15
   should be read from stdin*/
  val nums = line
    .split(" ")
    .toSeq
    .map(_.toInt)
    .filter(_ > 0)
    .map(convertAll)
    .flatten
    .foreach(println)
  def convertAll(n: Int): List[String] =
    (1 to n)
      .toList
      .map(convert)
  def convert(n: Int): String = {
    val divByThree = (n % 3 == 0)
    val divByFive = (n % 5 == 0)
    val divByThreeFive = divByThree && divByFive
    if (divByThreeFive) "FizzBuzz"
    else if (divByThree) "Fizz"
    else if (divByFive) "Buzz"
    else n.toString
  }
}

