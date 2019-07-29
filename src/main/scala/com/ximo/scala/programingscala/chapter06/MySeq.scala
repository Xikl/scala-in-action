package com.ximo.scala.programingscala.chapter06

/**
  *
  *
  * @author xikl
  * @date 2019/7/30
  */
package object MySeq {

  type Seq[+A] = scala.collection.immutable.Seq[A]
  val Seq = scala.collection.immutable.Seq

}
