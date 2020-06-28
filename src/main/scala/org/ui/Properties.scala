package org.ui

import scalafx.beans.property._
import scalafx.event.subscriptions.Subscription

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
}