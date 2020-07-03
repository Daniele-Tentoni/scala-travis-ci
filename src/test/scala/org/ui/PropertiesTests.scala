/*
package org.ui

import scalafx.beans.property.DoubleProperty
import scalafx.event.subscriptions.Subscription

class PropertiesTests {

  var message = "Nothing"
  var prop: DoubleProperty = PropMaker.makeDoubleProperty(12)
  var subscription: Subscription = PropMaker.addSubToProperty(prop)(num => {
    message = s"Property changed value to $num"
  })

  def resetProp(): Unit = prop = PropMaker.makeDoubleProperty(12)

  def assignSub(): Unit = subscription = PropMaker.addSubToProperty(prop)(num => {
    message = s"Property changed value to $num"
  })

  // Can access to props values with () or .value
  assert(prop.value == 12)

  assignSub()
  prop.value = 14
  assert(message == "Property changed value to 14.0")

  assignSub()
  prop.value = 15 // Property changed value to 15.0.
  assert(message == "Property changed value to 15.0")
  subscription.cancel()

  // Listener will not be notified about this change.
  prop.value = 14 // Print nothing.
  assert(message != "Property changed value to 14.0")
  assert(message == "Property changed value to 15.0")

  val bindProp: DoubleProperty = PropMaker.makeDoubleProperty(10)

  // Make a unidirectional binding.
  prop <== bindProp

  bindProp.value = 20
  assert(bindProp.value == 20)
  assert(bindProp.value == prop.value)

  val biBindProp: DoubleProperty = PropMaker.makeDoubleProperty(2)

  // Make a bidirectional binding.
  prop <==> biBindProp
  prop.value = 5
  assert(prop.value == 5)
  assert(prop.value == biBindProp.value)

  biBindProp.value = 5
  assert(biBindProp.value == 5)
  assert(biBindProp.value == prop.value)
}
*/
