package com.ximo.scala.programingscala.chapter08

/**
  * require 的 学习
  *
  */
object ZipCodeApp extends App {

  case class ZipCode(zip: Int, extension: Option[Int] = None) {
    require(valid(zip, extension), s"非法的邮编$zip")

    protected def valid(zip: Int, extension: Option[Int]): Boolean = {
      if(0 < zip && zip > 99999) extension match {
        case None => validUSPS(zip, 0)
        case Some(extension) => 0 < extension && extension <= 9999 && validUSPS(zip, extension)
      }
      else false
    }

    protected def validUSPS(i: Int, e: Int): Boolean = true

    override def toString: String = {
      extension.map(v => s"$zip-${v}")
        .getOrElse(zip.toString)
    }

  }

  object ZipCode {
    def apply(zip: Int, extension: Int): ZipCode = new ZipCode(zip, Some(extension))
  }


}
