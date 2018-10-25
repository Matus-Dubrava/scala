package lectures.part2oop

object Objects {

  // SCALA DOES NOT HAVE A CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static"/"class" functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method - build some person given some parameters
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance level functionality
  }

  // Scala Applications = Scala object with
  def main(args: Array[String]): Unit = {
    // object + class => COMPANIONS

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = Person
    val john = Person

    println(mary == john) // same, point to the same object

    val tim = new Person("Tim")
    val sue = new Person("Sue")
    println(tim == sue) // different, instances of Person class

    val bobbie = Person(tim, sue)
  }
}
