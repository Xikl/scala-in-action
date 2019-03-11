package com.ximo.scala.programingscala.chapter01

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

private object Start

/**
  *
  *
  * @author 朱文赵
  * @date 2019/3/8 18:29 
  */
object ShapesDrawingDriver {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("DrawingActorSystem", ConfigFactory.load())

    val drawer = system.actorOf(
      Props(new ShapesDrawingActor), "drawingActor"
    )

    val driver = system.actorOf(
      Props(new ShapesDrawingDriver(drawer)), "drawingService"
    )
    // 调用方法 传入Start
    driver ! Start
  }

}

class ShapesDrawingDriver(drawingActor: ActorRef) extends Actor {

  import Message._

  override def receive: Receive = {
    case Start =>
      drawingActor ! Circle(Point(), 1.0)
      drawingActor ! Rectangle(Point(), 2, 5)
      drawingActor ! 3.14159
      drawingActor ! Triangle(Point(), Point(2.0, 1.0), Point(1.0, 2.0))
      drawingActor ! Exit
    case Finished =>
      println("cleaning up")
    //      context.system.shutdown()
    case response: Response =>
      println(s"Response:$response")
    case _ =>
      println("unknown")

  }
}
