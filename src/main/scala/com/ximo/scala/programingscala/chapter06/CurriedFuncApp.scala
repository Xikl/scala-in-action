package com.ximo.scala.programingscala.chapter06

/**
  *
  *
  * @author xikl
  * @date 2019/7/28
  */
object CurriedFuncApp extends App {

  def cat1(s1: String)(s2: String) = s1 + s2

  // 注意柯里化这里的 一个下划线
  val hello = cat1("hello") _

  println(hello("word"))



}
