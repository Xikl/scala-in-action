package com.ximo.scala.programingscala.chapter08

object PersonaEmployeeTraits {

  case class Address(street: String, city: String, state: String, zip: String)

  object Address {
    def apply(zip: String): Address = new Address("UNKNOWN", "zipToCity", "zipToState", zip)

    trait PersonState {
      val name: String
      val age: Option[Int]
      val address: Option[Address]

      def sayName(): Unit = {
        print(s"name$name")
      }
    }

    case class Person(name: String,
                      age: Option[Int] = None,
                      address: Option[Address] = None
                     ) extends PersonState

    val person = Person("name")
    // 不能修改
//    person.name = "sssss"

    trait EmployeeState {
      val title: String
      val manager: Option[Employee]
    }

    case class Employee(
                         name: String,
                         age: Option[Int] = None,
                         address: Option[Address] = None,
                         title: String = "[unknown]",
                         manager: Option[Employee] = None)
      extends PersonState with EmployeeState
  }

}
