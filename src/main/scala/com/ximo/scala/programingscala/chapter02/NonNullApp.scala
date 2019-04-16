package com.ximo.scala.programingscala.chapter02

/**
  *
  * @author xikl
  * @date 2019/3/12
  */
object NonNullApp {

  """
    |Some
    |Option
    |None
  """.stripMargin

  val stateCapitals = Map(
    "Alabama" -> "Montgomery",
    "Alaska" -> "Juneau",
    "Wyoming" -> "Cheyenne")

  println( "Get the capitals wrapped in Options:" )
  println( "Alabama: " + stateCapitals.get("Alabama") )
  println( "Wyoming: " + stateCapitals.get("Wyoming") )
  println( "Unknown: " + stateCapitals.get("Unknown") )

  // 避免出现空
  println( "Unknown: " + stateCapitals.get("Unknown").getOrElse("sss") )
  println( "Unknown: " + stateCapitals.get("Unknown").orElse(Some("sss")) )
  println( "Unknown: " + stateCapitals.getOrElse("Unknown", "sss") )


  """
    |关键字 sealed 告诉编译器，所有的子类必须在同一个源文件中声明。而在 Scala 库中，
    |Some 与 None 就是与 Option 声明在同一源文件中的。这一技术有效防止了 Option 派生其他
    |子类型。
  """.stripMargin


}
