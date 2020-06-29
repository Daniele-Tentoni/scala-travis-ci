package it.parttimeteam

import org.scalatest.funsuite.AnyFunSuite

class ConstantProducerSpec extends AnyFunSuite {
  val cp: ConstantProducer = new ConstantProducer("4")

  test("Test some Constant Producer features") {
    assert(cp.get().equals("4"))
  }
}
