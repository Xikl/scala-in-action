package com.ximo.scala.programingscala.chapter04

/**
  *
  *
  * @author xikl
  * @date 2019/7/3
  */
object MatchSeqUnapplySeq extends App {

  val nonEmptyList = List(1, 2, 3, 4, 5)
  val emptyList = Nil
  val nonEmptyMap = Map("one" -> 1, "two" -> 2, "three" -> 3)

  /**
    * 匹配大于等于两个
    * 匹配大于等于1个的
    * 匹配Nil
    *
    * @param seq
    * @tparam T
    * @return
    */
  def windows[T](seq: Seq[T]): String = seq match {
    case Seq(head1, head2, _*) =>
      s"($head1, $head2), + ${windows(seq.tail)}"
    case Seq(head, _*) =>
      s"($head, _), + ${windows(seq.tail)}"
    case Nil => "Nil"

  }

  /**
    * +:
    * 比上面更加简洁
    *
    * @param seq
    * @tparam T
    * @return
    */
  def windows2[T](seq: Seq[T]): String = seq match {
    case head1 +: head2 +: tail =>
      s"($head1, $head2), + ${windows(tail)}"
    case head +: tail =>
      s"($head, _), + ${windows(tail)}"
    case Nil => "Nil"
  }

  /**
    * (1, 2), + (2, 3), + (3, 4), + (4, 5), + (5, _), + Nil
    * Nil
    * ((one,1), (two,2)), + ((two,2), (three,3)), + ((three,3), _), + Nil
    *
    */
  for (seq <- Seq(nonEmptyList, emptyList, nonEmptyMap.toSeq)) {
//    println(windows(seq))
    println(windows2(seq))
  }

  // 补充
  val seq = Seq(1,2,3,4,5)
  // 直接求值
  // res9: List[Seq[Int]] = List(List(1, 2), List(2, 3), List(3, 4), List(4, 5))
  seq.sliding(1, 2).toList
  // 惰性
  // res11: Seq[Seq[Int]] = Stream(List(1, 2), ?)
  seq.sliding(1, 2).toSeq
}
