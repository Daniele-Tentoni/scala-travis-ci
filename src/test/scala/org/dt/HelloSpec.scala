package org.dt

import org.scalatest.funsuite.AnyFunSuite

class HelloSpec extends AnyFunSuite {
  test("Hello should start with H") {
    assert("Hello".startsWith("H"))
  }

  test("Print hello print world") {
    assert(Hello.printHello("").equals("Hello World!"))
  }

  test("Print hello say hello!") {
    assert(Hello.printHello("Daniele").equals("Hello Daniele"))
  }

  test("Sum pairs with pair") {
    assert(Hello.sumPairs(2, 2) == 4)
  }

  test("Sum pairs with unpairs") {
    assert(Hello.sumPairs(1, 3) == -2)
  }
}
