package univ.people

import people.{Ager, Person}

case class Student(
               override val name:String,
               override val surname:String,
               protected var _age:Int
             )
  extends Person
    with Frequenter
    with Ager {
  override def sayHello(person: Person): String = "Hello " + person.toString

  var courses: Set[String] = Set.empty

  override def courseAvg(): Double = courses.map(e => e.length).sum.doubleValue / courses.size

  def addCourse(course: String): Unit =
    // if (!(courses contains course))
      courses = courses + course

  override def age: Int = _age
}