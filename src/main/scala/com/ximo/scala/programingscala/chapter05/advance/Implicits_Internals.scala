package com.ximo.scala.programingscala.chapter05.advance

import java.io.File

import scala.io.Source

/**
  *
  *
  * @author xikl
  * @date 2019/7/23
  */
object Implicits_Internals {

  class RichFile(val file: File) {
    def read: String = {
      val source = Source.fromFile(file.getPath)
      try {
        source.mkString
      } finally {
        // 关闭流
        source.close()
      }
    }
  }

  class File_Impkicits(path: String) extends File(path)

  // 伴生对象 来隐式转化
  object File_Impkicits {
    implicit def fileToRichFile(file: File): RichFile = new RichFile(file)
  }

  def main(args: Array[String]): Unit = {
    new File_Impkicits("your file path").read
  }

}
