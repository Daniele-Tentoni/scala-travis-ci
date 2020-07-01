package it.parttimeteam

trait ProducerUtils {
  producer: Producer =>
  def getMany(n:Int): Seq[String] =
    for (i <- 0 to n) yield producer.get()
}
