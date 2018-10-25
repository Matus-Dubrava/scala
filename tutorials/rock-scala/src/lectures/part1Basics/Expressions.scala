package lectures.part1Basics

object Expressions extends App {

//  Expression
  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)

  // == != > >= < <=
  println(1 == x)

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // -= *= /= ...side effects
  println(aVariable)

  // Instructions (DO something) vs. Expressions ()

  // IF expressions
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition) 3 else 5)

  // DON'T WRITE WHILE LOOPS
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // EVERYTHING in scala is Expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning - Expressions that return Unit

  // Code block - value of the code block is the value of the last expression in the
  //              code block
  // everything inside of a code block is visible only inside of code block
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "Hello" else "Goodbye"
  }

  println(aCodeBlock)

  val someValue = {
    2 < 3
  }

  println(someValue)

  val someOtherValue = {
    if(someValue) 239 else 987
    42
  }

  println(someOtherValue)
}
