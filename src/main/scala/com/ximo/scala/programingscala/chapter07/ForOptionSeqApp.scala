package com.ximo.scala.programingscala.chapter07

/**
  *
  *
  * @author xikl
  * @date 2019/8/20
  */
object ForOptionSeqApp extends App {

  val result = Vector(Some(10), None, Some(20))

  // Option 可以过滤空的数据
  val res: Vector[Int] = for {
    Some(data) <- result
  } yield 2 * data
  println(res)




}
