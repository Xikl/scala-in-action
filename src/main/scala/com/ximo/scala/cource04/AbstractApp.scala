package com.ximo.scala.cource04

/**
  *
  * @author xikl
  * @date 2019/1/26
  */
object AbstractApp {

  def main(args: Array[String]): Unit = {
    val my = new ConcreteClass()
    println(my.name)
  }
}

abstract class BaseClass{

  def speak

  val name:String

  val age:Int


}

class ConcreteClass extends BaseClass{
  override def speak: Unit = {
    println("wode lei")

  }

  override val name: String = "name"
  override val age: Int = 12
}

