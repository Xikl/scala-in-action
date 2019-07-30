package com.ximo.scala.programingscala.chapter06

/**
  *
  *
  * @author xikl
  * @date 2019/7/30
  */
object MapApp extends App {


  val map1 = Map(1 -> "a", 2 -> "b")

  // Map(1 -> 1, 2 -> 1)
  val map2 = map1 map (kv => (kv._1, kv._2.length))

  // 转化为 大写 Map(1 -> "A", 2 -> "B")
  val map3 = map1 map {
    case (k, v) => (k, v.toUpperCase)
  }

  // map的添加操作
  val map4 = map1 + (3 -> "c")

  val map5 = map1 + (3 -> "c", 4 -> "d")

  // 删除元素
  val map6 = map1 - 1

}
