package server

object HelloClient {
  def printGoodbye(name: String, times: Int): String = times match {
    case times if times > 0 => "Goodbye " + printGoodbye(name, times - 1)
    case _ => name + " server."
  }
}
