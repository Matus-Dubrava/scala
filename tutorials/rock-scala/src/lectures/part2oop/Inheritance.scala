package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructor
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int) extends Person(name)

  // overriding
  class Dog(dogType: String) extends Animal {

    override def eat: Unit = {
      super.eat
      println("Crunch, Crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overriding vs overloading

  // super

  // preventing overrides
  // 1 - use "final" on member - won't be able to override given member
  // 2 - use "final" on class - won't be able to extend given class
  // 3 - use "sealed" the class - extends classes in THIS FILE, prevents extensions in other files
}
