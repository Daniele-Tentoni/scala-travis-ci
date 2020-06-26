package it.danieletentoni

import org.scalatest.funsuite

class HelloSpec extends FunSuite with DiagrammedAssertions {
    test("Hello should start with H") {
        assert("hello".startWith("H"))
    }
}
