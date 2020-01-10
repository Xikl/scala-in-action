package com.ximo.scala.programingscala.chapter05

/**
  *
  *
  * @author xikl
  * @date 2019/7/8
  */
object implicitlyArgs extends App {

  case class MyList[A](list: List[A]) {
    def sortBy1[B](f: A => B)(implicit ordering: Ordering[B]): List[A] =
      list.sortBy(f)(ordering)

    def sortBy2[B: Ordering](f: A => B): List[A] =
      list.sortBy(f)(implicitly[Ordering[B]])
  }

  val list = MyList(List(1, 2, 3, 4))

//  val list1 = list sortBy1(i => -i)
  // 负数比较
  val list1 = list sortBy1(-_)
  println(list1)

  val list2 = list sortBy2(-_)
  println(list2)
}
