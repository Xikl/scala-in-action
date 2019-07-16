package com.ximo.scala.programingscala.chapter05

/**
  * 对于Map(1 -> "aa", 2 -> "bb")的隐式转化思考
  * 假如当前适用多条转换方法，那么将不会执行转换操作。编译器要求有且必须只有一条
  * (1) 假如调用的对象和方法成功通过了组合类型检查，那么类型转换不会被执行。
  * (2) 编译器只会考虑使用了 implicit 关键字的类和方法。
  * (3) 编译器只会考虑当前作用域内的隐式类，隐式方法，以及目标类型的伴生对象中定义的
  * 隐式方法（本文后续部分将讲讨论这种情况）。
  * (4) 隐式方法无法串行处理，我们无法通过一个中间类型，使用串行的隐式方法将起始类型
  * 转换成目标类型。编译器执行隐式转换时只会考虑那些接受单一类型实例输入且返回目
  * 标类型实例的方法。
  * (5) 假如当前适用多条转换方法，那么将不会执行转换操作。编译器要求有且必须只有一条
  * 满足条件的隐式方法，以免产生二义性。
  *
  * @author xikl
  * @date 2019/7/16
  */
object ImplicitForMapThinking {

  /**
    * def apply[A, B](elems: (A, B)*): CC[A, B] = (newBuilder[A, B] ++= elems).result()
    * (1) 编译器发现我们试图对 String 对象执行 -> 方法（例如  “one” -> 1 ）。
    * (2) 由于 String 未定义 -> 方法，编译器将检查当前作用域中是否存在定义了该方法的隐式
    * 转换。
    * (3) 编译器发现了 ArrowAssoc 类。
    * (4) 编译器将创建 ArrowAssoc 对象，并向其传入 one 字符串。
    * (5) 之后，编译器将解析表达式中的 -> 1 部分代码，并确认了整个表达式的类型与 Map.
    * apply 方法的预期类型相吻合，即两者均为 pair 实例。
    */
  Map(1 -> "aa", 2 -> "bb")

  // 针对第三条的理解
  // 编译器只会考虑当前作用域内的隐式类，隐式方法，以及目标类型的伴生对象中定义的
  // 隐式方法（本文后续部分将讲讨论这种情况）
  case class Foo(s: String)
  object Foo {
    implicit def fromString(s: String): Foo = Foo(s)
  }

  class Test{
    def m1(foo: Foo): Unit = println(foo)
    def m(s: String): Unit = m1(s)
    // 假设有一个新的 转化 那么会优先适用它
    implicit def from(s: String): Foo = Foo(s)
  }

}
