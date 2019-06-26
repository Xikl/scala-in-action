package com.ximo.scala.programingscala.chapter04

/**
  *
  *
  * @author xikl
  * @date 2019/6/26
  */
object Infix {

  case class With[A, B](a: A, b: B)

  val with1: With[String, Int] = With("Foo", 1)

  // 牛逼的写法 更加易懂
  val with2: String With Int = With("Bar", 2)

  Seq(with1, with2) foreach {
    case s With i => print(s"$s with $i")
    case _ => print("unknown")
  }


}
