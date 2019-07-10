package com.ximo.scala.programingscala.chapter05


/**
  *
  *
  * @author xikl
  * @date 2019/7/9
  */
object JavaDatabaseApi extends App {

  /** 声明一个异常 */
  case class InvalidColumnName(name: String)
    extends RuntimeException(s"非法列名 $name")

  /** 声明一个接口 */
  trait Row{
    def getInt(columnName: String): Int
    def getDouble(columnName: String): Double
    def getText(columnName: String): String
  }

  case class JRow(representation: Map[String, Any]) extends Row {
    // scala如何实现类似java的Xxxx.class
    // 答案就是隐式转换
//    private def get(columnName: String):Any =
//      representation.getOrElse(columnName, throw InvalidColumnName(columnName))

//    private def get[R](columnName: String, result: Class[R]): R =
//      representation.getOrElse(columnName, throw InvalidColumnName(columnName)).asInstanceOf[R]
//
//    override def getInt(columnName: String): Int = get(columnName, Integer.TYPE)
//
//    override def getDouble(columnName: String): Double = get(columnName, java.lang.Double.TYPE)
//
//    override def getString(columnName: String): String = get(columnName, String.class)

    private def get(colName: String): Any =
      representation.getOrElse(colName, throw InvalidColumnName(colName))
    def getInt (colName: String): Int = get(colName).asInstanceOf[Int]
    def getDouble(colName: String): Double = get(colName).asInstanceOf[Double]
    def getText (colName: String): String = get(colName).asInstanceOf[String]
  }

  object JRow{
    def apply(pairs: (String, Any)*): JRow = new JRow(Map(pairs :_*))
  }

  /**
    * 在隐式对象中，我们使用了一个隐式类对 Java 的 JRow 类进行封装，而该封装类中提供了
    * 我们想要的 get[T] 方法。我们将这些类称为隐式转换（implicit conversion）。这一知识点
    * 我们将在本章后面的篇幅中谈论到。现在，你只需要了解使用隐式转换后我们可以对 JRow
    * 实例调用 get[T] 方法，就好像该方法就是为该实例定义的那样。
    *
    * @param jRow 接受一个JRow类型，并且传入SRow的构造函数
    */
  implicit class SRow(jRow: JRow){
    def get[T](columnName: String)(implicit toT: (JRow, String) => T): T =
      toT(jRow, columnName)
  }

  // 添加隐式转化
  implicit val jRowToInt: (JRow, String) => Int =
    (jRow, columnName) => jRow.getInt(columnName)

  implicit val jRowToDouble: (JRow, String) => Double =
    (jRow, columnName) => jRow.getDouble(columnName)

  implicit val jRowToString: (JRow, String) => String =
    (jRow, columnName) => jRow.getText(columnName)

  // 开始调用
  val row = JRow("one" -> 1, "two" -> 2.2, "three" -> "三")

  val oneValue1: Int = row.get("one")
  val twoValue1: Double = row.get("two")
  val threeValue1: String = row.get("three")
  println(oneValue1)
  println(twoValue1)
  println(threeValue1)

  val oneValue2 = row.get[Int]("one")
  val twoValue2 = row.get[Double]("two")
  val threeValue2 = row.get[String]("three")




}
