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

  object StringUtilV1 {
    def joiner(strings: String*): String = strings.mkString("-")

    // strings :_* 告诉编译器你希望列表 string 作为可变参数列表
    // 第二个joiner方法调用了第一个joiner方法 所以必须要指定返回类型
    def joiner(strings: List[String]): String = joiner(strings: _*)
  }

  StringUtilV1.joiner(List("11", "sss"))

  /**
    * 返回的是List[Any]
    *
    * @param strings
    * @return
    */
  def makeList(strings: String*) = {
    if (strings.isEmpty) {
      List(0)
    } else {
      strings.toList
    }
  }

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
