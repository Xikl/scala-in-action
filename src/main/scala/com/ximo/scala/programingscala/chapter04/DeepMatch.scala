package com.ximo.scala.programingscala.chapter04

/**
  *
  *
  * @author xikl
  * @date 2019/7/3
  */
object DeepMatch extends App {

  case class Address(street: String, city: String, country: String)

  case class Person(name: String, age: Int, address: Address)

  val alice = Person("Alice", 25, Address("1 Scala Lane", "Chicago", "USA"))
  val bob = Person("Bob", 29, Address("2 Java Ave.", "Miami", "USA"))
  val charlie = Person("Charlie", 32, Address("3 Python Ct.", "Boston", "USA"))

  /**
    * p实现了对Person的赋值
    * 同样a也是
    *
    */
  Seq(alice, bob, charlie) foreach {
    case p@Person("Alice", 25, _) =>
      println(s"hi Alice! $p")
    case p@Person("Bob", 29, a@Address(_, _, _)) =>
      println(s"Hi ${p.name}! age ${p.age}, in ${a.city}")
    case p@Person(name, age, _) =>
      println(s"Who are you, $age year-old person named $name? $p")
  }

  Seq(alice, bob, charlie) foreach {
    p => println(s"${p.age} + ${p.name} + ${p.address}")
  }

}
