package lectures.part1Basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(10))

  def tailFactorial(n: Int): BigInt = {
    @tailrec
    def _tailFactorial(n: Int, res: BigInt): BigInt =
      if (n <= 1) res
      else _tailFactorial(n - 1, res * n)

    _tailFactorial(n, 1)
  }

  println(tailFactorial(20000))

  // function that concatenates string n times using tail recursion
  def concat(aString: String, n: Int): String = {
    def _concat(aString: String, n: Int, acc: String): String =
      if (n == 0) acc
      else _concat(aString, n - 1, acc + aString)

    _concat(aString, n, "")
  }

  println(concat("Hello", 3))

  // isPrime function that is tail recursive
  def isPrime(n: Int): Boolean = {
    @tailrec
    def _isPrime(i: Int, acc: Boolean): Boolean =
      if (!acc) false
      else if (i <= 1) acc
      else _isPrime(i - 1, n % i != 0 && acc)

    _isPrime(n/2, true)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))

  // fibonacci function that is tail recursive
  def fibonacci(n: Int): Int = {
    @tailrec
    def _fibonacci(n: Int, fst: Int, snd: Int): Int =
      if (n <= 1) snd
      else _fibonacci(n - 1, snd, fst + snd)

    _fibonacci(n, 1, 1)
  }

  println(fibonacci(5))
}
