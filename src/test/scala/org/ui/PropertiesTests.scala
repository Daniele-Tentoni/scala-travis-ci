package org.ui

import org.scalatest.funsuite.AnyFunSuite
import scalafx.beans.property.DoubleProperty
import scalafx.event.subscriptions.Subscription

class PropertiesTests extends AnyFunSuite{
  val prop: DoubleProperty = PropMaker.makeDoubleProperty(12)

  test("Test DoublePropery Maker") {
    // Can access to props values with () or .value
    assert(prop.value == 12)
  }

  var message = "Nothing"
  var subscription: Subscription = PropMaker.addSubToProperty(prop)(num => {
    message = s"Property changed value to $num"
  })

  test("Subscription to property") {
    prop.value = 14
    assert(message == "Property changed value to 14.0")
  }

  test("Cancel a subscription") {
    prop.value = 15 // Property changed value to 15.0.
    assert(message == "Property changed value to 15.0")
    subscription.cancel()

    // Listener will not be notified about this change.
    prop.value = 14 // Print nothing.
    assert(message != "Property changed value to 14.0")
    assert(message == "Property changed value to 15.0")
  }
}
