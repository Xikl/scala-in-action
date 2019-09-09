package com.ximo.scala.programingscala.chapter07

import scala.util.{Failure, Success, Try}

/**
  *
  * 大Try 不是小try
  */
object ForTryApp extends App {

  /**
    * 假如断言失败， Try 代码块会返回 Failure 对象，该对
    * 象封装了可抛出的 java.lang.AssertionError 对象（http://docs.oracle.com/javase/8/docs/api/
    * java/lang/AssertionError.html）。
    *
    * @param i
    * @return
    */
  def positive(i: Int): Try[Int] = Try {
    assert(i > 0, s"不能小于0")
    i
  }

  // 原理说明版本 和上面的保持一致
  def positive2(i: Int): Try[Int] = {
    if (i > 0) Success(i)
    else Failure(new AssertionError("不能小于0"))
  }

  // Success(3805)
  //Failure(java.lang.AssertionError: assertion failed: 不能小于0)
  val result = for {
    i1 <- positive(5)
    i2 <- positive(10 * i1)
    i3 <- positive(25 * i2)
    i4 <- positive(2 * i3)
  } yield (i1 + i2 + i3 + i4)
  println(result)

  val result2 = for {
    i1 <- positive(5)
    i2 <- positive(-1 * i1) // 失败!
    i3 <- positive(25 * i2)
    i4 <- positive(-2 * i3) // 失败!
  } yield (i1 + i2 + i3 + i4)

  println(result2)

}
