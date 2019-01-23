package com.ximo.scala.course03

/**
  *
  * @author xikl
  * @date 2019/1/20
  */
object FunctionStudy {

  def main(args: Array[String]): Unit = {
    println(add(2, 3))

    println(noArgsFunc())
    println(noArgsFunc)
    sayHello("zwz")
    sayHello()

    println(sumRange(1, 2, 3, 4))
  }

  /**
    * 最后一行就是返回值
    *
    * @param x
    * @param y
    * @return
    */
  def add(x: Int, y: Int): Int = {
    x + y
  }

  def noArgsFunc() = 3 + 4

  def sayHello(name: String = "unknown"): Unit = {
    println("hello, " + name)
  }

  /**
    * 可变参数
    *
    * @param numbers
    * @return
    */
  def sumRange(numbers: Int*): Int = {
    var result = 0
    // 循环
    for (num <- numbers) {
      result += num
    }
    result
  }

  /**
    * 学习if
    *
    * @param num
    * @return
    */
  def studyIf(num: Int): Boolean = {
//    if (num > 0) {
//      true
//    } else{
//      false
//    }
    num > 0
  }

  def studyToAndRange(): Unit={
    // 循环表达式
    // to 包括1 和 10
    1 to 10
    1.to(10)

    // range
    // error step 不等于0
//    Range(1, 10, 0)

    // Range 和 until 都不包括最后一个值
    Range(1, 10, 1).foreach(i => println(i))

    Range(10, 1, -1).foreach(i => println(i))

    1.until(10).foreach(println(_))

    for(i <- 1 to 10 if i % 2 == 0) {
      println(i)
    }

    val courses = Array("python", "java", "scala")
    for (course <- courses) {
      println(course)
    }

    courses.foreach(println(_))

    var (num, sum) = (100, 0)
    while (num > 0) {
      sum += num
      num = num - 1
    }

  }



}
