package com.ximo.scala.course05

import scala.collection.mutable.ListBuffer

/**
  *
  * @author xikl
  * @date 2019/2/18
  */
object ListTest extends App {


  // 空值
  Nil

  val list = List(1,2,3,4,5)

  list.head // 1
  list.tail // List(2,3,4,5)

  // List(1)
  val list2 = 1 :: Nil


  val list3 = ListBuffer[Int]()

  list3 += 2

  // 打印
  list3.foreach(println(_))


  def sum(nums: Int*): Int ={
    if (nums.isEmpty) {
      0
    }else{
//      nums.sum
      // :_* 标示变为一个序列 多个参数
      nums.head + sum(nums.tail:_*)
    }

  }

  println(sum())
  println(sum(list3:_*))





}
