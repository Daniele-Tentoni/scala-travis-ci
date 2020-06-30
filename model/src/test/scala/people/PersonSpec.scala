package people

import org.scalatest.funsuite.AnyFunSuite
import univ.people.{Student, Teacher}

class PersonSpec extends AnyFunSuite {

  test("Person say hello") {
    assert(Teacher("Daniele", "Tentoni", "Tecnica").sayHello(Student("Daniele", "Tentoni", 23)).equals("Salut Daniele Tentoni"))
  }

  test("Person say hello to another Person") {
    assert(Student("Daniele", "Tentoni", 23).sayHello(Teacher("Daniele", "Tentoni", "Mate")).equals("Hello Daniele Tentoni"))
  }
}
