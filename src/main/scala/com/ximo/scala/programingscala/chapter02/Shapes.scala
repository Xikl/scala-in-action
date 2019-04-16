package com.ximo.scala.programingscala.chapter02

/**
  *
  * @author xikl
  * @date 2019/3/11
  */
class Shapes {


  /** copy方法是case类中自己创建的方法 */
  case class Point(x: Double = 0.0, y: Double = 0.0) {
    def shift(deltax: Double, deltay: Double): Unit = {
      copy(x + deltax, y + deltay)
    }
  }

  val p1 = Point(x = 3.3, y = 4.4)
  // 克隆模式 类型 相当于只修改与原始值不一样的地方
  //命名参数列表让客户端代码更具可读性。当参数列表很长，且有若干参数是同一类型时，
  //bug 容易避免，因为在这种情况下很容易搞错参数传入的顺序

  val p2: Point = p1.copy(y = 6.6)

  abstract class Shape() {
    /**
      * 传递两个参数
      *
      *
      * @param offset 偏移量
      * @param f 具体的操作
      */
    def draw(offset: Point = Point())(f: String => Unit): Unit = {
      f(s"draw something offset = $offset, ${this.toString}")
    }

    def draw2(offset: Point = Point(), f: String => Unit): Unit ={
      draw(offset)(f)
    }
  }

  case class Circle(center: Point, radius: Double) extends Shape

  case class Rectangle(lowerLeft: Point, height: Double, width: Double) extends Shape

  val shape = Circle(Point(), 2.0)
  // Scala 允许我们把参数列表两边的圆括号替换为花括号 牛逼
  shape.draw(Point(1.0, 2.0))(str => println(s"Drawing $str"))

  shape.draw(Point(2.0, 2.0)){ str => println(s"drawing $str")}

  // 假设像java一样编写多个 参数在一个方法里
  shape.draw2(Point(1.0, 2.0), str => println(s"drawing $str"))

  // 或者使用缺省的值 必须指定是什么方法
  shape.draw2(f = str => println(s"$str"))

  def test(x: String)(f :String => Unit): Unit = {
    f(s"你好test str $x ${this.toString}")
  }

  test("aa"){str => println(s"调用的时候进行的操作 $str")}

}
