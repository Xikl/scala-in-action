package com.ximo.scala.programingscala.chapter03

import scala.io.Source
import scala.util.control.NonFatal

/**
  *
  *
  * @author xikl
  * @date 2019/6/20
  */
object ScalaTryCatchFinal {

  def main(args: Array[String]): Unit = {
    args foreach countLines
  }

  def countLines(fileName: String): Unit = {
    println("start:")
    var source: Option[Source] = None

    try{
      source = Some(Source.fromFile(fileName))
      val size = source.get.getLines().size
      println(s"file $fileName has $size lines")
    }catch{
      case NonFatal(e) => println(s"Non fatal exception! $e")
    }finally {
      // 二者一样的
//      source.foreach(_.close())
//      or
      // for 推导式 当他是none的时候 不会进行任何操作
      for (s <- source) {
        s.close()
      }
    }

  }


}
