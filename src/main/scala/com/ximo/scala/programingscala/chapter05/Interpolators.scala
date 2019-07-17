package com.ximo.scala.programingscala.chapter05

import scala.util.parsing.json.JSONObject

/**
  * 自定义的字符串插入器
  *
  * @author xikl
  * @date 2019/7/17
  */
object Interpolators extends App {

  implicit class jsonForStringContext(val sc: StringContext) {
    def json(values: Any*): JSONObject = {
      val keyRE = """^[\s{,]*(\S+):\s*""".r
      // 模式匹配 正则
      // parts 分成三部分 分别是{name: $name, book: $book} 出去表达式的三部分 牛逼！
      val keys = sc.parts map{
        case keyRE(key) => key
        case str => str
      }

      val keyValues = keys zip values
      JSONObject(keyValues.toMap)
    }
  }

  val name = "zwz test"
  val book = "scala in action"
  val jsonObj = json"{name: $name, book: $book}"
  println(jsonObj)


}
