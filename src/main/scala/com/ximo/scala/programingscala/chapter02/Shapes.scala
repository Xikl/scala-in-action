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
  val p2: Point = p1.copy(y = 6.6)

  abstract class Shape() {
    def draw(offset: Point = Point())(f: String => Unit): Unit = {
      f(s"draw something offset = $offset, ${this.toString}")
    }
  }

  case class Circle(center: Point, radius: Double) extends Shape

  case class Rectangle(lowerLeft: Point, height: Double, width: Double) extends Shape

  val shape = Circle(Point(), 2.0)
  shape.draw(Point(1.0, 2.0))(str => println(s"Drawing $str"))

  shape.draw(Point(2.0, 2.0)){ str => println(s"drawing $str")}


  def test(x: String)(f :String => Unit): Unit = {
    f(s"你好test str $x ${this.toString}")
  }

  test("aa"){str => println(s"调用的时候进行的操作 $str")}

}
