package com.ximo.scala.cource04

/**
  *
  * @author xikl
  * @date 2019/1/20
  */
class People {

  /** 定义属性 */
  var name:String = _

  val age:Int = 10

  /** 性别 */
  private [this] val gender = "male"


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

  /** this的使用   */
  private def printGender(): Unit = {
    println(this.gender)
  }

}

object Main{


  def main(args: Array[String]): Unit = {
    val person = new People()
    person.name = "zwz"
    println(person.name + person.age)

    println(person.eat())


  }
}
