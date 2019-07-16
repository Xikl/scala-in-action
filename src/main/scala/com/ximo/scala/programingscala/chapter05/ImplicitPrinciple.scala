package com.ximo.scala.programingscala.chapter05

/**
  * (1) 只有最后一个参数列表中允许出现隐式参数，这也适用于只有一个参数列表的情况。
  * (2)  implicit 关键字必须出现在参数列表的最左边，而且只能出现一次。列表中出现在
  * implicit 关键字之后的参数都不是“非隐式”的。
  * (3) 假如参数列表以 implicit 关键字开头，那么所有的参数都是隐式的。
  *
  * scala> class Bad1 {
  * | def m(i: Int, implicit s: String) = "boo"
  * <console>:2: error: identifier expected but 'implicit' found.
  * def m(i: Int, implicit s: String) = "boo"
  * ^
  * scala> }
  * <console>:1: error: eof expected but '}' found.
  * }
  * ^
  * scala> class Bad2 {
  * | def m(i: Int)(implicit s: String)(implicit d: Double) = "boo"
  * <console>:2: error: '=' expected but '(' found.
  * def m(i: Int)(implicit s: String)(implicit d: Double) = "boo"
  * ^
  * scala> }
  * <console>:1: error: eof expected but '}' found.
  * }
  * ^
  * scala> class Good1 {
  * | def m(i: Int)(implicit s: String, d: Double) = "boo"
  * | }
  * defined class Good1
  *
  * 原则
  *
  * @author xikl
  * @date 2019/7/16
  */
object ImplicitPrinciple {

  // 只有最后一个参数列表中允许出现隐式参数，这也适用于只有一个参数列表的情况
  def good1(i: Int)(implicit s: String, d: Double) = "boo"

  // implicit 关键字必须出现在参数列表的最左边，而且只能出现一次。列表中出现在
  // implicit 关键字之后的参数都不是“非隐式”
  def good2(implicit i: Int, s: String, d: Double) = "boo"


}
