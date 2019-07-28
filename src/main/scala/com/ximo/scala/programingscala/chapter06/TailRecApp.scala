package com.ximo.scala.programingscala.chapter06

import scala.util.control.TailCalls._

/**
  * 奇怪的类 TailCalls
  *
  * @author xikl
  * @date 2019/7/28
  */
object TailRecApp {

  def isOdd(list: List[Int]): TailRec[Boolean] =
    if (list.isEmpty) done(false)
    else tailcall(isEven(list.tail))

  def isEven(list: List[Int]): TailRec[Boolean] =
    if (list.isEmpty) done(true)
    else tailcall(isOdd(list.tail))

  (1 to 10) map (i => (1 to i).toList) map (isEven(_).result) foreach println

}
