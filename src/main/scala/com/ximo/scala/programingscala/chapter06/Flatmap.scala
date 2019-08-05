package com.ximo.scala.programingscala.chapter06

/**
  *
  *
  * @author xikl
  * @date 2019/8/5
  */
object Flatmap {


  def main(args: Array[String]): Unit = {
    val list = List("now", "is", "", "the", "time")
    println(list flatMap (_.toList))

    // 一样的操作
    list.map(_.toList) flatten


    // map的过滤
    val stateCapitals = Map(
      "Alabama" -> "Montgomery",
      "Alaska" -> "Juneau",
      "Wyoming" -> "Cheyenne"
    )

    stateCapitals.filter(kv => kv._1 startsWith kv._2)
    // 这里可能是为了迎合模式匹配 而放弃了简洁性
    stateCapitals.filter{case (key, value) => key.startsWith(value)}

    val maybeString = list.find(s => s.startsWith("a"))
    val result = maybeString.getOrElse("default")
    println(result)

    val data = List(1, 2, 3, 4)
    // reduce
    val result1 = data.reduce(_ + _)
    println(result1)

    val result2 = data.fold(0)(_ - _)

    println(result2)

    // 中缀表达式
    val value = (data fold 10) (_ + _)

    val fold1: ((Int, Int) => Int) => Int = (list fold 10) _
    fold1 (_ * _)



  }

}
