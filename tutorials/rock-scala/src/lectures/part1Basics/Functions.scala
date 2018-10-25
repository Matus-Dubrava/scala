package lectures.part1Basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepativeFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepativeFunction(aString, n - 1)
  }

  println(aRepativeFunction("hello", 3))

  def aFunctionWithSideEffects(aString: String) : Unit = println(aString)

  aFunctionWithSideEffects("Some random side effect")

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  println(aBigFunction(5))

  // 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  def greet(name: String, age: Int): Unit = println("Hi, my name is " + name + " and I am " + age + " years old")
  greet("David", 42)

  // factorial function
  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)
  println(factorial(5))

  // fibonacci function
  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  println(fibonacci(5))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
