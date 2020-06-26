package org.dt

object Hello {
  def printHello(name: String): String = name match {
    case name if name.isEmpty => "Hello World!"
    case _ => "Hello " concat name
  }

  def sumPairs(x: Int, y: Int): Int = (x, y) match {
    case (x, y) if x % 2 == 0 => x + y
    case _ => x - y
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")
  }
}
