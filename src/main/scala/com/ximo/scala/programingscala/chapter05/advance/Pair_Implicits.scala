package com.ximo.scala.programingscala.chapter05.advance

/**
  *
  * [T: Ordering]：说明存在一个隐式类型Ordering[T]
  *
  * @author xikl
  * @date 2019/7/22
  */
class Pair_Implicits[T: Ordering](first: T, second: T) {

  //声明一个隐式类型对象传入函数
  def bigger(implicit ordering: Ordering[T]) = {
    if (ordering.compare(first, second) > 0) first else second
  }

  // 简化
  def bigger2 = {
    if(implicitly[Ordering[T]].compare(first, second) > 0) first else second
  }

  // 简化
  def bigger3 = {
    import Ordered.orderingToOrdered
    if (first > second) first else second
  }

}

object Test{
  def main(args: Array[String]): Unit = {
    val pair = new Pair_Implicits(7, 9)
    println(pair.bigger)
    println(pair.bigger2)
    println(pair.bigger3)

  }
}

