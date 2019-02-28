package com.ximo.scala.course04

/**
  *
  * @author xikl
  * @date 2019/1/26
  */
object CaseClassApp {

  def main(args: Array[String]): Unit = {
    println(Dog("zwz").name)
  }

}

// 不用new 直接用 通常用在模式匹配中
case class Dog(name:String){


}
