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

  implicit class SRow(jRow: JRow){
    def get[T](columnName: String)(implicit toT: (JRow, String) => T): T =
      toT(jRow)
  }



}
