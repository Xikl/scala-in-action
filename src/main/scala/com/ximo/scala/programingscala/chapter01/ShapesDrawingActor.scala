package com.ximo.scala.programingscala.chapter01

import akka.actor.Actor

/**
  *
  *
  * @author 朱文赵
  * @date 2019/3/8 18:08 
  */
object Message {

  // Exit 和 Finished 对象中不包含任何状态，它们起到了标志的作用
  object Exit

  object Finished

  case class Response(message: String)

}


class ShapesDrawingActor extends Actor{
  import Message._

  override def receive: Receive = {
    case s: Shape =>
      s.draw(str => println(s"ShapesDrawingActor $str"))
      sender ! Response(s"ShapesDrawingActor: $s drawn")
      // 两种写法等价
//      sender.!(Response(s"ShapesDrawingActor: $s drawn"))
    case Exit =>
      println("Exiting")
      sender ! Finished
    case _ =>
      val response = Response("Unknown message")
      println(s"ShapesDrawingActor: $response")
      sender ! response

  }
}
