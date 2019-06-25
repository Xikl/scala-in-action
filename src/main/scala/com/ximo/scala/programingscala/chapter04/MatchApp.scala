package com.ximo.scala.programingscala.chapter04

/**
  *
  *
  * @author xikl
  * @date 2019/6/25
  */
object MatchApp {

  for {
    // Seq[Any]
    item <- Seq(1, 2, 2, 7, "One", "two", 'four)
  } {
    val str = item match {
      case 1 => "int 1"
      case i: Int => "other int: " + i
      case d: Double => "a double:" + d
      case "one" => "string one"
      case s: String => "other String:" + s
      case _ => "other value" + _
    }
    println(str)
  }

  // 将变量都变成_ 然后使用 item
  for {
    // Seq[Any]
    item <- Seq(1, 2, 2, 7, "One", "two", 'four)
  } {
    val str = item match {
      case 1 => "int 1"
      case _: Int => "other int: " + item
      case _: Double => "a double:" + item
      case "one" => "string one"
      case _: String => "other String:" + item
      case _ => "other value" + item
    }
    println(str)
  }

  /**
    * 匹配我们自己的输入
    * case _ 必须放到最后一个，否则不可到达
    *
    * @param y
    */
  def checkY(y: Int): Unit = {
    for {
      x <- Seq(99, 100, 101)
    } {
      val str = x match {
        // 使用反引号来表达你要匹配的是传入的值
        // 如果使用 y 那么就相当于将一个默认的match放到了第一个
        // 导致了第二个也无法执行
        // 大写字母开头的标识符被认为是类型名称。如Int
        case `y` => "found y"
        case i: Int => "int: " + i
      }
      println(str)
    }
  }

  checkY(100)

  for {
    x <- List(1, 2, 3, 4,5, "one", "two")
  } {
    val str = x match {
      case _: Int | _: Double => s"a number: $x"
      case "one" => "string one"
      case _: String => s"other string: $x"
      case _ => s"unknown value: $x"
    }
  }
}
