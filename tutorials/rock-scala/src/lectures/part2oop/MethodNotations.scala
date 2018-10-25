package lectures.part2oop

object MethodNotations extends App {

  class Person(var name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name $nickname", favoriteMovie, age)

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def unary_! : String = s"$name what the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times."

    def learns(subject: String): String = s"$name learns $subject"
    def learnsScala: String = learns("Scala")
  }

  // "operators" in Scala
  val mary = new Person("Mary", "Inception", 24)
  println(mary likes "Inception") // infix notation = operator notation
  println(mary.likes("Inception"))

  val tom = new Person("Tom", "Fight Club", 28)
  println(mary + tom)
  println(mary.+(tom))

  // all operators are methods
  println(1.+(2))

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-

  // unary_ prefix - works only with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply method
  println(mary.apply())
  println(mary()) // equivalent

  // 1. overload the + operator
  //    mary + "the rockstar" => new person "Mary (the rockstart)"

  val newMary = mary + "(the rockstar)"
  println(newMary.name)

  // 2. Add an age to the Person class
  //    Add a unary + operator => new person with the age + 1
  //    +mary = mary with the age incremented

  println(mary.age)
  val updatedAgeMary = +mary
  println(updatedAgeMary.age)

  // 3. Add a "learns" method in the Person class => Mary learns Scala
  //    Add a "learnsScala" method, calls the "learns" method with "Scala"
  //    Use it in postfix notation

  println(mary.learns("JavaScript"))
  println(mary learnsScala)

  // 4. Overload "apply" method
  //    mary.apply(2) => "Mary watched Inception 2 times"
  println(mary(2))
}
