package com.ximo.scala.programingscala.chapter03


/**
  *
  *
  * @author xikl
  * @date 2019/6/20
  */
object MyContinue extends App {

  /**
    * 传名参数 => Boolean
    *
    * 每次使用该参数时便会执行表达式
    *
    * @param conditional 条件
    * @param body
    */
  @annotation.tailrec
  def continue(conditional: => Boolean)(body: => Unit): Unit = {
    if (conditional) {
      body
      continue(conditional)(body)
    }
  }

  var count = 0
  continue(count < 5){
    println(s"ag $count")
    count += 1
  }



}
