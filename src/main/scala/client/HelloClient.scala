package client

object HelloClient {
  def printHello(name:String, times:Int):String = times match {
    case times if times > 0 => "Hello " + printHello(name, times - 1)
    case _ => name + " client."
  }
}
