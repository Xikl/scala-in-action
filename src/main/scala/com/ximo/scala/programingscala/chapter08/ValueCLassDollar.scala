package com.ximo.scala.programingscala.chapter08

/**
  * 价值类：https://www.jianshu.com/p/ed262893e249
  */


object ValueCLassDollar {

  class Dollar(val value: Float) extends AnyVal {
    override def toString: String = "$%.2f".format(value)
  }

  val benjamin = new Dollar(100)


}
