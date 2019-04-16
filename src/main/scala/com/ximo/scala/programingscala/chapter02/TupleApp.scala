package com.ximo.scala.programingscala.chapter02

/**
  *
  * @author xikl
  * @date 2019/3/12
  */
object TupleApp {

  val tup = ("ss", 222, 3.4)
  println(tup)
  println(tup._1)
  println(tup._2)
  println(tup._3)

  val (a, b, c) = (1, "sss", 6.6)
  println(a)
  println(b)
  println(c)

  val tuple = Tuple3(1, "sss", 3.3)
  println(tuple._1 + tuple._2 + tuple._3)




}
