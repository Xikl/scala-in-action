package com.ximo.scala.programingscala.chapter04

/**
  *
  *
  * @author xikl
  * @date 2019/7/3
  */
object MatchVarargList extends App {

  object Op extends Enumeration {
    type Op = Value

    /** 操作符 */
    val EQ = Value("=")
    val NE = Value("!=")
    val LTGT = Value("<>")
    val LT = Value("<")
    val LE = Value("<=")
    val GT = Value(">")
    val GE = Value(">=")

  }

  import Op._

  case class WhereOp[T](columnName: String, op: Op, value: T)

  case class WhereIn[T](columnName: String, value1: T, values: T*)

  val wheres = Seq(
    WhereIn("state", "IL", "CA", "VA"),
    WhereOp("state", EQ, "IL"),
    WhereOp("name", EQ, "Buck Trends"),
    WhereOp("age", GT, 29)
  )

  for (where <- wheres) {
    where match {
        // 匹配可变参数的形式 @ _*
      case WhereIn(col, value1, values @ _*) =>
        val valueString = (value1 +: values).mkString(",")
        println(s"WHERE $col IN ($valueString)")
      case WhereOp(col, op, value) =>
        println(s"WHERE $col $op $value")
      case _ => println(s"unknown error")
    }
  }



}
