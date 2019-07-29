package com.ximo.scala.programingscala.chapter06

/**
  *
  *
  * @author xikl
  * @date 2019/7/29
  */
object VectorApp extends App {

  val v1 = Vector(1, 2, 3)

  val v2 = v1 :+ 4
  val v3 = 1 +: 2 +: 3 +: Vector.empty

  val b4 = v1 ++ v3

  b4(4)
}
