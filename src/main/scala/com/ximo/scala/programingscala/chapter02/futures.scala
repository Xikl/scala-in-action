package com.ximo.scala.programingscala.chapter02


import scala.concurrent.Future
import scala.util.Success

/**
  *
  * @author xikl
  * @date 2019/3/11
  */
object futures {

  def sleep(millis: Long): Unit = {
    Thread.sleep(millis)
  }

  def doWork(index: Int): Unit = {
    sleep((math.random() * 1000).toLong)
    index
  }

  (1 to 5) foreach { index =>
    val future = Future {
      doWork(index)
    }
    future onComplete {
      case Success(value) => println(s"success! returned: $value")
      case _ => println("some error")
    }
    //    future onSuccess{
    //      case answer: Int => println(s"success! returned: $answer")
    //    }
    //    future onFailure{
    //      case e => println(s"error, $e")
    //    }

  }

  sleep(1000)
  println("done")

}
