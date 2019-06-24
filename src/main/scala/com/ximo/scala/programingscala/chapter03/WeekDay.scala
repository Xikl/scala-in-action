package com.ximo.scala.programingscala.chapter03

/**
  *
  * 礼拜
  * @author xikl
  * @date 2019/6/25
  */
object WeekDay extends Enumeration {

  type WeekDay = Value
  // 不需要对枚举值进行命名
  // scala 可以对他进行批量赋值 而 java 却不行 如 int i, j, k = 4
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value

  def isWorkingDay(day: WeekDay) = !(day == Sat || day == Sun)

  def printWeekDay(f: WeekDay => Boolean): Unit = WeekDay.values filter f foreach println



}
