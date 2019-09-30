package com.ximo.scala.programingscala.chapter08

/**
  * 一元方法
  * unary_
  *
  * 方法名为 unary_X ，这里 X 就是我们想要使用的操作符。在本例中， X 就是 - 。注意 -
  * 和 : 之间的空格，空格在这里是必须的，它可以告诉编译器方法名以 - 而不是 : 结尾！
  * 为了比较，我们也实现了常见的减号操作符。
  *
  */
object ComplexApp  extends App {

  case class Complex(real: Double, imag: Double) {
    def unary_- : Complex = Complex(-real, imag)

    def unary_+ : Complex = Complex(real, imag)

    def -(other: Complex) = Complex(real - other.real, imag - other.imag)
  }

  val c1 = Complex(1.1, 2.2)

  val c2 = -c1

  val c3 = c1.unary_-

  val c4 = c1 - c3

  val c5 = +c1
}
