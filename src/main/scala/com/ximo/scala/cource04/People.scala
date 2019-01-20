package com.ximo.scala.cource04

/**
  *
  * @author xikl
  * @date 2019/1/20
  */
class People {

  /** 定义属性 */
  var name:String = ""

  val age:Int = 10


  def eat():String = {
    name + "eating"
  }


  /**
    * 看球
    *
    */
  def watchFootball() = {
    println(name + "watching football")
  }


}

object Main{


  def main(args: Array[String]): Unit = {
    val person = new People()
    person.name = "zwz"
    println(person.name + person.age)
  }
}
