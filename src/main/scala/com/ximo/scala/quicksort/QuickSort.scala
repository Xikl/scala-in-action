package com.ximo.scala.quicksort

/**
  *
  *
  * @author xikl
  * @date 2019/7/9
  */
object QuickSort extends App {


  /**
    * 快速排序
    * 两个问题：
    * 第一个任意类型怎么办 scala中的comparable接口？
    * 第二个：如何进行当个元素和数组连接
    *
    * @param list
    * @return
    */
  def quickSort(list: List[Int]): List[Int] = {
    if (list.length < 2)
      list
    else
      quickSort(list.filter(_ < list.head)) ++
        List(list.head) ++
        quickSort(list.filter(_ > list.head))
  }

}
