package com.ximo.scala.programingscala.chapter02

/**
  *
  *
  * @author xikl
  * @date 2019/4/23
  */
class SealedApp {

  /**
    * 利用sealed防止用户派生任何子类
    * @see Option
    *
    */
  sealed abstract class MyClass() {
    def print(s: String): Unit = {
      println(s)
    }
  }

  def stuffWithBIgInteger(): Unit = {
    import java.math.BigInteger.{
      ONE => _,
      TEN,
      ZERO => JAVAZERO
    }

    // 利用下划线 将 one进行隐藏
//    println("ONE" + ONE)
    println("TEN" + TEN)
    println("JAVAZERO" + JAVAZERO )
  }


}
