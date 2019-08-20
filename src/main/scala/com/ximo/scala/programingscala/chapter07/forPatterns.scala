package com.ximo.scala.programingscala.chapter07

/**
  *
  *
  * @author xikl
  * @date 2019/8/20
  */
object forPatterns {

  val ignoreRegex = """^\s*(#.*|\s*)$""".r
  val kvRegex = """^\s*([^=]+)\s*=\s*([^#]+)\s*.*$""".r

  val properties =
    """
      |# Book properties
      |
      |book.name = Programming Scala, Second Edition # A comment
      |book.authors = Dean Wampler and Alex Payne
      |book.publisher = O'Reilly
      |book.publication-year = 2014
    """.stripMargin

  val paris = for {
    prop <- properties.split("\n")
    if ignoreRegex.findFirstIn(prop).isEmpty
    // 正则匹配 模式表达式
    kvRegex(key, value) = prop
  } yield (key.trim, value.trim)


}
