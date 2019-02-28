package com.ximo.scala.course07

/**
  *
  * @author xikl
  * @date 2019/2/28
  */
object FunctionApp extends App {

  def sayHello(name:String): Unit ={
    println(name)
  }

  // 匿名函数
  (x:Int) => x + 1

  // 写法2
  {x:Int => x + 1}

  val f1 = (x:Int) => x + 1
  f1(1)

  def add = (x:Int, y:Int) => x + y

  add(2, 3)






}
