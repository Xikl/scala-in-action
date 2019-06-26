package com.ximo.scala.programingscala.chapter04

/**
  * 深度匹配的例子
  *
  * @author xikl
  * @date 2019/6/26
  */
object MatchDeep {

  case class Address(street: String, city: String, country: String)

  /**
    * case 类 简单可以理解为 不用new的对象类型
    * 自带 apply方法 unapply方法
    *
    * Scala 2.11.1 放松了对 unapply 必须返回 Option[T]
    * 的要求。现在 unapply 能返回任意类型，只要该类型具有以下方法：
    * <code>
    * object Person {
    * def apply(name: String, age: Int, address: Address) = new Person(name,age, address)
    *
    * 结构 将对象 变成一个元组
    * def unapply(p: Person): Option[Tuple3[String, Int, Address]] = Some((p.name, p.age, p.address))
    * }
    * </code>
    *
    * @param name
    * @param age
    * @param address
    */
  case class Person(name: String, age: Int, address: Address)

  val alice = Person("Alice", 25, Address("1 Scala Lane", "Chicago", "USA"))
  val bob = Person("Bob", 29, Address("2 Java Ave.", "Miami", "USA"))
  val charlie = Person("Charlie", 32, Address("3 Python Ct.", "Boston", "USA"))

  /**
    * 某种意义上说 模式匹配就 和 java中判断是不是 instanceOf 一致 或者更加强大
    *
    */
  for (person <- Seq(alice, bob, charlie)) {
    person match {
      case Person("Alice", 25, Address(_, "Chicago", _)) => println("hi alice")
      case Person("Bob", 29, Address("2 java Ave", "Miami", "USA")) => println("hi bob")
      case Person(name, age, _) => println(s"who are you the $age + $name")
    }
  }

  """
    |元组的语法 渐变
  """.stripMargin

  val t1: Option[Tuple3[String, Int, String]] = ???

  val t2: Option[(String, Int, String)] = ???

  val t3: Option[(String, Int, String)] = ???

  val list = 1 +: 2 +: 3 +: 4 +: Nil

  /**
    * 1 +:2 +:3 +:4 +:Nil
    *
    * @param seq
    * @tparam T
    */
  def processSeq[T](seq: Seq[T]): Unit = {
    seq match {
      case head +: tail =>
        printf("%s +: ", head)
        processSeq(tail)
      case Nil => print("Nil")
    }
  }


}
