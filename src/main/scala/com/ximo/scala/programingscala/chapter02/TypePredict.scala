package com.ximo.scala.programingscala.chapter02

import com.fasterxml.jackson.module.scala.util.Strings

import scala.collection.immutable.HashMap
import scala.collection.mutable

/**
  *
  * @author xikl
  * @date 2019/3/12
  */
object TypePredict {

  val map1 = new mutable.HashMap[String, String]
  val map2: HashMap[String, String] = new HashMap
  val intToStringMap: HashMap[Integer, String] = new HashMap

  /**
    * 类型推断 养成一个好习惯 方法都应该编写返回类型
    *
    * @author 朱文赵
    * @date 2019/4/17 11:59
    */
  object StringUtilsV1 {

    /**
      * mkString
      *
      * @param strings
      * @return
      */
    def joiner(strings: String*): String = strings.mkString("-")

    /**
      * 调用上面的方法 将list变为一个变长数组 : _*
      *
      * @param stringList
      * @return
      */
    def joiner(stringList: List[String]): String = joiner(stringList: _*)

  }

  StringUtilsV1.joiner(List("11", "sss"))

  /**
    * 返回的是List[Any]
    *
    * @param strings
    * @return
    */
  def makeList(strings: String*) = {
    if (strings.isEmpty) {
      // 这里本来就有问题 下面是一个 字符串 然后 这里是一个 List(0)
      List(0)
    } else {
      strings.toList
    }
  }

  /**
    * 空列表产生
    * @see List#Nil
    * @param strings
    * @return
    */
  def makeList2(strings: String*) = {
    if (strings.isEmpty) {
//      Nil
      List.empty[String]
    } else {
      strings.toList
    }
  }

  /**
    * "=" 等号 不要忘记
    *
    * @param i
    * @return
    */
  def double(i: Int) = 2 * i

  println(double(2))

  // 最后一个"""需要加一个空格？
  """He exclaimed, "Scala is great!" """

  val a1 = """
    xxx 你好 yyy
    xxx aaaa yyy
  """.stripPrefix("xxx").stripSuffix("yyy")

}
