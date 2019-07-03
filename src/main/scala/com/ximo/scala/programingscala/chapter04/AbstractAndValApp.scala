package com.ximo.scala.programingscala.chapter04

/**
  * 抽象类中定义一个没有参数的方法
  * 可以用val 变量 或者 override def 实现
  *
  * @author xikl
  * @date 2019/7/3
  */
object AbstractAndValApp extends App {

  abstract class Animal{
    def getName: String

    def getNameLength: Int
  }

  class Bird(name: String) extends Animal{
    // 使用 val变量和 def 方法 可以达到一样的效果
    val getName: String = name

    override def getNameLength: Int = name.length
  }

  val bird = new Bird("Bob")
  println(bird.getName)
  println(bird.getNameLength)

}
