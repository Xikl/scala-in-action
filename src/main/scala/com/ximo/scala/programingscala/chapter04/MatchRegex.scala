package com.ximo.scala.programingscala.chapter04

/**
  *
  *
  * @author xikl
  * @date 2019/7/3
  * @see scala.util.matching.Regex
  */
object MatchRegex extends App {

  // 正则都可以匹配
  // [^,]匹配不是逗号的
  val BookExtractorRegex =
    """Book: title=([^,]+),\s+author=(.+)""".r

  val MagazineExtractorRegex =
    """Magazine: title=([^,]+),\s+issue=(.+)""".r

  val catalog = Seq(
    "Book: title=Programming Scala Second Edition, author=Dean Wampler",
    "Magazine: title=The New Yorker, issue=January 2014",
    "Unknown: text=Who put this here??"
  )

  // 模式匹配新写法 少了match
  // 我们用三重双引号来表示正则表达式字符串，否则，就不得不对正则表达式的反斜杠进行
  //转义，例如用 \\s 表示 \s 。
  catalog.foreach {
    case BookExtractorRegex(title, author) =>
      println(s"""Book "$title", written by $author""")
    case MagazineExtractorRegex(title, issue) =>
      println(s"""Magazine "title", issue $issue""")
    case entry => println(s"Unrecognized entry: $entry")
  }

}
