package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract class - can't be instantiated
  abstract class Animal {
    val createType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val createType: String = "K9"
    override def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val createType: String = "croc"
    override def eat: Unit = println("nomnomnom")
    override def eat(animal: Animal): Unit = println(s"I am a $createType and I am eating ${animal.createType}")
  }


  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = thing
}
