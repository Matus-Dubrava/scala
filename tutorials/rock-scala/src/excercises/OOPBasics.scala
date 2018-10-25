package excercises

object OOPBasics extends App {
  val jim = new Writer("Jim", "Johnes", 43)
  println(jim.fullname)

  val novel = new Novel("Harry Potters", 2001, jim)
  println(novel.authorAge)

  println(novel.isWrittenBy(jim))

  val copy = novel.copy(1999)
  println(copy.year)

  val c1 = new Counter(6)
  println(c1.value)
  println(c1.increment.value)
  println(c1.decrement.value)
  println(c1.increment(10).value)
  println(c1.decrement(10).value)
}

//Novel and a writer
//
//Writer: first name, surname, year
//  - method fullname
//
//Novel: name, year of release, author
//  - authorAge
//  - isWrittenBy(author)
//  - copy (new year of release) = new instance of Novel

class Writer(name: String, surname: String, val year: Int) {
  def fullname: String = s"$name $surname"
}

class Novel(name: String, var year: Int, var author: Writer) {
  def authorAge: Int = author.year

  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}

//Counter class
//  - receives an int value
//  - method current count
//  - method to increment/decrement => new Counter
//  - overload inc/dec to receive an amount

class Counter(var value: Int = 0) {
  def currentCount: Int = value

  // IMMUTABILITY
  def increment: Counter = new Counter(value + 1)

  def decrement: Counter = new Counter(value - 1)

  def increment(byAmount: Int): Counter = new Counter(value + byAmount)

  def decrement(byAmount: Int): Counter = new Counter(value - byAmount)
}