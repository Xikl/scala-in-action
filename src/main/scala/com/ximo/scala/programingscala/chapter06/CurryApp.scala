package com.ximo.scala.programingscala.chapter06

/**
  *
  *
  * @author xikl
  * @date 2019/7/28
  */
object CurryApp extends App {

  // curry 柯里化
  def cat1(s1: String)(s2: String) = s1 + s2

  val cat1Hello = cat1("hello") _
  val helloWord1 = cat1Hello("word")


  // curry + partialFunction
  def cat2(s1: String) = (s2: String) => s1 + s2

  // 不需要 _
  val cat2Hello = cat2("hello")
  val helloWorld2 = cat2Hello("word")


  def cat3(s1: String, s2: String) = s1 + s2

  cat3("hello", "word")

  // FunctionN 最多只能到 Function22 哈哈哈 谁会定义这么多参数
  val cat3Curried = (cat3 _).curried

}
