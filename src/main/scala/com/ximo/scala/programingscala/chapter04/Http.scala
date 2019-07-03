package com.ximo.scala.programingscala.chapter04

/**
  * 对封闭基类的实例做模式匹配时，如果 case 语句覆盖了所有当前文件定义
  * 的类型，那么匹配就是全覆盖的。由于不允许有其他用于自定义的子类型，
  * 随着项目演进，匹配的全覆盖性也不会丧失
  *
  * @author xikl
  * @date 2019/7/3
  */
object Http extends App {

  /**
    * 定义了一个封闭的抽象基类。由于该类被定义为封闭的，其子类型必须定义在本文
    * 件内, 放在别的类会报错
    *
    */
  sealed abstract class HttpMethod() {
    def body: String
    def bodyLength: Int = body.length
  }

  case class Connect(body: String) extends HttpMethod
  case class Delete (body: String) extends HttpMethod
  case class Get (body: String) extends HttpMethod
  case class Head (body: String) extends HttpMethod
  case class Options(body: String) extends HttpMethod
  case class Post (body: String) extends HttpMethod
  case class Put (body: String) extends HttpMethod
  case class Trace (body: String) extends HttpMethod

  def handle(method: HttpMethod) = method match {
    case Connect (body) => s"connect: (length: ${method.bodyLength}) $body"
    case Delete (body) => s"delete: (length: ${method.bodyLength}) $body"
    case Get (body) => s"get: (length: ${method.bodyLength}) $body"
    case Head (body) => s"head: (length: ${method.bodyLength}) $body"
    case Options (body) => s"options: (length: ${method.bodyLength}) $body"
    case Post (body) => s"post: (length: ${method.bodyLength}) $body"
    case Put (body) => s"put: (length: ${method.bodyLength}) $body"
    case Trace (body) => s"trace: (length: ${method.bodyLength}) $body"
  }

  val methods = Seq(
    Connect("connect body..."),
    Delete ("delete body..."),
    Get ("get body..."),
    Head ("head body..."),
    Options("options body..."),
    Post ("post body..."),
    Put ("put body..."),
    Trace ("trace body...")
  )
  methods foreach(_ => println(handle(_)))

}
