package com.ximo.scala.programingscala.chapter04

/**
  * 模式匹配在变量中的使用
  *
  * @author xikl
  * @date 2019/7/4
  */
object ValMatch extends App {

  case class Address(street: String, city: String, country: String)

  case class Person(name: String, age: Int, address: Address)

  val Person(name, age, Address(_, state, _)) = Person("BOB", 19, Address("a Scala Way", "CA", "USA"))

  // 提出变量
  println(name)
  println(age)
  println(state)

  val head +: tail = List(1, 2, 3)
  println(head)
  println(tail)

  val head1 +: head2 +: tail1 = List(1, 2, 3)
  println(head1)
  println(head2)
  println(tail1)

  val Seq(a, b, c) = List(1, 2, 3)
  println(s"$a+$b+$c")

  def sumAndCount(ints: Seq[Int]) = (ints.sum, ints.size)

  val (sum, count) = sumAndCount(List(1, 2, 3, 4))
  println(s"$sum + $count")

  val dogBreeds = Seq(Some("Doberman"), None, Some("Yorkshire Terrier"),
    Some("Dachshund"), None, Some("Scottish Terrier"),
    None, Some("Great Dane"), Some("Portuguese Water Dog")
  )

   for{
     Some(bread) <- dogBreeds
     upCasedBreed = bread.toUpperCase
   } println(upCasedBreed)



}
