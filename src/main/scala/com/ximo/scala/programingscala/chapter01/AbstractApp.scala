package com.ximo.scala.programingscala.chapter01

import java.io.{BufferedInputStream, File, FileInputStream}

/**
  *
  *
  * @author xikl
  * @date 2019/6/17
  */
object AbstractApp {

  /**
    * 可以使用 定义一个参数化类型 就是泛型
    * <code>
    *   abstract class BulkReader[In] {
    *     val source: In
    *   }
    *   </code>
    */
  abstract class BulkReader {
    /** 类型成员 */
    type In
    /** 不可变变量 */
    val source: In

    /**
      * read 抽象方法
      *
      * @return
      */
    def read: String

  }

  /**
    * <code>
    *   class StringBulkReader(val source: String) extends BulkReader[String]{ ... }
    *
    * </code>
    *
    * @param source
    */
  class StringBulkReader(val source: String) extends BulkReader {
    type In = String

    def read: String = source
  }

  /**
    *
    * 省略type类型 类型成员变量
    * class FileBulkReader(val source: File) extends BulkReader[File] { ... }
    *
    * @param source
    */
  class FileBulkReader(val source: File) extends BulkReader {

    type In = File

    override def read: String = {
      val in = new BufferedInputStream(new FileInputStream(source))
      val numBytes = in.available()
      val bytes = new Array[Byte](numBytes)
      in.read(bytes, 0, numBytes)
      new String(bytes)
    }
  }

  println(new StringBulkReader("Hello Scala!").read)

  println(new FileBulkReader(new File("yours file path")).read)

}
