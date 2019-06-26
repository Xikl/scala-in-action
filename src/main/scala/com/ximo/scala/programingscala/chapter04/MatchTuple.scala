package com.ximo.scala.programingscala.chapter04

/**
  * 元组的匹配
  *
  * @author xikl
  * @date 2019/6/26
  */
object MatchTuple {

  val langs = Seq(
    ("Scala", "Martin", "Odersky"),
    ("Clojure", "Rich", "Hickey"),
    ("Lisp", "John", "McCarthy")
  )

  /**
    * Found Scala
    * Found other language: Clojure (Rich, Hickey)
    * Found other language: Lisp (John, McCarthy)
    *
    */
  for (tuple <- langs) {
    tuple match {
      case ("Scala", _, _) => println("Found scala")
      case (lang, first, last) =>
        println(s"found other language: $lang($first, $last)")
    }
  }




}
