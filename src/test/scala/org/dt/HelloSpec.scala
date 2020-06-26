package org.dt

import org.scalatest.funsuite.AnyFunSuite

class HelloSpec extends AnyFunSuite {
  test("Hello should start with H") {
    assert("Hello".startsWith("H"))
  }
}
