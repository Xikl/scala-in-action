package com.ximo.scala.programingscala.chapter04

/**
  *
  *
  * @author xikl
  * @date 2019/7/4
  */
object MatchFunArgs {

  case class Address(street: String, city: String, country: String)

  case class Person(name: String, age: Int)

  val as = Seq(
    Address("scala", "aa", "USA"),
    Address("scala2", "aa2", "USA2")
  )

  val ps = Seq(
    Person("BUKC", 29),
    Person("BUKC2", 39)
  )

  //List(1, 2, 3) zip List(4, 5 )
  //res0: List[(Int, Int)] = List((1,4), (2,5))
  // Seq((Person, Address), (Person, Address))
  val pas = ps zip as

  // 不太行
  pas map { tup =>
    val Person(name, age) = tup._1
    val Address(street, city, country) = tup._2
    s"$name (age: $age) lives at $street, $city, in $country"
  }

  // 优雅
  // 偏函数
  pas map{
    case (Person(name, age), Address(street, city, country)) =>
      s"$name (age: $age) lives at $street, $city, in $country"
  }


}
