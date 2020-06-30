package univ.people

import people.{Ager, Person}

case class Teacher (override val name:String,
                    override val surname:String,
                    protected val course: String)
  extends Person
    with Ager {
  private var _age = 20

  override def sayHello(person: Person): String = "Salut " + person.toString

  def age_=(i: Int): Unit = _age = i

  override def age: Int = _age
}
