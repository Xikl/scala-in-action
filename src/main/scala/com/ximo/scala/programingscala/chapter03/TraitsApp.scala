package com.ximo.scala.programingscala.chapter03

/**
  *
  *
  * @author xikl
  * @date 2019/6/25
  */
class TraitsApp {

  class ServiceImportant(name: String) {
    def work(i: Int): Int = {
      println(s"this$name:ServiceImportant: Doing important things! $i")
      i + 1
    }
  }

  val service1 = new ServiceImportant("service1")

  (1 to 3) foreach (i => println(s"Result: ${service1.work(i)}"))

  /**
    * 声明一个接口类
    *
    */
  trait Logging {
    def info(message: String): Unit

    def warning(message: String): Unit

    def error(message: String): Unit

  }

  trait StdoutLogging extends Logging {
    override def info(message: String): Unit = println(s"info: $message")

    override def warning(message: String): Unit = println(s"warning: $message")

    override def error(message: String): Unit = println(s"error: $message")
  }

  val service2 = new ServiceImportant("service2") with StdoutLogging {
    override def work(i: Int): Int = {
      info(s"Starting work: i = $i")
      val result = super.work(i)
      info(s"Ending work: i = $i, result = $result")
      result
    }
  }

  (1 to 3) foreach(i => println(s"Result: ${service2.work(i)}"))


}
