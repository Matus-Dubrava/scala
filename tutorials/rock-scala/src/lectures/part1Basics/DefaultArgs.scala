package lectures.part1Basics

object DefaultArgs extends App {

  def factorial(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else factorial(n - 1, acc * n)

  val fact10 = factorial(10)
  println(fact10)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  savePicture("jpg", 800, 800)
  savePicture(width = 800)
  savePicture(height = 600, width = 800, format = "png")

  // we can:
  // 1. pass in every leading argument
  // 2. name the arguments
}
