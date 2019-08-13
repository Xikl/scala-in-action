package com.ximo.scala.programingscala.chapter06

object ListApp extends App {


  val array = Array(1, 2, 3)
  array.toList

  val list = List(3, 4, 5)


  // 每次添加 时间复杂度 为 O(1)
  // List才有 ::
  val result = 1 :: 2 :: 3 :: list
  println(result)

  val listFromNil = 1 :: 2 :: 3 :: Nil

  List.empty

  val listUnion = List(1, 2, 3) ++ List(4, 5)

  // 最好使用 Seq 因为List 和 Vector 都是他的子类

}
