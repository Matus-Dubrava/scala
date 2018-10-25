package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
//  println(person.name) - this will fail - not a field
  println(person.x)
  person.greet("Daniel")
  person.greet


}

// constructor
class Person(name: String, val age: Int) {
  // body
  val x = 2 // this is field
  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // value of "this" is implied in this context where there is no ambiguity
  // since "greet" function doesn't take any argument called "name"
  def greet(): Unit = println(s"Hi, I am $name")

  // ^ overloaded method - we can have multiple function with the same name as long as
  // their signatures differ from each other (difference in just return types is not enough
  // and produces ambiguity, therefore causing na error)

  // overloaded constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}





