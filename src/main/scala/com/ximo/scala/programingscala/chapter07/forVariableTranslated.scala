package com.ximo.scala.programingscala.chapter07

/**
  *
  *
  * @author xikl
  * @date 2019/8/20
  */
object forVariableTranslated extends App {


  val map = Map("one" -> 1, "two" -> 2)

  val list1 = for {
    (key, value) <- map
    result = key + value
  } yield result





}
