package org.dt

/**
 * Provide some useful functions for testing.
 */
object Hello {
  /**
   * Print an Hello to someone.
   *
   * @param name Name to hello.
   * @return Hello to him.
   */
  def printHello(name: String): String = name match {
    case name if name.isEmpty => "Hello World!"
    case _ => "Hello " concat name
  }

  /**
   * Sum pair numbers ot not.
   *
   * @param x First number.
   * @param y Second number.
   * @return Thre result of the op.
   */
  def sumPairs(x: Int, y: Int): Int = (x, y) match {
    case (x, y) if x % 2 == 0 => x + y
    case _ => x - y
  }
}