package com.ximo.scala.course07

/**
  *
  * @author xikl
  * @date 2019/3/2
  */
object CallByNameAndCallByValue extends App {


  def bar(x: Int, y: => Int) = 0

  def deadLoop():Int = deadLoop

  // 思考

  bar(1, deadLoop()) // => 返回0


  bar(deadLoop(), 1) // => 死循环 无法得到值

  // x为call by value y 为 call by name

  // 第一个方法执行的时候， 由于 x 和 y 都没有被应用到 所以会直接返回1 deadLoop也没有机会去求值
  // 第二个方法执行的时候， 由于x 是call by value 的 所以首先需要执行deadLoop这个方法，死循环无法得到值。故无法正确输出

}
