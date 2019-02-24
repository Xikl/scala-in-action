package com.ximo.scala.course06

import scala.util.Random

/**
  *
  * @author xikl
  * @date 2019/2/24
  */
object MatchApp extends App {

  val names = Array("python", "java", "scala")

  val name = names(Random.nextInt(names.length))

  name match {
    case "python" => println("python")
    case "java" => println("java")
    case _ => println("sss")
  }

  def judgeGrade(grade: String): Unit ={
    grade match {
      case "A" => println("good")
      case "B" => println("not bad")
      case "C" => println("emmm")
    }

  }


}
