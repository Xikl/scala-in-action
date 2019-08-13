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
    stateCapitals.filter { case (key, value) => key.startsWith(value) }

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

    // 奇怪的写法
    //    val fold1: ((Int, Int) => Int) => Int = (list fold 10) _
    //    fold1 (_ * _)

    // 对空集合进行操作
    // 返回10
    (Nil fold 10) (_ + _)

    // 无法操作
    //java.lang.UnsupportedOperationException: empty.reduceLeft
    //  at scala.collection.LinearSeqOptimized.reduceLeft(LinearSeqOptimized.scala:139)
    //  at scala.collection.LinearSeqOptimized.reduceLeft$(LinearSeqOptimized.scala:138)
    //  at scala.collection.immutable.List.reduceLeft(List.scala:89)
    //  at scala.collection.TraversableOnce.reduce(TraversableOnce.scala:211)
    //  at scala.collection.TraversableOnce.reduce$(TraversableOnce.scala:211)
    //  at scala.collection.AbstractTraversable.reduce(Traversable.scala:108)
    //  ... 28 elided
    //    List.empty[Int] reduce(_ + _)

    // 但是可以用 另一种代替
    // None
    List.empty[Int] reduceOption (_ + _)

    //  (List(1, 2, 3, 4,5, 6) foldRight  List.empty[String]) {
    //      (x, list) => (s"[$x]") :: list
    //    }
    // List[String] = List([1], [2], [3], [4], [5], [6])
    (List(1, 2, 3, 4, 5, 6) foldRight List.empty[String]) {
      (x, list) => s"[$x]" :: list
    }

    // List[String] = List([6], [5], [4], [3], [2], [1])
    (List(1, 2, 3, 4, 5, 6) foldLeft List.empty[String]) {
      (list, x) => s"[$x]" :: list
    }

    // sum
    val f1 = (List(1, 2, 3) fold 10) (_ * _)
    val r = List(1, 2, 3) reduce (_ + _)

    val f2 = (List(1, 2, 3) foldLeft 10) (_ * _)

    val r2 = List(1, 2, 3) reduceLeft (_ + _)

    val f3 = (List(1, 2, 3) foldRight 10) (_ * _)
    val r3 = List(1, 2, 3) reduceRight (_ + _)

    // 从左到右
    val facLeft = (acc: Int, x: Int) => acc + x

    // 从右到左
    val facRight = (x: Int, acc: Int) => acc + x

    val list2 = List(1, 2, 5, 3, 4)

    list2 reduceLeft facLeft
    list2 reduceRight facRight

  }

}
