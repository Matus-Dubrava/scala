package excercises

// Linked list of integers
abstract class MyList[+A] {

  // method head => first element of this list
  // method tail => remainder of the list
  // method isEmpty => (Boolean) is this list empty
  // add(int) => new list with this element added
  // toString => a string representation of the list

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]

  // polymorfic
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  // concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  /*
    [1, 2, 3].filer(n % 2 == 0) =
       = [2, 3].filter(n % 2 == 0)
       = new Cons(2, [3].filter(n % 2 == 0)
       = new Cons(2, Empty.filter(n % 2 == 0)
       = new Cons(2, Empty)
   */
  def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  /*
    [1, 2, 3].map(n * 2)
       = new Cons(2, [2, 3].map(n * 2))
       = new Cons(2, new Cons(4, [3].map(n * 2)))
       = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
       = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */
  def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))

  /*
    [1, 2] ++ [3, 4, 5]
       = new Cons(1, [2] ++ [3, 4, 5])
       = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty)))))

   */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  /*
    [1, 2].flatMap(n => [n, n + 1])
       = [1, 2] ++ [2].flatMap(n => [n, n + 1])
       = [1, 2] ++ [2, 3] ++ Empty.flatMap(n => [n, n + 1])
       = [1, 2] ++ [2, 3] ++ Empty
       = [1, 2, 2, 3]
  */
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)
}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object ListTest extends App {
//  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.tail.head)
//  println(list.add(4).head)
//  println(list.isEmpty)
//  println(list.toString)

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  var listOfStrings: MyList[String] = new Cons("hello", new Cons("Scala", Empty))

  println(listOfIntegers)
  println(listOfStrings)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }))

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = {
      elem % 2 == 0
    }
  }))

  println(listOfIntegers ++ anotherListOfIntegers)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }))
}
