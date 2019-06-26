package com.ximo.scala.programingscala.chapter04

/**
  * case 语句中使用if判断
  *
  * @author xikl
  * @date 2019/6/26
  */
object MatchGuard {

  for (i <- Seq(1, 2, 3)) {

    i match {
      case _ if i % 2 == 0 => println(s"even: $i")
      case _ => println(s"odd: $i")
    }
  }


}
