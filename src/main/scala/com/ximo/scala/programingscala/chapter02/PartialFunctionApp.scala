package com.ximo.scala.programingscala.chapter02

/**
  *
  * @author xikl
  * @date 2019/3/11
  */
object PartialFunctionApp extends App {

  /**  只匹配字符串的偏函数。*/
  val pf1: PartialFunction[Any, String] = {
    case _: String => "Yes"
  }

  /** 只匹配 Double 数字的偏函数。 */
  val pf2: PartialFunction[Any, String] = {
    case _: Double => "Double type"
  }

  /** 将这两个函数结合，得到一个新的偏函数：既能匹配字符串，又能匹配 Double 数字。 */
  /** 偏函数的部分 orElse */
  val pf = pf1 orElse pf2

  /**
    * 辅助函数：用于 try 一个偏函数，然后将可能产生的 MatchError 异常捕捉到。无论是
    * 否捕获异常，函数均返回一个字符串。
    *
    * @param x
    * @param f
    * @return
    */
  def tryPf(x: Any, f: PartialFunction[Any, String]): String = {
    try {
      // 调用偏函数
      f(x)
    } catch {
      case _: MatchError => "Error"
    }
  }

   /**
    *  使用了 isDefineAt
     * 判断该值是否在该函数的处理范围 返回true or false
    */
  def d(x: Any, f: PartialFunction[Any, String]) = f.isDefinedAt(x).toString

  println("  | pf1 - String  | pf2 - Double  | pf - All")
  println("x | def? | pf1(x) | def? | pf2(x) | def? | pf(x)")
  println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
  List("str", 3.14, 10) foreach(x => {
    printf("%-5s | %-5s | %-6s | %-5s | %-6s | %-5s | %-6s\n",
      x.toString, d(x, pf1), tryPf(x, pf1), d(x, pf2), tryPf(x, pf2), d(x, pf), tryPf(x, pf))
  })

  def m1[A](a: A, f: A => String) = f(a)
  // 这种情况会报错 str缺少类型 因为 scalac无法推断str的类型
//  m1("sss", str => str.toString)
  // 应该这样写
  m1("sss", (str: String) => str.toString)

  // 我们看另外一种写法
  // 这种方式就能推断
  def m2[A](a: A)(f: A => String) = f(a)
  m2("sss")(str => str.toString)

  // collect 收集为新的集合
  val sample = 1 to 10
  val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x + " is even"
  }

  // the method collect can use isDefinedAt to select which members to collect
  val evenNumbers = sample collect isEven

}
