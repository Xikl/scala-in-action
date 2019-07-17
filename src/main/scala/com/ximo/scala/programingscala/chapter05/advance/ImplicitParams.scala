package com.ximo.scala.programingscala.chapter05.advance

/**
  * 学习：https://www.jianshu.com/p/ebbb148e5fd6
  * 听歌：灰原穷-狐之恋
  *
  * @author xikl
  * @date 2019/7/17
  */
object ImplicitParams {

  //函数中用implicit关键字 定义隐式参数
  object Context_Implicits {
    implicit val default: String = "Java"
  }

  object Param {
    def print(context: String)(implicit language: String): Unit ={
      println(s"$language:$context")
    }
  }

  def main(args: Array[String]): Unit = {
    //隐式参数正常是可以传值的，和普通函数传值一样  但是也可以不传值，因为有缺省值(默认配置)
    Param.print("sss")("scala")

    import Context_Implicits._
    //隐式参数没有传值，编译器会在全局范围内搜索 有没有implicit String类型的隐式值 并传入
    Param.print("ssss")
  }

}