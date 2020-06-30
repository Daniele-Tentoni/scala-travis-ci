package univ.people

import org.scalatest.funsuite.AnyFunSuite

class TeacherSpec extends AnyFunSuite {
  val daniele:Teacher = Teacher("Daniele", "Tentoni", "Matematica")

  test("Teacher say hello") {
    assert(daniele.toString == "Daniele Tentoni")
  }

  test("Discover teacher age") {
    daniele.age = 32
    assert(daniele.age == 32)
  }
}