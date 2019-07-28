package com.ximo.scala.programingscala.chapter06

/**
  * 偏函数
  * 准确的来说 就是 返回的是一个原函数没有定义的参数列表的一个函数
  *
  * @author xikl
  * @date 2019/7/28
  */
object PartialFunctionApp extends App {

  // 只处理double的偏函数
  val inverse: PartialFunction[Double, Double] = {
    case d if d != 0.0 => 1.0 / d
  }



}
