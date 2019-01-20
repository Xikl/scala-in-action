package com.ximo.scala.course03

/**
  *
  * @author xikl
  * @date 2019/1/20
  */
object FunctionStudy {

  def main(args: Array[String]): Unit = {
    println(add(2, 3))

    println(noArgsFunc())
    println(noArgsFunc)
    sayHello("zwz")
  }

  /**
    * 最后一行就是返回值
    *
    * @param x
    * @param y
    * @return
    */
  def add(x: Int, y: Int): Int = {
    x + y
  }

  def noArgsFunc() = 3 + 4

  def sayHello(name: String): Unit ={
    println("hello, " + name)
  }
}
