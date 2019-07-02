package com.ximo.scala.programingscala.chapter04

/**
  *
  *
  * @author xikl
  * @date 2019/6/26
  */
object MatchSeqApp {


  val nonEmptySeq: Seq[Int] = Seq(1, 2, 3, 4)
  val emptySeq = Seq.empty[Int]

  val nonEmptyList = List(1, 2, 3)
  val emptyList = Nil

  val nonEmptyVector = Vector(1, 2, 3)
  val emptyVector = Vector.empty[Int]

  // 优秀的map创建方式
  val nonEmptyMap = Map("one" -> 1, "tow" -> 2, "three" -> 3)
  val emptyMap = Map.empty[String, Int]

  /**
    * 递归调用传入一个序列 然后返回字符串
    * 相当于遍历
    * 1 +: 2 +: 3 +: 4 +: 5 +: Nil
    * Nil
    * 1 +: 2 +: 3 +: 4 +: 5 +: Nil
    * Nil
    * 1 +: 2 +: 3 +: 4 +: 5 +: Nil
    * Nil
    * (one,1) +: (two,2) +: (three,3) +: Nil
    * Nil
    *
    * 我们只用了两个 case 子句和递归就处理了序列。这暗示了所有序列的基础特性：序列要么
    * 为空，要么非空。这听起来很老套，但一旦理解了这一点，你就会多一个基于“分治”法
    * 的工具
    *
    * @param seq
    * @tparam T
    * @return
    */
  def seqToString[T](seq: Seq[T]): String = seq match {
    // 头部 加上剩下的元素（尾部）
    // 分别提取变量
    case head +: tail => s"$head +: ${seqToString(tail)}"
    case Nil => "Nil"
  }

  // 注意这里将map转化为 seq
  for {
    seq <- Seq(
      nonEmptySeq, emptySeq, nonEmptyList, emptyList,
      nonEmptyVector, emptyVector, nonEmptyMap.toSeq, emptyMap.toSeq
    )
  } println(seqToString(seq))

  val nonEmptyList2 = List(1, 2, 3, 4)
  val emptyList2 = Nil

  def listToString[T](list: List[T]): String = list match {
    case head :: tail => s"($head :: ${listToString(tail)})"
    case Nil => "(Nil)"
  }

  // 用 :: 代替 +:
  for (list <- List(nonEmptyList2, emptyList2)) {
      println(listToString(list))
  }

  // Nil :+ 1 :+ 2 :+ 3 :+ 4 :+ 5
  val nonEmptyList_ = List(1, 2, 3, 4 ,5)
  val nonEmptyVector_ = Vector(1, 2, 3, 4, 5)
  val nonEmptyMap_ = Map("ONE" -> 1, "TWO" -> 2)

  /**
    * 左结合
    * Nil :+ 1 :+ 2 :+ 3 :+ 4 :+ 5
    *
    * @param l
    * @tparam T
    * @return
    */
  def reverseSeqToString[T](l: Seq[T]): String = l match {
    case prefix :+ end => reverseSeqToString(prefix) + s" :+ $end"
    case Nil => "Nil"
  }

  for (seq <- Seq(nonEmptyList_, nonEmptyVector_, nonEmptyMap_.toSeq)) {
    println(reverseSeqToString(seq))
  }

}
