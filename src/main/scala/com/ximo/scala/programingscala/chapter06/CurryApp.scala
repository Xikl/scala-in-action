package com.ximo.scala.programingscala.chapter06

import org.antlr.v4.runtime.misc.DoubleKeyMap

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

  val f1: String => String => String =
    (s1: String) => (s2: String) => s1 + s2

  // 等价的 和上面的定义
  val f2: String => (String => String) =
    (s1: String) => (s2: String) => s1 + s2

  f1("hello")("word")
  f2("hello")("word")

  // 去curry 去柯里化
  val unCurryVal = Function.uncurried(cat3Curried)
  unCurryVal("hello", "word")

  // 去柯里化
  val unCurryVal2 = Function.uncurried(f1)
  unCurryVal2("hello", "word")

  def multiplier(i: Int)(factor: Int) = i * factor


  """
    |这种写明了 返回类型的 就不需要 _ 下划线来表示了
  """.stripMargin
  val by20: Int => Int = multiplier(20)
  by20(2)

  val by10 = multiplier(10) _
  by10(3)


  // 元组 乘法 柯里化
  def multi(d1: Double, d2: Double, d3: Double) = d1 * d2 * d3

  val d3 = (1D, 2D, 3D)

  multi(d3._1, d3._2, d3._3)

  val tupleToDouble = Function.tupled(multi _)

  tupleToDouble(d3)

  // 元组逆转化
  val multiFunction: (Double, Double, Double) => Double = Function.untupled(tupleToDouble)

  val finicky: PartialFunction[String, String] = {
    case "finicky" => "FINICKY"
  }

  // FINICKY
  finicky("finicky")

  // error
  finicky("other")

  // 提升为option
  val liftFinicky = finicky.lift

  // None
  liftFinicky("other")

  // Some("FINICKY")
  liftFinicky("finicky")

  // Function.unlift 下降
  val finicky2 = Function.unlift(liftFinicky)

  // none
  finicky2("other")

  // FINICKY
  finicky2("finicky")


}
