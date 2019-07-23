package com.ximo.scala.programingscala.chapter05.advance

import java.io.File

import scala.io.Source

/**
  *
  *
  * @author xikl
  * @date 2019/7/23
  */
object Implicits_Class_Test {

  object Context {

    implicit class FileEnhance(file: File) {
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

    implicit class Op(x: Int) {
      def add(second: Int): Int = x + second
    }

  }

  object Implicits_Class{
    def main(args: Array[String]): Unit = {
      import  Context._

      // 增强类的方法
      println(new File("you file path").read)

      // 增强类的方法
      println(1.add(3))
    }
  }

}
