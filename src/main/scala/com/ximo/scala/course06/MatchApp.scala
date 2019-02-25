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

  def judgeGrade(name: String, grade: String): Unit = {
    grade match {
      case "A" => println("good")
      case "B" => println("not bad")
      case "C" => println("emmm")
      case _ if name == "lisi" => println("sssss")
      case _ => println("sssss")
    }

  }

  /**
    * 数组匹配
    *
    * @param array
    */
  def greeting(array: Array[String]): Unit = {
    array match {
      case Array("java") => println("hi java")
      case Array(x, y) => println("hi" + x + y)
      case Array("java", _*) => println("hi java and others")
      case _ => println("hi everybody")
    }
  }

  def greetingList(list: List[String]): Unit = {
    list match {
      case "java" :: Nil => println("hi java")
      //      case x :: y :: Nil => println("hi" + x + y)
      case "java" :: tail => println("hi java and others")
      case _ => println("hi eve")
    }
  }

  greetingList(List("java", "lisi"))

  /** 类型处理 */
  def matchType(obj: Any): Unit = {
    obj match {
      case _: Int => println("int")
      case _: String => println("String")
      case _: Map[_, _] => println("map")
      case _ => println("unknown")
    }
  }

  /** 异常处理 */
  def handleException(): Unit = {
    try {
      val i = 10 / 0
      println(i)
    } catch {
      case e: ArithmeticException => println("数字错误")
      case e: Exception => println(e.getMessage)
    } finally {
      // close
    }
  }

  def caseClassMatch(person: Person): Unit ={
    person match {
      case CTO(_, _) => println("CTO")
      case Employee(_, _) => println("employee")
      case Other(_) => println("other")
    }
  }

  class Person
  case class CTO(name:String, floor:String) extends Person
  case class Employee(name:String, floor:String) extends Person
  case class Other(name:String) extends Person
}
