package com.ximo.scala.programingscala.chapter06

object HofsClosure2Example {

  // 方法
  def range1To10(multiplier: Int => Int) = {
    ((1 to 10) filter (_ % 2 == 0) map multiplier).product
  }

  def multiplierFunc: Int => Int = {
    val factor = 2
    val multiplier = (i: Int) => i * factor
    multiplier
  }

  range1To10(multiplierFunc)


}
