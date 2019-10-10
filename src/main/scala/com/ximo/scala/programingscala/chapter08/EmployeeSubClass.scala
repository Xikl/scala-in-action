package com.ximo.scala.programingscala.chapter08

object EmployeeSubClass extends App {


  case class Person(name: String,
                    age: Option[Int] = None,
                    address: Option[String] = None)

  class Employee(name: String,
                 age: Option[Int] = None,
                 address: Option[String] = None,
                 val title: String = "UNKNOWN",
                 val manager: Option[Employee] = None
                ) extends Person(name, age, address) {
    override def toString: String =
      s"Employee($name, $age, $address, $title, $manager)"
  }


  val ceo = new Employee("Joe CEO", title = "CEO")
  // 结果: Employee(Joe CEO, None, None, CEO, None)
  new Employee("Buck Trends1")
  // 结果: Employee(Buck Trends1, None, None, [unknown], None)
  new Employee("Buck Trends2", Some(20), Some("22"))
  // 结果: Employee(Buck Trends2, Some(20),
  // Some(Address(1 Scala Lane,Anytown,CA,98765)), [unknown], None)
  new Employee("Buck Trends3", Some(20), Some("a1"), "Zombie Dev")
  // 结果: Employee(Buck Trends3, Some(20),
  // Some(Address(1 Scala Lane,Anytown,CA,98765)), Zombie Dev, None)
  new Employee("Buck Trends4", Some(20), Some("a1"), "Zombie Dev", Some(ceo))
  // 结果: Employee(Buck Trends4, Some(20),
  // Some(Address(1 Scala Lane,Anytown,CA,98765)), Zombie Dev,
  // Some(Employee(Joe CEO, None, None, CEO, None)))

  val e1 = new Employee("aa", Some(11), Some("sssss"))
  val e2 = new Employee("aa", Some(11), Some("sssss"), "a title")

  // 由于 Employee 类 没有覆写 equals 和 hashCode 所有 equals 和 == 都是 true。 eq 为 false 二者不是同一个引用
  println(e1.equals(e2)) // true
  println(e1.eq(e2)) // false
  println(e1 == e2) // true

}
