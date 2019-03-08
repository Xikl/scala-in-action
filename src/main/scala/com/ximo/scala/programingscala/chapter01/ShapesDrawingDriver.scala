package com.ximo.scala.programingscala.chapter01

import akka.actor.{Props, Actor, ActorRef, ActorSystem}
import com.typesafe.config.ConfigFactory

private object start

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
  }

}

class ShapesDrawingDriver(drawingActor: ActorRef) extends Actor{
  import Message._

  override def receive: Receive = ???
}
