package univ.people

import org.scalatest.funsuite.AnyFunSuite

class StudentSpec extends AnyFunSuite {
  val student:Student = Student("Daniele", "Tentoni", 23)

  test("Student say hello") {
    assert(student.toString == "Daniele Tentoni")
    assert(student.age == 23)
  }

  test("Add new course to a student") {
    student.addCourse("Matematica")
    assert(student.courses == Set("Matematica"))
  }


  test("Add existing course to a student") {
    student.addCourse("Matematica")
    assert(student.courses == Set("Matematica"))
  }

  test("Get Avg from a student") {
    student.addCourse("Informatica")
    assert(student.courseAvg() == 10.5)
  }
}
