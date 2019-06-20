package com.ximo.scala

import org.apache.flink.api.common.typeinfo.TypeInformation
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

/**
  *
  *
  * @author 朱文赵
  * @date 2019/6/17 12:17 
  */
object TestFlinkStreaming {

  /**
    * Error:(19, 37) could not find implicit value for evidence parameter of type org.apache.flink.api.common.typeinfo.TypeInformation[Long]
    * val minusOne = iteration.map(_ - 1)
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val someIntegers: DataStream[Long] = env.generateSequence(0, 1000)

    // 添加隐式参数
    implicit val typeInfo: TypeInformation[Long] = TypeInformation.of(classOf[Long])

    val iteratedStream = someIntegers.iterate(
      iteration => {
        val minusOne = iteration.map(_ - 1)
        val stillGreaterThanZero = minusOne.filter(_ > 0)
        val lessThanZero = minusOne.filter(_ <= 0)
        (stillGreaterThanZero, lessThanZero)
      }

    )
  }


}
