package com.ximo.scala.programingscala.chapter07

/**
  *
  *
  * @author xikl
  * @date 2019/8/20
  */
object ForOptionsGoodApp extends App {

  def positive(i: Int): Option[Int] =
    if(i > 0 ) Some(i) else None

  for {
    i1 <- positive(5)
    i2 <- positive(10 * i1)
    i3 <- positive(25 * i2)
    i4 <- positive(2 * i3)
  } yield i1 + i2 + i3 + i4

}
