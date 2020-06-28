package org.ui

import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite
import scalafx.beans.property.DoubleProperty
import scalafx.event.subscriptions.Subscription

class PropertiesTests extends AnyFunSuite with BeforeAndAfterEach {

  var message = "Nothing"
  var prop: DoubleProperty = PropMaker.makeDoubleProperty(12)
  var subscription: Subscription = PropMaker.addSubToProperty(prop)(num => {
    message = s"Property changed value to $num"
  })

  /**
   * Override beforeEach from BeforeAndAfterEach for this behaviour.
   */
  override def beforeEach(): Unit = {
    super.beforeEach()
    resetProp()
  }

  def resetProp(): Unit = prop = PropMaker.makeDoubleProperty(12)
  def assignSub(): Unit = subscription = PropMaker.addSubToProperty(prop)(num => {
    message = s"Property changed value to $num"
  })

  test("Test DoublePropery Maker") {
    // Can access to props values with () or .value
    assert(prop.value == 12)
  }


  test("Subscription to property") {
    assignSub()
    prop.value = 14
    assert(message == "Property changed value to 14.0")
  }

  test("Cancel a subscription") {
    assignSub()
    prop.value = 15 // Property changed value to 15.0.
    assert(message == "Property changed value to 15.0")
    subscription.cancel()

    // Listener will not be notified about this change.
    prop.value = 14 // Print nothing.
    assert(message != "Property changed value to 14.0")
    assert(message == "Property changed value to 15.0")
  }

  val bindProp: DoubleProperty = PropMaker.makeDoubleProperty(10)
  test("Property binding base version") {
    // Make a unidirectional binding.
    prop <== bindProp

    bindProp.value = 20
    assert(bindProp.value == 20)
    assert(bindProp.value == prop.value)
  }

  val biBindProp: DoubleProperty = PropMaker.makeDoubleProperty(2)
  test("Property binding bidirectional") {
    // Make a bidirectional binding.
    prop <==> biBindProp
    prop.value = 5
    assert(prop.value == 5)
    assert(prop.value == biBindProp.value)

    biBindProp.value = 5
    assert(biBindProp.value == 5)
    assert(biBindProp.value == prop.value)
  }
}
