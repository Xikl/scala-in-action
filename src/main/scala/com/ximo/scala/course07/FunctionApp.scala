package com.ximo.scala.course07

/**
  *
  * @author xikl
  * @date 2019/2/28
  */
object FunctionApp extends App {

  def sayHello(name: String): Unit = {
    println(name)
  }

  // 匿名函数
  (x: Int) => x + 1

  // 写法2
  { x: Int => x + 1 }

  val f1 = (x: Int) => x + 1
  f1(1)

  def add = (x: Int, y: Int) => x + y

  add(2, 3)


  // map filter
  val list = List(1, 2, 3, 4, 5, 6)
  list.map(_ + 1)
    .filter(_ > 4)
    .take(2)
    .foreach(println)

  list.reduce(_ + _)
  list.sum
  list.reduceLeft(_ - _)

  val a = List(1, 7, 2, 9)
  a.reduceLeft(_ - _) // -17 = (((1 - 7) -2) -9)
  a.reduceRight(_ - _) // -13  (1 - (7 - (2 -9)))

  a.fold(0)(_ - _) // -19  ((((0 - 1) - 7) -2) -9)

  // 折叠
  a.foldLeft(0)(_ - _) // -19  ((((0 - 1) - 7) -2) -9)
  val a3 = (0 /: a) (_ - _)

  a.foldRight(0)(_ - _) // (1 - (7 - (2 -(9 -0))))
  val a4 = (a :\ 0) (_ - _)

  val frep = collection.mutable.Map[Char, Int]()

  for (c <- "nihaojava") {
    frep(c) = frep.getOrElse(c, 0) + 1
  }

  val b = List(List(1, 2), List(3, 4))
  b.flatten

  // 变为1234
  b.flatMap(l => l)

  b.flatMap(word => word.map(w => w+ 1))
//  val wordData = List(List("java", "java", "python", "scala"))
  val wordData = "java,java,python,scala"
  // s
  wordData.split(",").map((_,1)).groupBy(_._1).map(t => (t._1, t._2.length))

  val t = Array("hello", "tom", "hello", "jerry", "hello", "hello")
  t.map((_, 1))


}
