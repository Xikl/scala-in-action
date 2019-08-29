package com.ximo.scala.programingscala.chapter07

object ForEitherApp extends App {

  /**
    * Stirng 为错误信息
    * Int为真正的值
    *
    * @param i
    * @return
    */
  def positive(i: Int): Either[String, Int] = {
    if (i > 0) Right(i) else Left(s"不能为负数: $i")
  }

  // Right(3805)
  val result = for {
    i1 <- positive(5).right
    i2 <- positive(10 * i1).right
    i3 <- positive(25 * i2).right
    i4 <- positive(2 * i3).right
  } yield i1 + i2 + i3 + i4

  println(result)

  val result2 = for {
    i1 <- positive(5).right
    i2 <- positive(-1 * i1).right // 失败!
    i3 <- positive(25 * i2).right
    i4 <- positive(-2 * i3).right // 失败!
  } yield i1 + i2 + i3 + i4

  // Left(不能为负数: -5)
  println(result2)


  val l = Left("boo")
  l.left.map(str => str.length).foreach(println(_))

  println(l)

  // 左右都能访问
  val r: Either[String, Int] = Right(2)
  r.left.map(_.length)
  r.right.map(_ + 2)
  println(r)

  val l1: Either[String, Int] = Left("boo")

  // 中缀表达式
  val l2: String Either Int = Left("booooooooooo")

  //
  type Or[A, B] = Either[A, B]

  val r2: String Or Int = Left("String")

  println(r2)

  def addInts(s1: String, s2: String): Int = {
    s1.toInt + s2.toInt
  }

  for {
    i <- 1 to 3
    j <- 1 to i
  } println(s"$i + ")

  /**
    *
    * 存储异常
    *
    * @param s1
    * @param s2
    * @return
    */
  def addIntByEither(s1: String, s2: String): NumberFormatException Either Int = {
    try {
      Right(s1.toInt + s2.toInt)
    } catch {
      case e : NumberFormatException => Left(e)
    }
  }

  // Left(java.lang.NumberFormatException: For input string: "sss")
  println(addIntByEither("sss", "1"))


}

