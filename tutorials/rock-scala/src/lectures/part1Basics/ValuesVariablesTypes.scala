package lectures.part1Basics

object ValuesVariablesTypes extends App {
  //  vals are IMMUTABLE
  //  types of values are optional, can be inferred by compiler
  val x: Int = 42
  println(x);

  val aString: String = "Hello, World!"
  val anotherString = "goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val aShort: Short = 4241
  val aLong: Long = 1234214444123321L
  val aFloat: Float = 2.4f
  val aDouble: Double = 123.421412

  // variables can be reassigned
  // variables are used for side-effects
  var aVariable: Int = 4

  aVariable = 5
}
