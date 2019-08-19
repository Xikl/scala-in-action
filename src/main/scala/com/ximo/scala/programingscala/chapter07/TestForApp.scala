package com.ximo.scala.programingscala.chapter07

/**
  *
  *
  * @author xikl
  * @date 2019/8/19
  */
object TestForApp {

  def main(args: Array[String]): Unit = {
    val seq = Seq(1, 2, 3)
    for {
      s <- seq
      (bool, s2) = if (s == 1) (true, s) else (false, s)
      result = add(s2, bool)
    } println(result)
  }

  def add(num: Int, bool: Boolean): Int = {
    println(bool)
    num + 1
  }

}
