package com.ximo.scala.programingscala.chapter05

object ImplicitsToJson {


  case class Address(street: String, city: String)

  case class Person(name: String, address: Address)

  trait ToJson {
    def toJson(level: Int = 0): String

    val INDENTATION = "  "

    def indentation(level: Int = 0): (String, String) =
      (INDENTATION * level, INDENTATION * (level + 1))

  }

  /**
    * 隐式类的转化 它必须要有一个 构造函数，也就是必须要有一个参数如AddressToJson(address：Address) 这是要增强的类
    * 隐式对象 就不用
    *
    * @param address
    */
  implicit class AddressToJson(address: Address) extends ToJson {
    override def toJson(level: Int): String = {
      val (outdent, indent) = indentation(level)
      s"""
         |{
         | $indent"street": ${address.street},
         | $indent"city": ${address.city}
         | $outdent
         |}
       """.stripMargin

    }
  }

  implicit class PersonaToJson(person: Person) extends ToJson{
    override def toJson(level: Int): String = {
      val (outdent, indent) = indentation(level)
      s"""{
         |$indent"name": "${person.name}",
         |$indent"address": ${person.address.toJson(level + 1)}
         |$outdent}""".stripMargin
    }

  }

  def main(args: Array[String]): Unit = {
    val a = Address("1 Scala Lane", "someCity")
    val p = Person("Bob", a)

    println(a.toJson())
    println(p.toJson())
  }






}
