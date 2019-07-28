package com.ximo.scala.programingscala.chapter06

import scala.annotation.tailrec

/**
  *
  *
  * @author xikl
  * @date 2019/7/28
  */
object Factorial {

  def factorial(n: Long): Long = {
    if (n < 0) {
      throw new IllegalArgumentException()
    }

    if (n == 0) 1
    else n * factorial(n - 1)
  }

  def bestFactorial(n: Long): Long = {
    if (n < 0) {
      throw new IllegalArgumentException()
    }
    bestFactorial(n, 1)
  }

  @tailrec
  private def bestFactorial(n: Long, acc: Long): Long = {
    if(n == 0) acc
    else bestFactorial(n - 1, n * acc)
  }

  def main(args: Array[String]): Unit = {
    (1 to 10) map(factorial(_)) foreach println


  }


}
