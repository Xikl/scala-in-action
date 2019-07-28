package com.ximo.scala.programingscala.chapter06

object HofsClosureExample extends  App {

  var factor = 2

  val multiplier = (i: Int) => i * factor

  (1 to 10) filter(_ % 2 == 0) map multiplier reduce (_ * _)

  factor = 3

  (1 to 10) filter(_ % 2 == 0) map multiplier reduce(_ * _)







}
