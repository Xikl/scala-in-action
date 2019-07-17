package com.ximo.scala.programingscala.chapter05.advance

import java.io.File

import scala.io.Source

/**
  *
  *
  * @author xikl
  * @date 2019/7/17
  */
// 这里的RichFile相当于File的增强类 需要将被增强的类作为参数传入构造器中
class RichFile(file: File) {

  def read(): String  = {
    val source = Source.fromFile(file.getPath)
    try{
      source.mkString
    }finally {
      // 关闭流
      source.close()
    }
  }
}

// implicit是隐式转换的关键字 这里定义一个隐式转换函数把当前类型转换成增强的类型
object Context{
  implicit def fileToRichFile(file: File): RichFile = new RichFile(file)
}

// 主函数
object HelloImplicitConversions{
  def main(args: Array[String]): Unit = {
    // 导入隐式转换
    import Context.fileToRichFile

    //File类本身没有read方法 通过隐式转换完成
    //这里的read方法是RichFile类中的方法  需要通过隐式转换File --> RichFile
    val filePath = new File("E:\\text.txt").read()
    println(filePath)
  }
}