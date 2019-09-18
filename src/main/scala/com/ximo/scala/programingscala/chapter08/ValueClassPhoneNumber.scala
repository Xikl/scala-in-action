package com.ximo.scala.programingscala.chapter08

object ValueClassPhoneNumber extends App {

  class USPhoneNumber(val s: String) extends AnyVal {

    override def toString: String = {
      val digs = digits(s)
      val areaCode = digs.substring(0, 3)
      val exchange = digs.substring(3, 6)
      val subnumber = digs.substring(6,10) // “客户编号”
      s"($areaCode) $exchange-$subnumber"
    }
    def digits(str: String): String = str.replaceAll("""\D""", "")
  }

  val number = new USPhoneNumber("987-654-3210")




}
