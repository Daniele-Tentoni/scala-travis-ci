package org.dt.ui

import scalafx.beans.property.{BooleanProperty, DoubleProperty, FloatProperty, IntegerProperty, ObjectProperty, StringProperty}

object Properties extends App{
  // Some types of Bindable Properties.
  val avg = FloatProperty(0.5f)
  val cont = IntegerProperty(0)
  val msg = StringProperty("Nothing")
  val obj = ObjectProperty(Properties)
  val speed = new DoubleProperty(this, "speed", 55) {
    // Called when the value of the property get changed.
    onChange{ (_, oldValue, newValue) =>
      println(s"Value of property '$name' is changing from $oldValue to $newValue")
    }
  }

  speed() = 60
  speed() = 70
  speed.value = 75

  // Can remove subscriptions.
  val prop = BooleanProperty(false)

  val subscription = prop.onChange { (_, _, newValue) =>
    println(s"Property changed value to $newValue")
  }

  prop.value = true // Property changed value to true.
  subscription.cancel()

  // Listener will not be notified about this change.
  prop.value = false
}
