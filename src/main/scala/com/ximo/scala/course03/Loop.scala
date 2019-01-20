package com.ximo.scala.course03

/**
  *
  * @author xikl
  * @date 2019/1/20
  */
object Loop {

  def main(args: Array[String]): Unit = {
    1 to 10
    1.to(10)
    val range = Range(1, 10)
    println(range)
    println(1.until(10))

    for (i <- 1 to 10 if i % 2 == 0) {
      print(i)
    }
    println()

    val lans = Array("Java", "Python", "Scala", "Spark")
    for (elem <- lans) {
      print(elem)
    }

    println()
    lans.foreach(lan => print(lan))
    println()

    var (num, sum) = (100, 0)
    while (num > 0) {
      sum += num
      num = num - 1
    }
    println(sum)
  }


}
