package it.parttimeteam

class RandomProducer() extends Producer {
  override def get(): String = Math.random().toString
}