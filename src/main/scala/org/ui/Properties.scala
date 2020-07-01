/*
package org.ui

import scalafx.Includes._
import scalafx.beans.binding.Bindings
import scalafx.beans.property._
import scalafx.event.subscriptions.Subscription
import scalafx.scene.paint.Color.{Green, Red}
import scalafx.scene.shape.Rectangle

object PropMaker {
  def makeDoubleProperty(value: Double): DoubleProperty =
    DoubleProperty(value)

  def addSubToProperty(prop: DoubleProperty)
                      (op: Number => Unit): Subscription =
    prop.onChange { (_, _, newValue) =>
      op.apply(newValue)
    }
}

object Properties extends App {
  // Some types of Bindable Properties.
  val avg = FloatProperty(0.5f)
  val cont = IntegerProperty(0)
  val msg = StringProperty("Nothing")
  val obj = ObjectProperty(Properties)

  // Possible creation of a subscription.
  val speed = new DoubleProperty(this, "speed", 55) {
    // Called when the value of the property get changed.
    onChange { (_, oldValue, newValue) =>
      println(s"Value of property '$name' is changing from $oldValue to $newValue")
    }
  }

  val base = DoubleProperty(10)
  val height = DoubleProperty(5)
  val area = DoubleProperty(0)

  area <== base * height / 2
  base() = 20
  height() = 10

  val rect: Rectangle = new Rectangle{
    fill <== when(hover) choose Green otherwise Red // Require scalafx.Includes._ imports.
  }

  // We can create a Custom Binding too
  val a = new StringProperty()
  val b = Bindings.createStringBinding(
    () => Option(a()).getOrElse("").toLowerCase(),
    a
  )
  a.value = "Hello"
  println(s"Setting 'a' to ${a()}, 'b' = ${b()}")
}*/
