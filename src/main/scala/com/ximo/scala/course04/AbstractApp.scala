package com.ximo.scala.course04

/**
 *
 * @author xikl
 * @date 2019/1/26
 */
object AbstractApp {

  def main(args: Array[String]): Unit = {
    val my = new ConcreteClass()
    println(my.name)
    my.name = "21222"
    println(my)
  }
}

abstract class BaseClass {

  def speak

  var name: String

  val age: Int


}

class ConcreteClass extends BaseClass {
  override def speak: Unit = {
    println("wode lei")

  }

  override var name: String = "name"
  override val age: Int = 12

  override def toString: String = s"ConcreteClass, name: $name, age: $age"
}

