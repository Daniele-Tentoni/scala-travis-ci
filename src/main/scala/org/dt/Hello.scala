package org.dt

object Hello {
  def printHello(name: String): String = name match {
    case name if name.isEmpty => "Hello World!"
    case _ => "Hello " concat name
  }

  def sumPairs(x: Int, y: Int): Int = (x, y) match {
    case (x, y) if x % 2 == 0 => x + y
    case _ => x - y
  }
}

import org.scalajs.dom
import org.scalajs.dom.document

object Main {
  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  def main(args: Array[String]): Unit = {
    appendPar(document.body, "Hello World")
    println("Hello world!")
  }
}
