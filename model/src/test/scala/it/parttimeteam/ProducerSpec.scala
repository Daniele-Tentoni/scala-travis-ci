package it.parttimeteam

import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite

class ProducerSpec extends AnyFunSuite with BeforeAndAfterEach {

  var message = "Nothing"

  /**
   * Override beforeEach from BeforeAndAfterEach for this behaviour.
   * Doc: http://doc.scalatest.org/1.0/org/scalatest/BeforeAndAfterEach.html
   */
  override def beforeEach(): Unit = {
    super.beforeEach()
    println("***** Before a test *****")
  }

  test("Test some producer features") {
    assert("Hello".startsWith("H"))
  }
}
