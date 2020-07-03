package it.parttimeteam

import org.scalatest.funsuite.AnyFunSuite

class ProducerUtilsSpec extends AnyFunSuite {
  class MockProducer extends Producer {
    override def get(): String = "mock"
  }

  val MockProdWithUtils = new MockProducer() with ProducerUtils
  test("Test mock producer with ProducerUtils") {
    assert(MockProdWithUtils.get() == "mock")
    assert(MockProdWithUtils.getMany(1) == Seq("mock", "mock"))
  }
}
