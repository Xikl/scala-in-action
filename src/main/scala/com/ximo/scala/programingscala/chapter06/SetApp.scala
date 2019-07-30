package com.ximo.scala.programingscala.chapter06

/**
  *
  *
  * @author xikl
  * @date 2019/7/30
  */
object SetApp extends App {


  val set1 = Set("1", "2", "3")

  // Set(1) 不可重复 + - 加 和 -
  val lengthSet = set1 map (_.length)

  val set2 = set1 + "a" - "b"

  // 就是 ++ 实现的 TraversableLike
  val set3 = set1 ++: Set(1, 2)

  val set4 = set1 ++ Set(1, 2)

}
