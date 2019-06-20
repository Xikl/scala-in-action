package com.ximo.scala.programingscala.chapter03

import scala.io.Source
import scala.util.control.NonFatal
import scala.language.reflectiveCalls

/**
  *
  *
  * @author xikl
  * @date 2019/6/20
  */
class TryCatchArm {

  /**
    * 构建小型领域特定语言（DSL）
    *
    */

  object manage {
    /**
      * 奇怪的apply方法
      * resource： => R 传名函数 懒加载 by-name parameter
      *
      * @param resource => R 可以理解为调用的时候忽略括号的一个方法
      * @param f R => T 的函数
      * @tparam R <: 表达R是一个的子类 这里 他是 <code>{def close(): Unit}</code>的子类
      * @tparam T 返回值
      */
    def apply[R <: {def close() : Unit}, T](resource: => R)(f: R => T): Unit = {
      var res: Option[R] = None
      try {
        // 在这里被执行了一次
        res = Some(resource)
        f(res.get)
      } catch {
        case NonFatal(e) => println(s"non fatal exception! $e")
      } finally {
        if (res.isDefined) {
          println(s"closing resource...")
          res.get.close()
        }
      }
    }

  }

  /**
    * 采用匿名内部类的方式来进行操作
    * @see Supplier  () => R
    *
    */
  object manage2{

    /**
      *  假设所有的Source类都实现了Closeable 相当于 <code>R <: Closeable</code>
      *
      * @param getSources () => R supplier
      * @param f
      * @tparam R
      * @tparam T
      */
    def apply[R <: {def close(): Unit}, T](getSources: () => R)(f: R => T): Unit ={
      var res: Option[R] = None
      try{
        res = Some(getSources())
        f(res.get)
      }catch {
        case NonFatal(e) => println(s"non fatal exception! $e")
      }finally {
        if (res.isDefined) {
          println("closing")
          res.get.close()
        }
      }
    }
  }

  object TryCatchARM {
    def main(args: Array[String]): Unit = {
      args foreach countLines
    }

    def countLines(fileName: String): Unit = {
      println()
      // 传名函数 懒加载
      manage(Source.fromFile(fileName)) { source =>
        val size = source.getLines.size
        println(s"file $fileName has size: $size lines")
        if (size > 20) {
          throw new RuntimeException("Big file")
        }
      }
    }

    /**
      * 调用manager2的方法
      *
      * @param fileName 文件名
      */
    def countLines2(fileName: String): Unit = {
      println()
      // 延迟加载
      manage2(() => Source.fromFile(fileName)) { source =>
        val size = source.getLines.size
        println(s"file $fileName has size: $size lines")
        if (size > 20) {
          throw new RuntimeException("Big file")
        }
      }
    }

  }


}
