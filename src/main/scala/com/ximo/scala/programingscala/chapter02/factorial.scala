package com.ximo.scala.programingscala.chapter02

import scala.annotation.tailrec

/**
  *
  * @author xikl
  * @date 2019/3/12
  */
class factorial {

  /**
    * 尾递归
    * 两次使用变量i 且嵌套方法中的变量i不受外界影响
    *
    * @param i
    * @return
    */
  def factorial(i: Int): Long = {
    @tailrec
    def fact(i: Int, accumulator: Int): Long = {
      if (i <= 1) accumulator
      else fact(i - 1, i * accumulator)
    }

    fact(i, 1)
  }

  // 递归调用
  (0 to 5) foreach (i => println(factorial(i)))

  """
    |错误的尾递归示范
    |
  """.stripMargin

  def errorTailFactorial(i: Int): Long = {
    if (i <= 1) {
      1L
    } else {
      errorTailFactorial(i - 1) * errorTailFactorial(i - 2)
    }
  }


  /**
    * count 计数
    *
    * @param n
    */
  def countTo(n: Int): Unit = {
    def count(i: Int): Unit = {
      if (i <= n) {
        println(i)
        count(i + 1)
      }
    }
    count(1)
  }
}
