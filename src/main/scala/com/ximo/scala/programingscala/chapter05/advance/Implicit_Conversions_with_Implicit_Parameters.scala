package com.ximo.scala.programingscala.chapter05.advance

/**
  *
  *
  * @author xikl
  * @date 2019/7/22
  */
object Implicit_Conversions_with_Implicit_Parameters {


  def main(args: Array[String]): Unit = {
    """
      |4
      |Spark
      |
    """.stripMargin
    println(bigger(4, 3))
    println(bigger("Spark", "Hadoop"))
  }

  def bigger[T](prev: T, next: T)(implicit ordered: T => Ordered[T]): T = {
    // 或者 if
//    if (prev > next) prev else next
    if (ordered(prev) > next) prev else next
  }

  def lesser[T: Ordering](prev: T, next: T) : T = {
    if (implicitly[Ordering[T]].compare(prev, next) < 0) prev else next
  }
}
