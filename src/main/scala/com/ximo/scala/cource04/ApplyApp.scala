package com.ximo.scala.cource04

/**
  *
  * @author xikl
  * @date 2019/1/26
  */
object ApplyApp {

  def main(args: Array[String]): Unit = {
//    for (i <- 1 to 10) {
//      ApplyClass.incr
//    }
//    // 单例对象
//    println(ApplyClass.count)

    // 会执行 object中的apply方法
    val b = ApplyClass()


    println("-----------------")
    val c = new ApplyClass()
    c()

    // 类名() ==> object.apply
    // 对象() ==> class.apply
  }

}

// 伴生类
class ApplyClass{
  def apply() = println("class apply")

}

// 伴生对象
object ApplyClass{

  println("单例对象 enter。。。")

  var count = 0

  def incr = count = count + 1

  def apply() = {
    println("object apply")
    new ApplyClass
  }

  println("单例对象 out。。。")

}