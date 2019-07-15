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
    * Scala Trait(特征) 相当于 Java 的接口，实际上它比接口还功能强大。
    *
    * 与接口不同的是，它还可以定义属性和方法的实现。
    *
    * 一般情况下Scala的类只能够继承单一父类，但是如果是 Trait(特征) 的话就可以继承多个，从结果来看就是实现了多重继承。
    *
    * 声明一个接口类
    *
    *
    */
  trait Logging {
    def info(message: String): Unit

    def warning(message: String): Unit

    def error(message: String): Unit

  }

  /**
    * 某种意义上来说更加像一个 抽象类
    *
    */
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
