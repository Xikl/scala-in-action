package com.ximo.scala.programingscala.chapter03

/**
  *
  *
  * @author xikl
  * @date 2019/6/19
  */
object ScalaNiubi {


  /**
    * 没有括号
    *
    * 定义那些无副作用的无参方法时省略括号，例如：集
    * 合的 size 方法。定义具有副作用的方法时则添加括号，这样便能提醒读者某些对象可能会
    * 发生变化，需要额外小心。
    */
  List(1, 2, 3).size

  def isEven(n: Int): Boolean = (n % 2) == 0

  // 两种写法 不同的感觉
  // 语言话 “斯巴达式”（斯巴达式，指的是非常简洁的方式）
  List(1, 2, 3, 4) filter isEven foreach println
  // 链式调用
  List(1, 2, 3, 4).filter(isEven).foreach(println)
  // 当然还有写明参数的
  List(1, 2, 3, 4).filter((i: Int) => isEven(i)).foreach((i: Int) => println(i))
  List(1, 2, 3, 4).filter(i => isEven(i)).foreach(i => println(i))

  /**
    *
    * Lisp constructor cons 操作
    */

  val list = List(1, 2, 3, 4)
  // 将0 加入到List中
  0 :: list
  // 等价于
  0::(list)
}
