package com.ximo.scala.programingscala.chapter05

/**
  * 二义性
  *
  * @author xikl
  * @date 2019/7/11
  */
object ImplicitErasure extends App {

  // java泛型擦除
  // public void list(List<String> list) {
  //
  //    }
  //
  //    public void list(List<Integer> list) {
  //
  //    }

  // scala 用隐式转化可以解决
  // 自己的类 可以随意编写
  implicit object IntMarker

  implicit object StringMarker

  def m(seq: Seq[Int])(implicit i: IntMarker.type): Unit = {
    println(s"Seq[Int]$seq")
  }

  def m(seq: Seq[String])(implicit s: StringMarker.type): Unit =
    println(s"Seq[String]$seq")

  m(List(1,2,3))
  m(List("one", "two", "three"))

}
