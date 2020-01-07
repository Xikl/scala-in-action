package com.ximo.scala

/**
 * 斐波那契数列
 * 不采用递归的方式 减少调用次数
 *
 * @author xikl
 * @date 2020/1/8
 */
object FibApp extends App {

  def fib(num: Int): Long = {
    if (num == 1 || num == 2) {
      1
    } else {
      var f1 = 1L;
      var f2 = 1L;
      for (i <- 3 to num) {
        f2 = f1 + f2
        f1 = f2 - f1
      }
      f2
    }
  }

  println(fib(50))

  3 to 3 foreach(println(_))

}
