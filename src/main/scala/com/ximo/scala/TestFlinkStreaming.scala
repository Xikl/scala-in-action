package com.ximo.scala

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

/**
  *
  *
  * @author 朱文赵
  * @date 2019/6/17 12:17 
  */
object TestFlinkStreaming {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val someIntegers: DataStream[Long] = env.generateSequence(0, 1000)

    someIntegers.iterate(
      iteration => {
        val minusOne = iteration.map(_ - 1)
        val stillGreaterThanZero = minusOne.filter(_ > 0)
        val lessThanZero = minusOne.filter(_ <= 0)
        return (stillGreaterThanZero, lessThanZero)
      }

    )
  }


}
