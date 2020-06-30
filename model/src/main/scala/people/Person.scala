package people

/**
 * Identify a person with an id.
 */
trait Identifiable {
  def id: String
}

/**
 * Identify an object that can have an age.
 */
trait Ager {
  def age: Int
}

trait Person {
  def name: String
  def surname: String

  def sayHello(identifiable: Person): String

  override def toString: String = name + " " + surname
}