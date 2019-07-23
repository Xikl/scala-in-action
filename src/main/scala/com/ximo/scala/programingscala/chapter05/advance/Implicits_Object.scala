package com.ximo.scala.programingscala.chapter05.advance

/**
  *
  *
  * @author xikl
  * @date 2019/7/23
  */
object Implicits_Object {


  trait Template[T] {
    def add(x: T, y: T): T
  }

  trait SubTemplate[T] extends Template[T]{
    def unit: T
  }

  // 这里不能写class
  implicit object StringAdd extends SubTemplate[String] {
    override def unit: String = ""

    override def add(x: String, y: String): String = x.concat(y)
  }

  implicit object IntAdd extends SubTemplate[Int] {
    override def unit: Int = 0

    override def add(x: Int, y: Int): Int = x + y
  }

  def main(args: Array[String]): Unit = {


    def sum[T](list: List[T])(implicit  m: SubTemplate[T]): T = {
      if (list.isEmpty) m.unit
        // 递归调用
      else m.add(list.head, sum(list.tail))
    }

    // 会自己去找寻合适的 隐式类
    println(sum(List(1, 2, 3)))
    println(sum(List("a", "b", "c")))

    val list = List(1, 2, 3, 4)
    println(list.sum)
  }


}
