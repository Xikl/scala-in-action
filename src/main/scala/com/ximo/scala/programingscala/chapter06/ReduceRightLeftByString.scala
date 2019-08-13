package com.ximo.scala.programingscala.chapter06

/**
  *
  *
  * @author xikl
  * @date 2019/8/14
  */
object ReduceRightLeftByString {


  // 值得思考
  def main(args: Array[String]): Unit = {
    val fnacLeft = (acc: String, item: String) => s"($acc) - ($item)"

    val fnacRight = (item: String, acc: String) => s"($acc) - ($item)"

    val data = List(1, 2, 3, 4, 5) map(_.toString)

    // ((((1) - (2)) - (3)) - (4)) - (5)
    println(data reduceLeft fnacLeft)

    // ((((5) - (4)) - (3)) - (2)) - (1)
    println(data reduceRight fnacRight)

    // (acc item)
    println(data reduceLeft fnacRight)

    println(data reduceRight fnacLeft)


  }



}
