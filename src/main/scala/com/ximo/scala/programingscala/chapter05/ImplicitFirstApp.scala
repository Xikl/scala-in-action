package com.ximo.scala.programingscala.chapter05

/**
  *
  *
  * @author xikl
  * @date 2019/7/8
  */
object ImplicitFirstApp extends App {

  def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate

  implicit val currentTaxRate: Float = 0.08F

  val tax = calcTax(50000)



}
