package com.ximo.scala.programingscala.chapter05

import scala.collection.parallel.immutable

/**
  * <:< 像一个<・)))><<的东西
  *
  * @author xikl
  * @date 2019/7/15
  * @see TraversableOnce
  */
object ToMap extends App {

  """
    |  def toMap[T, U](implicit ev: A <:< (T, U)): immutable.Map[T, U] = {
    |    val b = immutable.Map.newBuilder[T, U]
    |    for (x <- self)
    |      b += x
    |
    |    b.result()
    |  }
    |
  """.stripMargin



}
