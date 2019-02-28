package com.ximo.scala.course07

/**
  *
  * @author xikl
  * @date 2019/2/28
  */
object CurryApp extends App {



  // 颗粒话
  def curryTest(a:Int)(b:Int) = a + b

  curryTest(2)(3)

  def curryTest2(a:Int) = (b:Int) => a + b

  curryTest2(2)(3)



}
