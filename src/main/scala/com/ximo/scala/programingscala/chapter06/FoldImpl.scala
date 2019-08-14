package com.ximo.scala.programingscala.chapter06

/**
  *
  *
  * @author xikl
  * @date 2019/8/14
  */
object FoldImpl {


  def main(args: Array[String]): Unit = {
    val data = List(1, 2, 3)
    println(data.apply(2))

    val seq = Seq(1, 2, 3)
    seq.apply(2)

    val arr = Array(1, 2, 3)
    println(arr.apply(2))

    Vector(1, 2, 3) :+ 4
  }

  /**
    * 尾递归
    *
    * @param s
    * @param f
    * @tparam A
    * @tparam B
    * @return
    */
  def reduceLeft[A, B](s: Seq[A])(f: A => B): Seq[B] = {
    @annotation.tailrec
    def rl(acc: Seq[B], item: Seq[A]): Seq[B] = item match {
        // +: 这个 会将之前的元素拷贝一遍 添加到头部
      case head +: tail => rl(f(head) +: acc, tail)
      case _ => acc
    }

    rl(Seq.empty[B], s)
  }

  /**
    * 用Vector 避免了数据拷贝
    *
    * @param s
    * @param f
    * @tparam A
    * @tparam B
    * @return
    */
  def reduceLeft[A, B](s: Vector[A])(f: A => B): Vector[B] = {
    @annotation.tailrec
    // Vector的部分 将新的值添加到尾部
    def rl(acc: Vector[B], item: Vector[A]): Vector[B] = item match {
      case head +: tail => rl(acc :+ f(head), tail)
      case _ => acc
    }

    rl(Vector.empty[B], s)
  }


  // 普通递归
  def reduceRight[A, B](s: Seq[A])(f: A => B): Seq[B] = {
    s match {
      case head +: tail => f(head) +: reduceRight(tail)(f)
      case _ => Seq.empty[B]
    }
  }


}
