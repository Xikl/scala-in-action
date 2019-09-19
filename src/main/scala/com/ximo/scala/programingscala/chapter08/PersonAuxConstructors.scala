package com.ximo.scala.programingscala.chapter08

object PersonAuxConstructors extends App {

  case class Address(street: String, city: String, state: String, zip: String) {
    def this(zip: String) {
      this("", "", "", zip)
    }
  }

  object Address {
    def zipToCity(zip: String) = "ss"

    def zipToState(zip: String) = "CA"
  }

  case class Person(name: String,
                    age: Option[Int],
                    address: Option[Address]) {
    def this(name: String) = this(name, None, None)

    def this(name: String, age: Int) = this(name, Some(age), None)

    def this(name: String, age: Int, address: Address) =
      this(name, Some(age), Some(address))

    def this(name: String, address: Address) = this(name, None, Some(address))

  }

  case class Person2(name: String, age: Option[Int] = None, address: Option[Address] = None) {

  }

  Person2("aaa")

  // 必须要使用 new
  // 编译器不会自动为 case 类的次级构造器创建 apply 方法
  new Person("sss")


  case class Person3(name: String,
                     age: Option[Int] = None,
                     address: Option[Address] = None)

  // 重载 apply方法
  object Person3 {
    def apply(name: String): Person3 = new Person3(name)

    def apply(name: String, age: Int): Person3 = new Person3(name, Some(age))

    def apply(name: String, age: Int, address: Address): Person3 = new Person3(name, Some(age), Some(address))

    def apply(name: String, address: Address): Person3 = new Person3(name, address = Some(address))

  }

  // 可以不写 new
  Person3("sss", 2)




}
