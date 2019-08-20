package com.ximo.scala.programingscala.chapter07

/**
  *
  *
  * @author xikl
  * @date 2019/8/19
  */
object ForEachApp extends App {

  val states = List("Alabama", "Alaska", "Virginia", "Wyoming")

  // states foreach println
  for(s <- states) println(s)

  // states map (_.toUpperCase)
  for (s <- states) yield println(s.toUpperCase())

  val result1 = for {
    // 每个字符串
    s <- states
    // 每个char
    c <- s
    // 只要小写的
    if c.isLower
  } yield s"$c - ${c.toUpper}"

  states flatMap (_.toSeq map (c => s"$c-${c.toUpper}"))

  states flatMap(_.toSeq withFilter(_.isLower) map(c => s"$c - ${c.toUpper}"))

  for {
    s <- states
    c <- s
    if c.isLower
    c2 = s"$c - ${c.toUpper}"
  } yield c2
}
