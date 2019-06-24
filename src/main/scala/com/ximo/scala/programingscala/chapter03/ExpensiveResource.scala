package com.ximo.scala.programingscala.chapter03

import java.util.concurrent.TimeUnit

/**
  *
  *
  * @author xikl
  * @date 2019/6/24
  */
object ExpensiveResource {

  def init(): Int = {
    TimeUnit.SECONDS.sleep(3)
    3
  }

  /**
    * 只会执行一次
    * 和普通方法相比
    * getSource: => A
    */
  lazy val resource: Int = init()



}
