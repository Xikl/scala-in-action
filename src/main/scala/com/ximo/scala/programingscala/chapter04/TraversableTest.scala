package com.ximo.scala.programingscala.chapter04

/**
  *
  *
  * @author xikl
  * @date 2019/7/2
  */
object TraversableTest extends App {

  val list = List(1, 2, 3, 4, 5)

  /**
    * def init: Repr = {
    * if (isEmpty) throw new UnsupportedOperationException("empty.init")
    * var lst = head
    * var follow = false
    * val b = newBuilder
    *     b.sizeHint(this, -1)
    * for (x <- this) {
    * if (follow) b += lst
    * else follow = true
    * lst = x
    * }
    *     b.result
    * }
    *  会返回除了最后一个元素的所有元素
    */
  list.init


}
