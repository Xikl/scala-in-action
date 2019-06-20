package com.ximo.scala.programingscala.chapter03


/**
  *
  *
  * @author xikl
  * @date 2019/6/20
  */
object MyContinue extends App {

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
