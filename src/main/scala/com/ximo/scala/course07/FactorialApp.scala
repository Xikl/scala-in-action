package com.ximo.scala.course07

import scala.annotation.tailrec

/**
  *
  * @author xikl
  * @date 2019/3/2
  */
object FactorialApp extends App {

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  /**
    * 尾递归优化
    *
    * @param n 需要计算阶乘的值
    * @param m 初始值
    * @return
    */
  @tailrec
  def factorial(n: Int, m: Int): Int = {
    if (n <= 0) m
    else factorial(n - 1, n * m)
  }

  factorial(1, 1)
  factorial(5, 1)


  // curry 柯里化
  def sum(f: Int => Int)(a: Int)(b: Int): Int = {

    @tailrec
    def loop(n :Int, acc: Int) :Int = {
      if (n > b) {
        println(s"n=$n, acc=$acc")
        acc
      } else{
        println(s"n=$n, acc=$acc")
        loop(n + 1, acc + f(n))
      }
    }
    loop(a, 0)
  }

  sum(x => x * x)(1)(5)



}



