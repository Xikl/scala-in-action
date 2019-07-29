package com.ximo.scala.programingscala.chapter06

/**
  * List对于那些需要访问头部以外元素的操作，都需要 O(n) 操作。
  * Vector的所有操作都是O(1)常数时间
  *
  * @author xikl
  * @date 2019/7/29
  */
object SeqApp extends App {

  val seq1 = Seq("scala", "programming")

  val seq2 = "People" +: "should" +: "read" +: seq1

  val seq3 = 1 +: 2 +: Seq.empty

  val seq4 = 1 +: 2 +: 3 +: Nil

  val seq5 = seq4 ++ seq3

  // : 总是靠近 集合元素
  val seq6 = Seq(1, 2, 3) :+ 4

  val immutableSeq = scala.collection.immutable.Seq()
}
