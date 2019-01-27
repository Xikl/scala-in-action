package com.ximo.scala.course05

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @author xikl
  * @date 2019/1/27
  */
object ArrayTest extends App {

  println("test")

  val array = new Array[String](5)

  println(array)

  array(1) = "a"

  println(array(1))

  var array2 = Array(1, 2, 3)
  array2.foreach(println(_))

  /** 最小值 */
  array2.min
  /** 最大值 */
  array2.max
  /** 求和 */
  array2.sum

  println(array2.mkString("{", ", ", "}"))


  val sb = new StringBuilder
  sb append "1"

  println(sb.toString)

  Option

}
