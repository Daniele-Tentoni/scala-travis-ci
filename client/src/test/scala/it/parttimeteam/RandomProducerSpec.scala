package it.parttimeteam

import org.scalatest.funsuite.AnyFunSuite

class RandomProducerSpec extends AnyFunSuite {
  val rp: RandomProducer = new RandomProducer() with ProducerUtils

  test("Test some random producer features") {
    assert(!rp.get().equals("4"))
  }
}
