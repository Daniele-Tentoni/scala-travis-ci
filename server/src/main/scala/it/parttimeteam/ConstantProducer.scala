package it.parttimeteam

class ConstantProducer(private var text: String) extends Producer {
  override def get(): String = text
}

