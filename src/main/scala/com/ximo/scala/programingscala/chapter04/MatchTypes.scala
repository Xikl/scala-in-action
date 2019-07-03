package com.ximo.scala.programingscala.chapter04

/**
  * 泛型的模式匹配
  *
  * @author xikl
  * @date 2019/7/3
  */
object MatchTypes extends App {

  /**
    * 都输出了double
    * (seq double,List(5.5, 5.6, 5.7))
    * (seq double,List(a, b))
    *
    */
//  for {
//    x <- Seq(List(5.5, 5.6, 5.7), List("a", "b"))
//  } yield x match {
//    case seqd: Seq[Double] => println("seq double", seqd)
//    case seqs: Seq[String] => println("seq string", seqs)
//    case _ => println("unknown!", x)
//  }

  def doSeqMatch[T](seq: Seq[T]): String = seq match {
    case Nil => "Nothing"
    case head +: _ =>
      head match {
        case _: Double => "Double"
        case _: String => "String"
        case _ => "Unknown object"
      }
  }

  println("__________________________")

  //seq Double + List(5.5, 5.6, 5.7)
  //seq String + List(a, b)
  //seq Nothing + List()
  Seq(List(5.5,5.6,5.7), List("a", "b"), Nil) foreach{
    case seq: Seq[_] => println(s"seq ${doSeqMatch(seq)} + $seq")
    case _ => println("Unknown")
  }


}
