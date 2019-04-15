package com.ximo.scala.programingscala.chapter01


/** 此处声明了一个表示二维点的类 */
case class Point(x: Double = 0.0, y: Double = 0.0)

/** 几何图形类 */
abstract class Shape {
  /**
    * draw方法接受一个函数参数。每个图形对象都会将自己的字符格式传给函数f，
    * 由函数f执行绘制工作。
    *
    * @param f
    */
  def draw(f: String => Unit): Unit = f(s"draw ${this.toString}")
}

/** 圆形 */
case class Circle(center: Point, radius: Double) extends Shape

/** 矩形 */
case class Rectangle(lowerLeft: Point, height: Double, width: Double) extends Shape

/** 三角形 */
case class Triangle(point1: Point, point2: Point, point3: Point) extends Shape

/**
  *
  *
  * @author 朱文赵
  * @date 2019/3/8 16:44
  */
object shapes {

  """
    |case 关键字的另一个特征便是让编译器自动为我们生成许多
    |方法，其中包括了类似于 Java 语言中 String 、 equals 和 hashCode 方法。每个点显示的输
    |出信息，如 Point(2.0,0.0) ，其实是 toString 方法的输出
  """.stripMargin


  def main(args: Array[String]): Unit = {
    val p00 = Point()
    //    val p001 = new Point()

    val p20 = Point(2.0)
    println(p00 == p20)

    val p20b = Point(2.0)

    println(p20 == p20b)

    val p02 = Point(y = 3.0)

    // case class 会自动生成 equals方法进行比较 与 java 不同的操作
    // java 是= 比较引用 equals才是比较类是否相等

    """
      |伴生类
      |case class 会自动生成伴生类
    """.stripMargin

    val p30 = Point.apply(2.0, 3.0)
    val p30b = Point(2.0, 3.0)


  }
}
