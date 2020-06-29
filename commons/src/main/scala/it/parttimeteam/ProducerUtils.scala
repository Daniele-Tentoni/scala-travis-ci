package it.parttimeteam

trait ProducerUtils {
  producer: Producer =>
  def getMany(n:Int): Seq[String] = Seq(producer.get()).union(getMany(n - 1))
}
